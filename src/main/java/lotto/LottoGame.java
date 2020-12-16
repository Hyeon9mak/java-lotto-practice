package lotto;

import lotto.Service.LottoService;

public class LottoGame {

    private LottoGame() {
    }

    public static LottoGame newLottoGame() {
        return new LottoGame();
    }

    public void run() {
        LottoService.buyLottos();
    }
}
