package de.de.de.threads;

import java.util.concurrent.TimeUnit;

public class StopThread {

    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean isStopRequested() {
        return stopRequested;
    }


    public static void main(String [] args ) throws InterruptedException{
        Thread backgroundThread = new Thread(()-> {
            int i = 0;
            while (!isStopRequested()){

                i++;
                System.out.println("No stop "+i);
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
