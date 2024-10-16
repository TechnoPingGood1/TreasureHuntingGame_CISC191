package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.OBJS.OBJ_Door;
import edu.sdccd.cisc191.template.OBJS.OBJ_Key;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssetSetterTest {
    private GamePanel mockGamePanel =  new GamePanel();
    private AssetSetter assetSetter = new AssetSetter(mockGamePanel);


    @Test
    public void testSetObject() {
        // Call setObject to place the game objects
        assetSetter.setObject();

        // Check if the first object is an instance of OBJ_Key and correctly placed
        assertNotNull(mockGamePanel.obj[0], "Object should be placed in obj[0]");
        assertTrue(mockGamePanel.obj[0] instanceof OBJ_Key, "Object should be of type OBJ_Key");
        assertEquals(23 * mockGamePanel.tileSize, mockGamePanel.obj[0].worldX, "X position should be correct for obj[0]");
        assertEquals(7 * mockGamePanel.tileSize, mockGamePanel.obj[0].worldY, "Y position should be correct for obj[0]");

        // Check if the second object is also a key
        assertNotNull(mockGamePanel.obj[1], "Object should be placed in obj[1]");
        assertTrue(mockGamePanel.obj[1] instanceof OBJ_Key, "Object should be of type OBJ_Key");
        assertEquals(23 * mockGamePanel.tileSize, mockGamePanel.obj[1].worldX, "X position should be correct for obj[1]");
        assertEquals(40 * mockGamePanel.tileSize, mockGamePanel.obj[1].worldY, "Y position should be correct for obj[1]");

        // Check if the third object is a key
        assertNotNull(mockGamePanel.obj[2], "Object should be placed in obj[2]");
        assertTrue(mockGamePanel.obj[2] instanceof OBJ_Key, "Object should be of type OBJ_Key");
        assertEquals(38 * mockGamePanel.tileSize, mockGamePanel.obj[2].worldX, "X position should be correct for obj[2]");
        assertEquals(8 * mockGamePanel.tileSize, mockGamePanel.obj[2].worldY, "Y position should be correct for obj[2]");

        // Check if the fourth object is a door
        assertNotNull(mockGamePanel.obj[3], "Object should be placed in obj[3]");
        assertTrue(mockGamePanel.obj[3] instanceof OBJ_Door, "Object should be of type OBJ_Door");
        assertEquals(10 * mockGamePanel.tileSize, mockGamePanel.obj[3].worldX, "X position should be correct for obj[3]");
        assertEquals(11 * mockGamePanel.tileSize, mockGamePanel.obj[3].worldY, "Y position should be correct for obj[3]");


    }
}