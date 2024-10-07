package edu.sdccd.cisc191.template;

import javax.swing.*;

/**
 * The GameWindow class is responsible for creating the main window of the game.
 * It extends JFrame and sets up the window properties such as size, default close operation, and visibility.
 */
public class GameWindow extends JFrame {
    /**
     * Constructor for the GameWindow class.
     * It initializes the game window, sets its size, adds a GamePanel, and makes the window visible.
     */
    public GameWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.add(new GamePanel());  // Your game JPanel
        this.setVisible(true);
    }
}

