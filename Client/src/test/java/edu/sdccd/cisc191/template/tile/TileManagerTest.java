package edu.sdccd.cisc191.template.tile;
import edu.sdccd.cisc191.template.GamePanel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TileManagerTest {
    GamePanel gp = new GamePanel();
    private TileManager tileManager = new TileManager(gp);


    //Module 1
    @Test
    void testSetUpTile() {
        tileManager.setUp(0, "grass01", false);
        assertNotNull(tileManager.tile[0], "Tile should be initialized");
        assertFalse(tileManager.tile[0].collision, "Tile collision should be false");

        tileManager.setUp(1, "wall", true);
        assertTrue(tileManager.tile[1].collision, "Tile collision should be true");
    }

    @Test
    void testLoadMap() {
        // Prepare a map file for testing (use an example map file in resources)
        tileManager.loadMap("/map/world01.txt");
        assertNotNull(tileManager.mapTileNum, "Map should be loaded and initialized");
    }





}