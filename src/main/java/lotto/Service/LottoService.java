package lotto.Service;

import java.util.HashSet;
import java.util.Set;
import lotto.View.UserInput;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRepository;
import lotto.domain.Money;

public class LottoService {

    private static final int DEFAULT_LOTTO_NUMBERS_SIZE = 6;

    public static void buyLottos() {
        LottoRepository lottoRepository = LottoRepository.newLottoRepository();
        Money money = Money.newMoneyWithInput(UserInput.getMoneyFromUser());
        int buyCount = money.getCountBuyLotto();
        for (int i = 0; i < buyCount; i++) {
            lottoRepository.addLotto(buyLotto());
        }
    }

    private static Lotto buyLotto() {
        return Lotto.newLottoWithNumbers(createLottoNumbers());
    }

    private static Set<LottoNumber> createLottoNumbers() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < DEFAULT_LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(LottoNumber.newLottoNumber());
        }
        return lottoNumbers;
    }
}
