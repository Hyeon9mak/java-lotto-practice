package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.View.UserInput;
import lotto.View.View;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoRepository;
import lotto.domain.MatchedLottoRepository;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class LottoService {

    public static LottoRepository buyLottosAmountUserPaid(LottoMoney lottoMoney) {
        LottoRepository lottoRepository = LottoRepository.newLottoRepository();
        int buyCount = lottoMoney.getCountBuyLotto();
        View.printCountBuyLotto(buyCount);
        for (int i = 0; i < buyCount; i++) {
            lottoRepository.addLotto(Lotto.newLotto());
        }
        View.printAllLottos(lottoRepository);
        return lottoRepository;
    }

    public static WinningLotto makeWinningLotto() {
        String lastWeekWinningNumbers = UserInput.getLastWeekWinningNumbers();
        Lotto winningLotto = Lotto.newLottoWithLastWeekWinningNumbers(lastWeekWinningNumbers);
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

    private static void printMatchResult(Rank rank, Integer integer) {
        if (rank == Rank.SECOND) {
            View.printMatchResultBonus(rank.getCountOfMatch(), rank.getWinningMoney(), integer);
            return;
        }
        View.printMatchResult(rank.getCountOfMatch(), rank.getWinningMoney(), integer);
    }
}
