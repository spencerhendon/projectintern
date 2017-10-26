/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
|
|   Project: Entity
|   Name: Spencer Hendon, Jaycob Willis, Nathaniel Ogungbuyi, Zane Sandoval
|   Date: September 15, 2017
|   Description: Class for player
|
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package projectintern.Entity;

public class Player extends Entity {
    // Player speed
    public int speed = 10;

    public Player(String name, String loadout, int xP, int xCoord, int yCoord) {
        super(name, loadout, xP, xCoord, yCoord);
    }

    
    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
