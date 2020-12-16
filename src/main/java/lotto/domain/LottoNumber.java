package lotto.domain;

import lotto.utils.RandomUtils;

public class LottoNumber {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber newLottoNumber() {
        return new LottoNumber(RandomUtils.nextInt(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
    }

    public int getNumber() {
        return number;
    }
}
