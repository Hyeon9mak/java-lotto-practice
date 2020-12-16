package lotto.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.View.UserInput;
import lotto.View.View;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoRepository;
import lotto.domain.MatchedLottoRepository;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.utils.RandomUtils;

public class LottoService {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int DEFAULT_LOTTO_NUMBERS_SIZE = 6;
    private static final String COMMA = ",";
    public static LottoRepository buyLottosAmountUserPaid(LottoMoney lottoMoney) {
        LottoRepository lottoRepository = LottoRepository.newLottoRepository();
        int buyCount = lottoMoney.getCountBuyLotto();
        View.printCountBuyLotto(buyCount);
        for (int i = 0; i < buyCount; i++) {
            lottoRepository.addLotto(buyLotto());
        }
        View.printAllLottos(lottoRepository);
        return lottoRepository;
    }

    public static WinningLotto makeWinningLotto() {
        String lastWeekWinningNumbers = UserInput.getLastWeekWinningNumbers();
        Lotto winningLotto = Lotto.newLottoWithNumbers(createLottoNumbers(lastWeekWinningNumbers));
        int bonusBall = createBonusNumber(UserInput.getBonusBallNumber());
        return WinningLotto.newWinningLottoWithInput(winningLotto, bonusBall);
    }

    private static int createBonusNumber(String bonusBallNumber) {
        try {
            return Integer.parseInt(bonusBallNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 값을 입력해야 합니다.");
        }
    }

    private static Lotto buyLotto() {
        return Lotto.newLottoWithNumbers(createLottoNumbers());
    }

    private static Set<Integer> createLottoNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < DEFAULT_LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(RandomUtils.nextInt(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }
        return lottoNumbers;
    }

    private static Set<Integer> createLottoNumbers(String lastWeekWinningNumbers) {
        Set<Integer> setLottoNumbers = new HashSet<>();
        for (String number : lastWeekWinningNumbers.split(COMMA)) {
            setLottoNumbers.add(Integer.parseInt(number));
        }
        if (setLottoNumbers.size() < DEFAULT_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("당첨번호 6개가 입력되어야 합니다.");
        }
        return setLottoNumbers;
    }

    public static MatchedLottoRepository matchAllLottos(LottoRepository lottosOfUser,
        WinningLotto winningLotto) {
        MatchedLottoRepository matchedLottos = MatchedLottoRepository.newMatchedLottoRepository();
        lottosOfUser.lottos().stream().forEach(lotto -> {
            matchedLottos.addMatchedLotto(winningLotto.match(lotto));
        });
        return matchedLottos;
    }

    public static void printAllMatchResult(MatchedLottoRepository matchedLottos) {
        matchedLottos.getRankTable().forEach((rank, integer) -> {
            printMatchResult(rank, integer);
        });
    }

    private static void printMatchResult(Rank rank, Integer integer) {
        if (rank == Rank.SECOND) {
            View.printMatchResultBonus(rank.getCountOfMatch(), rank.getWinningMoney(), integer);
            return;
        }
        View.printMatchResult(rank.getCountOfMatch(), rank.getWinningMoney(), integer);
    }

    public static void printYield(MatchedLottoRepository matchedLottoRepositories,
        LottoMoney lottoMoney) {
        List<Integer> yield = new ArrayList<>();
        matchedLottoRepositories.getRankTable().forEach((rank, integer) -> {
            yield.add(integer * rank.getWinningMoney());
        });
        float totalYield = 0;
        for (Integer y : yield) {
            totalYield += y;
        }
        View.printYield(totalYield / lottoMoney.getMoney());
    }
}
