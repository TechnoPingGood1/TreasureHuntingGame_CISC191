package edu.sdccd.cisc191.template.template;

import java.text.DecimalFormat;

/**
 * This class manages the player's playtime in the game.
 * It tracks and updates the total time the player has spent playing.
 */
public class PlayerTimeManager {

    private static double playTime;
    private long lastUpdateTime;
    private DecimalFormat dFormat;

    /**
     * Constructs a PlayerTimeManager instance.
     * Initializes the decimal format for displaying playtime and sets the last update time.
     */
    public PlayerTimeManager() {
        this.dFormat = new DecimalFormat("0.00");
        this.lastUpdateTime = System.currentTimeMillis();
    }

    /**
     * Updates the playtime based on the time elapsed since the last update.
     * Should be called frequently (e.g., every game frame) to keep track of the playtime.
     */
    public void updateTime() {
        long currentTime = System.currentTimeMillis();
        long deltaTime = currentTime - lastUpdateTime;
        playTime += (double) deltaTime / 1000.0;
        lastUpdateTime = currentTime;
    }

    /**
     * Returns the current playtime formatted as a string with two decimal places.
     *
     * @return the formatted playtime string (e.g., "12.34 seconds").
     */
    public String getFormattedPlayTime() {
        //System.out.println(this.dFormat.format(playTime));
        return dFormat.format(playTime) + " seconds";
    }

    /**
     * Returns the current playtime in seconds.
     *
     * @return the total playtime in seconds as a double.
     */
    public double getPlayTime() {
        return playTime;
    }

    /**
     * Resets the playtime to 0 and sets the last update time to the current time.
     */
    public void resetTime() {
        playTime = 0;
        lastUpdateTime = System.currentTimeMillis();
    }

    /**
     * Starts or resumes the playtime tracking by setting the last update time to the current time.
     */
    public void startTimer() {
        lastUpdateTime = System.currentTimeMillis(); // Reset timer on start
    }
}
