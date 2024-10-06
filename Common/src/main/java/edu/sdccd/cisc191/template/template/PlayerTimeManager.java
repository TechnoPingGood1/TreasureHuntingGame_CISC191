package edu.sdccd.cisc191.template.template;

import java.text.DecimalFormat;

public class PlayerTimeManager {

    private static double playTime;
    private long lastUpdateTime;
    private DecimalFormat dFormat;

    public PlayerTimeManager() {
        this.dFormat = new DecimalFormat("0.00");
        this.lastUpdateTime = System.currentTimeMillis();
    }

    public void updateTime() {
        long currentTime = System.currentTimeMillis();
        long deltaTime = currentTime - lastUpdateTime;
        playTime += (double) deltaTime / 1000.0;
        lastUpdateTime = currentTime;
    }

    // Call this method to get the current playtime in formatted string
    public String getFormattedPlayTime() {
        //System.out.println(this.dFormat.format(playTime));
        return dFormat.format(playTime) + " seconds";
    }

    public double getPlayTime() {
        return playTime;
    }

    public void resetTime() {
        playTime = 0;
        lastUpdateTime = System.currentTimeMillis();
    }

    public void startTimer() {
        lastUpdateTime = System.currentTimeMillis(); // Reset timer on start
    }
}
