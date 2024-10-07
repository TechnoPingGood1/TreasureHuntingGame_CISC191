package edu.sdccd.cisc191.template;
import edu.sdccd.cisc191.template.template.GameClient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyHandler class handles keyboard input for the game. It implements the KeyListener interface and processes
 * key events such as key press and release for different game states like title, play, and pause.
 */
public class KeyHandler implements KeyListener {

    // Networking component (not fully implemented in this snippet)
    GameClient socketClient;

    // Reference to the main game panel
    GamePanel gp;

    //Movement
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    //Debug for checking draw time
    boolean checkDrawTime = false;

    /**
     * Constructor for KeyHandler.
     *
     * @param gp Reference to the main game panel for handling game states and interactions
     */
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    /**
     * Invoked when a key has been typed.
     * Not used in this implementation.
     *
     * @param e the key event
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * Invoked when a key has been pressed.
     * Handles input for the title state, gameplay movement, and debug mode.
     *
     * @param e the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        // Title State Controls
        if (gp.gameState == gp.titleState) {
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 1; // Loop back to the last option (Quit)
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 1) {
                    gp.ui.commandNum = 0; // Loop back to the first option (New Game)
                }
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0) {
                    // New Game selected
                    gp.gameState = gp.playState;
                    // Play background music
                }
                if (gp.ui.commandNum == 1) {
                    // Quit selected
                    System.exit(0);
                }
            }
        }

        // Game Play Controls
        if (gp.gameState == gp.playState) {
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_P) {
                // Pause/Unpause the game
                if (gp.gameState == gp.playState) {
                    gp.gameState = gp.pauseState;
                } else if (gp.gameState == gp.pauseState) {
                    gp.gameState = gp.playState;
                }
            }
        }

        // Debug Mode
        if (code == KeyEvent.VK_T) {
            checkDrawTime = !checkDrawTime;
        }
    }

    /**
     * Invoked when a key has been released.
     * Stops movement for the appropriate direction.
     *
     * @param e the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        // Release movement keys
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
