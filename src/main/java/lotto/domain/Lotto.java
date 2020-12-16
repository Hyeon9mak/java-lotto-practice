package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import lotto.utils.RandomUtils;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {

    private static final String COMMA = ",";
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int DEFAULT_LOTTO_NUMBERS_SIZE = 6;

    private final Set<Integer> lottoNumbers;

    private Lotto(Set<Integer> lottoNumbers) {
        validateLottoNumbersLength(lottoNumbers);
        validateLottoNumberRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto newLotto() {
        return new Lotto(autoRandomLottoNumbers());
    }

    public static Lotto newLottoWithLastWeekWinningNumbers(String lastWeekWinningNumbers) {
        Set<Integer> setLottoNumbers = new HashSet<>();
        for (String number : lastWeekWinningNumbers.split(COMMA)) {
            validateInteger(number);
            setLottoNumbers.add(Integer.parseInt(number));
        }
        return new Lotto(setLottoNumbers);
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private static Set<Integer> autoRandomLottoNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < DEFAULT_LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(RandomUtils.nextInt(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }
        return lottoNumbers;
    }

    private void validateLottoNumbersLength(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != DEFAULT_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 한 장당 번호는 총 6개여야 합니다.");
        }
    }

    private void validateLottoNumberRange(Set<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < MINIMUM_LOTTO_NUMBER || MAXIMUM_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException("로또 번호 범위는 1~45 까지 입니다.");
        }
    }

    private static void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("로또 번호는 1~45 정수만 입력 가능합니다.");
        }
    }
}
