package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class testOrientedObject {

    private Sound sound;

    @BeforeEach
    public void setUp() {
        sound = new Sound();
    }

    @Test
    public void testSoundInitialization() {
        assertNotNull(sound.soundURL[0], "Sound URL at index 0 is not null.");
        assertNotNull(sound.soundURL[1], "Sound URL at index 1 is not null.");
        assertNotNull(sound.soundURL[2], "Sound URL at index 2 is not null.");
    }

    @Test
    public void testSoundPlaying() {
        //Set and play sound
        sound.setFile(0);
        sound.play();

        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        // Check if the clip is running
        assertTrue(sound.clip.isRunning(), "The clip is running.");
    }

    @Test
    public void testSoundPaused() {
        //Set and stop
        sound.setFile(1);
        sound.stop();

        //Ensure that the clip is not running
        assertFalse(sound.clip.isRunning(), "The clip should not be running.");
    }

    @Test
    public void testSoundLoop() {
        sound.setFile(0);
        sound.loop();

        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        assertTrue(sound.clip.isRunning(),"The sound is running in a loop.");

    }


}