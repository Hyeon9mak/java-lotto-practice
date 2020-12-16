package lotto.domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNo;

    private WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public static WinningLotto newWinningLottoWithInput(Lotto lotto, int bonusNo) {
        return new WinningLotto(lotto, bonusNo);
    }

    public Rank match(Lotto userLotto) {
        int i = (int)userLotto.getLottoNumbers().stream()
            .filter(number -> lotto.getLottoNumbers().contains(number)).count();
        boolean isBonous = userLotto.getLottoNumbers().contains(bonusNo);
        return Rank.valueOf(i, isBonous);
    }
}
