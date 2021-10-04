package baseball;

import nextstep.utils.Console;

public class InOutProcessor {

    private static final String INVALID_LENGTH = "[ERROR] 세 자리 숫자를 입력하세요";
    private static final String NOT_NUMBER = "[ERROR] 숫자를 입력하세요";
    private static final String DUPLICATION = "[ERROR] 서로 다른 숫자를 입력하세요";

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    private static final String GAME_RETRY = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";

    public Numbers inputNumber() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine().trim();
        while (!checkValidation(input)){
            input = Console.readLine().trim();
        }
        return new Numbers(input);
    }

    private boolean checkValidation(String input) {
        if (!checkLength(input.length())) {
            return false;
        }
        if (!checkNumber(input.toCharArray())) {
            return false;
        }
        return checkDuplication(input.toCharArray());
    }

    private boolean checkDuplication(char[] numbers) {
        int[] checkArray = new int[10];
        int max = 0;
        for (char c : numbers){
            int i = c - '0';
            max = Math.max(max, ++checkArray[i]);
        }
        if (max > 1){
            System.out.println(DUPLICATION);
        }
        return max == 1;
    }

    private boolean checkNumber(char[] numbers) {
        boolean check = true;
        for (char c : numbers){
            check &= ((c >= '0') & (c <= '9'));
        }

        if(!check){
            System.out.println(NOT_NUMBER);
        }
        return check;
    }

    private boolean checkLength(int length) {
        if(length != 3){
            System.out.println(INVALID_LENGTH);
            return false;
        }
        return true;
    }

    public void printBallCounts(BallCount count) {
        System.out.println(count);
    }

    public boolean askPlay() {
        printGameOverAndRetry();
        String input = Console.readLine();

        while (!"1".equals(input) && !"2".equals(input)){
            printGameOverAndRetry();

            input = Console.readLine();
        }

        return "1".equals(input);
    }

    private void printGameOverAndRetry() {
        System.out.println(GAME_OVER);
        System.out.println(GAME_RETRY);
    }
}
