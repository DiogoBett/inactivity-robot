package InactivityRobot;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class InactivityRobot {

    int shutdownHour;
    int lunchHour;
    int lunchDuration;
    boolean running;

/**
* Starts the Inactivity Robot;
* Every 5 Seconds the Robot will Move your Mouse;
* At a Set Lunch Hour it will Pause for Lunch Time;
* At a Set Shutdown Hour it will Shutdown your Computer.
*/
    public void startRobot() {

        startMenu();

        while (running) {

            try {
            
                verifyTime();

                Robot robot = new Robot();
                robot.mouseMove(getCoordinates(), getCoordinates());

                Thread.sleep(5000);
            
            } catch (AWTException | InterruptedException | IOException exception) {
                exception.printStackTrace();
            }

        }

        endMenu();

    }

    private void startMenu() {

        setRunning(true);

        System.out.println("###################"  
        .concat("\n" + "<I> <N> <A> <C> <T> <I> <V> <I> <T> <Y>")
        .concat("\n" + "<R> <O> <B> <O> <T>")
        .concat("\n" + "###################")
        .concat("\n" + "Every 5 Seconds the Mouse will Move to Generate Activity"));
    }

    private void endMenu() {

        setRunning(false);

        System.out.println("###################" 
        .concat("\n" + "<I> <N> <A> <C> <T> <I> <V> <I> <T> <Y>")
        .concat("\n" + "<R> <O> <B> <O> <T>")
        .concat("\n" + "###################")
        .concat("\n" + "<T> <E> <R> <M> <I> <N> <A> <T> <E> <D>"));
    }

    private void verifyTime() throws IOException, InterruptedException {

        Calendar currentTime = Calendar.getInstance();

        if (currentTime.get(Calendar.HOUR_OF_DAY) == lunchHour) {
            Thread.sleep(TimeUnit.HOURS.toMillis(lunchDuration));
        }

        if (currentTime.get(Calendar.HOUR_OF_DAY) >= shutdownHour) {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("shutdown -s -t 0");
            System.exit(0);
        }

    }

    private int getCoordinates() {

        return (int) (Math.random() * (600 - 400) + 400 );
    }

    /** Set Shutdown Hour.
    * @param  shutdownHour  The Hour when the Computer will Shutdown (24 Hour Format - Example: 18). 
    */
    public void setShutdownHour(int shutdownHour) {

        this.shutdownHour = shutdownHour;
    }

    /** Set Lunch Hour.
    * @param  lunchHour  The Hour when you go to Lunch (24 Hour Format - Example: 13).
    */
    public void setLunchHour(int lunchHour) {

        this.lunchHour = lunchHour;
    }

    /** Set Lunch Time.
    * @param  lunchDuration  Duration of your Lunch (Number of Hours - Example: 1).
    */
    public void setlunchDuration(int lunchDuration) {

        this.lunchDuration = lunchDuration;
    }

    public void setRunning(boolean running) {

        this.running = running;
    }

}
