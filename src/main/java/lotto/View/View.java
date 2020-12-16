package lotto.View;

import lotto.domain.LottoRepository;

public class View {

    public static void printCountBuyLotto(int buyCount) {
        System.out.println();
        System.out.println(buyCount + "개를 구매했습니다.");
    }

    public static void printAllLottos(LottoRepository lottoRepository) {
        lottoRepository.lottos().stream()
            .forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
    }

    public static void printMatchResult(int countOfMatch, int winningMoney, int countOfSameRank) {
        System.out.println(countOfMatch + "개 일치 (" + winningMoney + "원)- " + countOfSameRank + "개");
    }

    public static void printMatchResultBonus(int countOfMatch, int winningMoney,
        int countOfSameRank) {
        System.out.println(
            countOfMatch + "개 일치, 보너스 볼 일치(" + winningMoney + "원)- " + countOfSameRank + "개");
    }

    public static void printYield(float yield) {
        System.out.println("총 수익률은 " + String.format("%.3f", yield) + "입니다.");
    }
}
