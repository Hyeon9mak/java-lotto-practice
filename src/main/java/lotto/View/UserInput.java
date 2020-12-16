package lotto.View;

import java.util.Scanner;

public class UserInput {

    private static final String REQUEST_INPUT_MONEY_FOR_BUY_LOTTOS = "구입금액을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getMoneyFromUser() {
        System.out.println(REQUEST_INPUT_MONEY_FOR_BUY_LOTTOS);
        return scanner.nextLine();
    }
}
