package lotto.domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final Lotto lotto;
    private final int bonusNo;

    private WinningLotto(Lotto lotto, int bonusNo) {
        validateNumberRange(bonusNo);
        validateContain(lotto, bonusNo);
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public static WinningLotto newWinningLottoWithInput(Lotto lotto, int bonusNo) {
        return new WinningLotto(lotto, bonusNo);
    }

    public Rank match(Lotto userLotto) {
        int i = (int) userLotto.getLottoNumbers().stream()
            .filter(number -> lotto.getLottoNumbers().contains(number)).count();
        boolean isBonous = userLotto.getLottoNumbers().contains(bonusNo);
        return Rank.valueOf(i, isBonous);
    }

    private void validateNumberRange(int bonusNo) {
        if (bonusNo < MINIMUM_LOTTO_NUMBER || MAXIMUM_LOTTO_NUMBER < bonusNo) {
            throw new IllegalArgumentException("로또 번호는 1~45 정수만 입력 가능합니다.");
        }
    }

    private void validateContain(Lotto lotto, int bonusNo) {
        if (lotto.getLottoNumbers().contains(bonusNo)) {
            throw new IllegalArgumentException("동일한 로또 번호가 존재합니다.");
        }
    }
}
