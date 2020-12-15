package lotto.domain;

import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottos;

    private LottoRepository(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public LottoRepository newLottoRepositoryWithLottos(List<Lotto> lottos){
        return new LottoRepository(lottos);
    }
}
