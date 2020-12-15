package lotto;

import org.junit.Test;

public class LottoGameTest {

    @Test
    public void testNewLottoGame() {
        LottoGame lottoGame = LottoGame.newLottoGame();
        lottoGame.run();
    }
}
