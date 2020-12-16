package lotto.Service;

import java.util.HashSet;
import java.util.Set;
import lotto.View.UserInput;
import lotto.View.View;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoRepository;
import lotto.domain.WinningLotto;
import lotto.utils.RandomUtils;

public class LottoService {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int DEFAULT_LOTTO_NUMBERS_SIZE = 6;
    private static final String COMMA = ",";

    public static LottoRepository buyLottosAmountUserPaid() {
        LottoRepository lottoRepository = LottoRepository.newLottoRepository();
        LottoMoney lottoMoney = LottoMoney.newMoneyWithInput(UserInput.getMoneyFromUser());
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

    public static void matchAllLottos(LottoRepository lottosOfUser, WinningLotto winningLotto) {

    }
}
