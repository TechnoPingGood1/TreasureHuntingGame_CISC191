package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.entity.Entity;

/**
 * This class is responsible for checking collisions between entities and tiles or objects in the game.
 * It handles collision detection based on the direction and movement of the entity.
 */

public class CollisionChecker {
    GamePanel gp;

    /**
     * Constructor for the CollisionChecker class.
     * It initializes the class with a reference to the current game panel.
     *
     * @param gp The current game panel.
     */
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    /**
     * Checks for collisions between an entity and the surrounding tiles based on the entity's direction.
     * If a collision is detected, the entity's collision flag is set to true.
     *
     * @param entity The entity whose collision is being checked.
     */
    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityTopWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        // Switch based on the entity's direction to check for collisions
        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if((gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision) == true){
                entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if((gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision) == true){
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if((gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision) == true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if((gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision) == true){
                    entity.collisionOn = true;
                }
                break;
        }

    }

    /**
     * Checks for collisions between the entity and game objects.
     *
     * @param entity The entity to check collisions for.
     * @param player True if the entity is the player, false otherwise.
     * @return The index of the object the entity collided with, or 999 if no collision.
     */
    public int checkObject(Entity entity, boolean player) {
        int index = 999;
        for(int i=0; i < gp.obj.length; i++) {
            if(gp.obj[i] != null) {
                //Get entity's solid area
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                //Get the solid area object
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision == true){
                            entity.collisionOn = true;}
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;}
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;}
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;}
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;

            }

        }
        return index;
    }
}
