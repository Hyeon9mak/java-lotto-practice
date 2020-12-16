package lotto.domain;

import java.util.Set;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final int MAXIMUM_NUMBERS_LENGTH = 6;

    private final Set<Integer> lottoNumbers;

    private Lotto(Set<Integer> lottoNumbers) {
        validateLottoNumbersLength(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto newLottoWithNumbers(Set<Integer> lottoNumbers){
        return new Lotto(lottoNumbers);
    }

    public Set<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

    private void validateLottoNumbersLength(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != MAXIMUM_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("로또 한 장당 번호는 총 6개여야 합니다.");
        }
    }
}
