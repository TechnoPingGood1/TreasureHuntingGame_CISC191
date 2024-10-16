package edu.sdccd.cisc191.template.OBJS;

import edu.sdccd.cisc191.template.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;

    /**
     * Represents the Blueheart object in the game
     */
    public class OBJ_Blueheart  extends SuperObject{
    GamePanel gp;

        /**
         * Constructs a Blueheart object.
         *
         * @param gp The game panel where the object is placed.
         *
         */

    public OBJ_Blueheart(GamePanel gp){
        this.gp = gp;

        name = "Blueheart";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/blueheart.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public int getBlueHeart(int number){
        return number;
    }
}
