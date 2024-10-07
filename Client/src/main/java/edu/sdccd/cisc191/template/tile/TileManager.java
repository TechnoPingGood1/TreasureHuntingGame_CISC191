package edu.sdccd.cisc191.template.tile;

import java.awt.*;
import java.io.*;

import edu.sdccd.cisc191.template.GamePanel;
import edu.sdccd.cisc191.template.UtilityTool;
import javax.imageio.ImageIO;
import java.io.IOException;

/** This class manages the tiles in the game world
 * It loads tile images, handles the map, and renders tiles on the screen.
 */
public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    /**
     * Constructs a TileManager for the specified GamePanel.
     *
     * @param gp the GamePanel instance that this TileManager will manage tiles for.
     */
    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[10];

        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();

        // In case, there is another map that need to call
        loadMap("/map/world01.txt");
    }

    /**
     * Loads the tile images and sets up their collision.
     */
    public void getTileImage() {

            setUp(0,"grass01", false);
            setUp(1,"wall", true);
            setUp(2,"water01", true);
            setUp(3,"earth", false);
            setUp(4,"tree", true);
            setUp(5,"sand", false);
    }

    /**
     * Configures a tile by loading its image and setting its collision property.
     *
     * @param index the index of the tile array (module 1)
     * @param imageName The name of the image file to load for this tile.
     * @param collision True if the tile has collision, otherwise false.
     */
    public void setUp(int index, String imageName, boolean collision) {
        UtilityTool uTool = new UtilityTool();
        try{

            tile[index] =new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/Tile/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads the map from a text file and stores tile information for each position.
     *
     * @param path1 The path for the map file.
     */
    public void loadMap(String path1){
        try{
            InputStream is = getClass().getResourceAsStream(path1);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col =0;
            int row =0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                // read line by line
                String line = br.readLine();

                while(col < gp.maxWorldCol){
                    // Split the String with a space
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Draws the tiles on the screen based on the player's position and world coordinates.
     *
     * @param g2 The Graphics2D object used to draw tiles.
     */
    public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
               worldY + gp.tileSize> gp.player.worldY - gp.player.screenY &&
               worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
               worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

                g2.drawImage(tile[tileNum].image,screenX,screenY,null);
            }

            worldCol++;

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;

            }

        }



    }

}
