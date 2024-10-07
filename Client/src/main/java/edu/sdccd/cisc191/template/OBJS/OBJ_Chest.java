package edu.sdccd.cisc191.template.OBJS;

import edu.sdccd.cisc191.template.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Represents the Chest object in the game
 */
public class OBJ_Chest extends SuperObject {
    GamePanel gp;

    public OBJ_Chest(GamePanel gp){
        this.gp = gp;

        /**
         * Constructs a Chest object.
         *
         * @param gp The game panel where the object is placed.
         */
        name = "Chest";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
