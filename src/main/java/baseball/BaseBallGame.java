package baseball;

import nextstep.utils.Randoms;

public class BaseBallGame {
    private static final BaseBallGame game = new BaseBallGame();
    private static final InOutProcessor io = new InOutProcessor();

    private boolean continuance;
    private Numbers goal;

    private BaseBallGame() {}

    public static BaseBallGame getInstance(){
        return game;
    }

    public void gameStart(){
        continuance = true;

        while (continuance){
            setNumber();
            playBall();
            askPlay();
        }
    }

    private void setNumber() {
        int first = makeNumber();
        int second = makeNumber(first);
        int third = makeNumber(first, second);

        goal = new Numbers(first, second, third);
    }

    private int makeNumber(int number1, int number2) {
        int value = number1;
        while (value == number1 || value == number2){
            value = Randoms.pickNumberInRange(0, 9);
        }
        return value;
    }

    private int makeNumber(int number) {
        int value = number;
        while (value == number){
            value = Randoms.pickNumberInRange(0, 9);
        }
        return value;
    }

    private int makeNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void askPlay() {
        continuance = io.askPlay();
    }

    private void playBall() {
        boolean isFinished = false;

        while (!isFinished) {
            Numbers input = io.inputNumber();
            BallCount count = BallCount.judge(goal, input);
            io.printBallCounts(count);

            isFinished = count.isFisish();
        }
    }
}
