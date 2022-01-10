package InactivityRobot;

public class Run {

    public static void main(String[] args) {

        InactivityRobot robot = new InactivityRobot();
        robot.setShutdownHour(18);
        robot.setLunchHour(13);
        robot.setlunchDuration(1);
        robot.startRobot();
    }

}