package lotto.domain;

import java.util.Set;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final int MAXIMUM_NUMBERS_LENGTH = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbersLength(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto newLottoWithNumbers(Set<LottoNumber> lottoNumbers){
        return new Lotto(lottoNumbers);
    }

    private void validateLottoNumbersLength(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != MAXIMUM_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("로또 한 장당 번호는 총 6개여야 합니다.");
        }
    }
}
