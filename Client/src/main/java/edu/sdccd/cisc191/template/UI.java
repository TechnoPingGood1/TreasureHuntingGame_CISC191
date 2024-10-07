package edu.sdccd.cisc191.template;
import edu.sdccd.cisc191.template.OBJS.OBJ_Key;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

/**
 * The UI class handles the user interface rendering for the game, including the title screen,
 * messages, game-over screen, and in-game UI elements like the player's playtime and keys.
 */
public class UI {

    GamePanel gp;
    // Graphics object for rendering
    Graphics g2;
    // Fonts for UI text
    Font arial_40, arial_60B;
    // Image for the key icon
    BufferedImage keyImage;
    // Indicates whether a message is currently displayed
    public boolean messageOn;
    // Stores the current message text
    public String message = "";
    // Counter for message display duration
    int messageCounter = 0;
    // To indicate if the game is finished
    public boolean gameFinished = false;
    // Stores the player's playtime
    public double playTime;
    // Format for playtime display
    public DecimalFormat dFormat = new DecimalFormat("0.00");
    // Tracks the current selected command (e.g., in menu)
    public int commandNum =0;

    /**
     * Constructor for the UI class. Initializes fonts and loads the key image.
     *
     * @param gp The GamePanel instance used to manage game rendering and logic.
     */
    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 35);
        arial_60B = new Font("Arial", Font.BOLD, 60);
        OBJ_Key key = new OBJ_Key(gp);
        keyImage = key.image;
    }

    /**
     * Displays a message on the screen for a set duration.
     *
     * @param text The message to display.
     */
    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    /**
     * Handles drawing the UI elements, including title screen, game-over screen, and other game states.
     *
     * @param g2 The Graphics2D object used for drawing the UI elements.
     */
    public void draw(Graphics2D g2) {
        this.g2 = g2;

        // Title State
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }

        // Game Finished State
        else if(gameFinished == true) {
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            String txt;
            int txtLength;
            int x;
            int y;
            txt = "YOU FOUND THE TREASURE!!";
            txtLength = (int)g2.getFontMetrics().getStringBounds(txt, g2).getWidth();
            x = gp.screenWidth/2 - txtLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(txt, x, y);

            txt = "Your Time is: " + dFormat.format(playTime) + " seconds!!";
            txtLength = (int)g2.getFontMetrics().getStringBounds(txt, g2).getWidth();
            x = gp.screenWidth/2 - txtLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*4);
            g2.drawString(txt, x, y);

            g2.setFont(arial_60B);
            g2.setColor(Color.yellow);
            txt = "CONGRATULATIONS!!";
            txtLength = (int)g2.getFontMetrics().getStringBounds(txt, g2).getWidth();
            x = gp.screenWidth/2 - txtLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*2);
            g2.drawString(txt, x, y);

            gp.gameThread = null;
        }
        else {
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize/2, gp.tileSize/2, null);
            g2.drawString("x " + gp.player.hasKey, 60, 45);

            // Time
            playTime += (double) 1 / 60;
            g2.drawString("Time: " + dFormat.format(playTime) + " seconds", gp.tileSize * 9, 45);
        }

        // Message
        if(messageOn == true) {
            g2.setFont(g2.getFont().deriveFont(30f));
            g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);

            messageCounter++;
            if (messageCounter > 120) {
                messageCounter = 0;
                messageOn = false;
            }
        }

    }

    /**
     * Draws the title screen of the game, including the game title, an image, and a menu with "New Game" and "Quit" options.
     */
    public void drawTitleScreen() {
        g2.setColor(new Color(0, 0, 0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        // Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50F));
        String txt = "TREASURE HUNTING GAME";
        int x = getXforCenteredText(txt);
        int y = gp.tileSize * 3;

        //Shadow txt
        g2.setColor(Color.gray);
        g2.drawString(txt, x+4, y+4);
        //Main txt
        g2.setColor(Color.white);
        g2.drawString(txt, x, y);

        //Image
        x= gp.screenWidth/2 - (gp.tileSize*2)/2;
        y += gp.tileSize*2;
        g2.drawImage(gp.player.down1, x,y, gp.tileSize*2, gp.tileSize*2, null);

        //Menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));

        txt = "New Game";
        x = getXforCenteredText(txt);
        y += gp.tileSize*4;
        g2.drawString(txt, x, y);
        if(commandNum == 0) {
            g2.drawString(">",x-gp.tileSize,y);
        }

        txt = "Quit";
        x = getXforCenteredText(txt);
        y += gp.tileSize;
        g2.drawString(txt, x, y);
        if(commandNum == 1) {
            g2.drawString(">",x-gp.tileSize,y);
        }

    }

    /**
     * Draws the pause screen with the text "PAUSED" centered on the screen.
     */
    public void drawPauseScreen(){
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2 - gp.tileSize/2;

        g2.drawString(text,x,y);
    }

    /**
     * Helper method to get the X-coordinate needed to center the given text on the screen.
     *
     * @param text The text to be centered.
     * @return The X-coordinate where the text should be drawn to be centered.
     */
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x= gp.screenWidth/2 - length/2;
        return x;

    }
}
