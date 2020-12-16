package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private final List<Lotto> lottos = new ArrayList<>();

    private LottoRepository() {
    }

    public static LottoRepository newLottoRepository() {
        return new LottoRepository();
    }

    public void addLotto(Lotto lotto){
        lottos.add(lotto);
    }
}
