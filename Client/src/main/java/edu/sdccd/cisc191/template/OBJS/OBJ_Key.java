package edu.sdccd.cisc191.template.OBJS;

import edu.sdccd.cisc191.template.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
/**
 * Represents the Key object in the game
 */
public class OBJ_Key extends SuperObject {

    GamePanel gp;
    public OBJ_Key(GamePanel gp){
        this.gp = gp;

        /**
         * Constructs a Key object.
         *
         * @param gp The game panel where the object is placed.
         *
         */
        name = "Key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
