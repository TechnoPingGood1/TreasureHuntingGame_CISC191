package edu.sdccd.cisc191.template.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Represents an entity in the game, such as a player or an object.
 * Represents position of the entity such as world on the x-axis, y-axis, speed, etc
 */

public class Entity {

    public int worldX,worldY;
    public int speed;

    // Sprite images used for movement in different direction
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    //Handle animation
    public int spriteCounter =0;
    public int spriteNumber = 1;

    // Entity's solid area for collision detection
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

}
