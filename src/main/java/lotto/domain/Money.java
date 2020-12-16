package lotto.domain;

public class Money {

    private static final int MINIMUM_LOTTO_BUY_MONEY = 1_000;

    private final int money;

    private Money(String input) {
        int money = validateMoneyInteger(input);
        validateMoneyOverThousand(money);
        this.money = money;
    }

    public static Money newMoneyWithInput(String input) {
        return new Money(input);
    }

    public int getCountBuyLotto(){
        return money / MINIMUM_LOTTO_BUY_MONEY;
    }

    private int validateMoneyInteger(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 구입금액이 정수가 아닙니다.");
        }
    }

    private void validateMoneyOverThousand(int money) {
        if (money < MINIMUM_LOTTO_BUY_MONEY) {
            throw new IllegalArgumentException("로또 구입을 위한 최소 금액은 " + MINIMUM_LOTTO_BUY_MONEY + "원 입니다.");
        }
    }

}
