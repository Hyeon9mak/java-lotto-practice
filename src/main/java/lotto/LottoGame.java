package lotto;

import lotto.Service.LottoService;
import lotto.domain.LottoRepository;
import lotto.domain.WinningLotto;

public class LottoGame {

    private LottoGame() {
    }

    public static LottoGame newLottoGame() {
        return new LottoGame();
    }

    public void run() {
        LottoRepository lottosOfUser = LottoService.buyLottosAmountUserPaid();
        WinningLotto winningLotto = LottoService.makeWinningLotto();
        LottoService.matchAllLottos(lottosOfUser, winningLotto);
    }
}
