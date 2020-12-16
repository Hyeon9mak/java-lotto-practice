package lotto.View;

import lotto.domain.LottoRepository;

public class View {

    private static final String BUY_COUNT_MESSAGE = "개를 구매했습니다.";

    public static void printCountBuyLotto(int buyCount) {
        System.out.println();
        System.out.println(buyCount + BUY_COUNT_MESSAGE);
    }

    public static void printAllLottos(LottoRepository lottoRepository) {
        lottoRepository.lottos().stream().forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
    }
}
