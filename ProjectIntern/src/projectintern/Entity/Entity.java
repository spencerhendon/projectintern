/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
|
|   Project: Entity
|   Name: Spencer Hendon, Jaycob Willis, Nathaniel Ogungbuyi, Zane Sandoval
|   Date: September 15, 2017
|   Description: Class for entities
|
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
package projectintern.Entity;

public class Entity {

    // Name and loadout
    private final String name, loadout;

    // XP
    private int xP;

    // Coordinates
    private double xCoord, yCoord;

    // Loadout specs
    private int health, speed, damage;

    public Entity(String name, String loadout, int xP, int xCoord, int yCoord) {
        this.name = name;
        this.loadout = loadout;
        this.xP = xP; // Initial xp
        this.xCoord = xCoord; // Initial x coord
        this.yCoord = yCoord; // Initial y coord

        // Determine loadout specs
        loadout();
    }

    public void loadout() {
        if (null != loadout) {
            switch (loadout) {
                case "Accountant":
                    health = 75;
                    speed = 75;
                    damage = 75;
                    break;
                case "Secretary":
                    health = 100;
                    speed = 50;
                    damage = 75;
                    break;
                case "Treasurer":
                    health = 75;
                    speed = 100;
                    damage = 50;
                    break;
                case "MailBoy":
                    health = 50;
                    speed = 75;
                    damage = 100;
                    break;
                default:
                    break;
            }
        }
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public String getLoadout() {
        return loadout;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getXP() {
        return this.xP;
    }

    public double getXCoord() {
        return this.xCoord;
    }

    public double getYCoord() {
        return this.yCoord;
    }

    // Setter methods
    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setXP(int xp) {
        this.xP = xp;
    }

    public void setXCoord(double x) {
        this.xCoord = x;
    }

    public void setYCoord(double y) {
        this.yCoord = y;
    }
}
