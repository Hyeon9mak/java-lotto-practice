package lotto;

import lotto.service.LottoService;
import lotto.View.UserInput;
import lotto.domain.LottoMoney;
import lotto.domain.LottoRepository;
import lotto.domain.MatchedLottoRepository;
import lotto.domain.WinningLotto;

public class LottoGame {

    private LottoGame() {
    }

    public static LottoGame newLottoGame() {
        return new LottoGame();
    }

    public void run() {
        LottoMoney lottoMoney = LottoMoney.newMoneyWithInput(UserInput.getMoneyFromUser());
        LottoRepository lottosOfUser = LottoService.buyLottosAmountUserPaid(lottoMoney);
        WinningLotto winningLotto = LottoService.makeWinningLotto();
        MatchedLottoRepository matchedLottoRepositories = LottoService.matchAllLottos(lottosOfUser, winningLotto);
        LottoService.printAllMatchResult(matchedLottoRepositories);
        LottoService.printYield(matchedLottoRepositories, lottoMoney);
    }
}
