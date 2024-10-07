package edu.sdccd.cisc191.template;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

/**
 * This class manages sound effects and background music for the game.
 * It supports playing, looping, and stopping sound clips.
 */
public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    /**
     * Initializes the Sound class by loading sound resources into the soundURL array.
     * It supports up to 30 sound files.
     */
    public Sound() {
        soundURL[0] = getClass().getResource("/sound/BlueBoyAdventure.wav");
        soundURL[1] = getClass().getResource("/sound/coin.wav");
        soundURL[2] = getClass().getResource("/sound/powerup.wav");
        soundURL[3] = getClass().getResource("/sound/unlock.wav");
        soundURL[4] = getClass().getResource("/sound/fanfare.wav");
    }

    /**
     * Loads the sound file from the soundURL array at the specified index into a Clip object.
     *
     * @param i The index of the sound in the soundURL array.
     */
    public void setFile(int i) {
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Starts playing the loaded sound file.
     */
    public void play() {
        clip.start();
    }

    /**
     * Loops the loaded sound file continuously until it is stopped.
     */
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Stops the currently playing or looping sound file.
     */
    public void stop() {
        clip.stop();
    }


}
