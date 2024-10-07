package edu.sdccd.cisc191.template.OBJS;

import edu.sdccd.cisc191.template.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
/**
 * Represents the Door object in the game
 */
public class OBJ_Door extends SuperObject {
    GamePanel gp;
    public OBJ_Door(GamePanel gp) {
        this.gp = gp;

        /**
         * Constructs a Door object.
         *
         * @param gp The game panel where the object is placed.
         *
         */
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

