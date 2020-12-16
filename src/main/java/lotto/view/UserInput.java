package lotto.view;

import java.util.Scanner;

public class UserInput {

    private static final String REQUEST_INPUT_MONEY_FOR_BUY_LOTTOS = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LAST_WEEK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_INPUT_BONUS_BALL_NUMBERS = "보너스 볼을 입력해 주세요";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getMoneyFromUser() {
        System.out.println(REQUEST_INPUT_MONEY_FOR_BUY_LOTTOS);
        return scanner.nextLine();
    }

    public static String getLastWeekWinningNumbers() {
        System.out.println(REQUEST_LAST_WEEK_WINNING_NUMBERS);
        return scanner.nextLine();
    }

    public static String getBonusBallNumber() {
        System.out.println(REQUEST_INPUT_BONUS_BALL_NUMBERS);
        return scanner.nextLine();
    }
}
