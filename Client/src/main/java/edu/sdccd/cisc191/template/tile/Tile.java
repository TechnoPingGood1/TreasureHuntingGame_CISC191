package edu.sdccd.cisc191.template.tile;

import java.awt.image.BufferedImage;

/**
 *  This class represents tile in the game world.
 *  Each tile has an image and an optional collision property.
 */
public class Tile {

    /** The image representing the tile. */
    public BufferedImage image;

    /** Whether the tile has a collision. */
    public boolean collision = false;

}
