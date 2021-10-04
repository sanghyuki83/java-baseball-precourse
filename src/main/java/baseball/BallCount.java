package baseball;

public class BallCount {
    int strikes;
    int balls;

    public BallCount(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public static BallCount judge(Numbers goal, Numbers input) {
        BallCount count = new BallCount(0, 0);
        countsStrike(count, goal, input);
        countsBall(count, goal, input);
        return count;
    }

    private static void countsBall(BallCount count, Numbers goal, Numbers input) {
        if (goal.secondNumber == input.firstNumber || goal.thirdNumber == input.firstNumber){
            count.balls++;
        }
        if (goal.firstNumber == input.secondNumber || goal.thirdNumber == input.secondNumber){
            count.balls++;
        }
        if (goal.firstNumber == input.thirdNumber || goal.secondNumber == input.thirdNumber){
            count.balls++;
        }
    }

    private static void countsStrike(BallCount count, Numbers goal, Numbers input) {
        if (goal.firstNumber == input.firstNumber){
            count.strikes++;
        }
        if (goal.secondNumber == input.secondNumber){
            count.strikes++;
        }
        if (goal.thirdNumber == input.thirdNumber){
            count.strikes++;
        }
    }

    @Override
    public String toString() {
        if (strikes + balls == 0)
            return "낫싱";

        StringBuilder sb = new StringBuilder();
        if (strikes > 0)
            sb.append(strikes).append("스트라이크 ");
        if (balls > 0)
            sb.append(balls).append("볼");

        return sb.toString().trim();
    }

    public boolean isFinish() {
        return this.strikes == 3;
    }
}
