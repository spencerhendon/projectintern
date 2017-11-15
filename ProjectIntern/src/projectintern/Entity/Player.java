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

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Player extends Entity {

    // Width and height of player
    private final double WIDTH, HEIGHT;

    // Name and loadout
    private final String NAME, LOADOUT;

    // XP
    private int xP;

    // Loadout specs
    private int health, speed, damage;

    // Rectangles for the body
    Group gBody = new Group();
    Rectangle rgHead;
    Rectangle rgTorso;
    Rectangle rgLeftArm;
    Rectangle rgRightArm;
    Rectangle rgLeftLeg;
    Rectangle rgRightLeg;

    // Player Animation...
    Rotate rtLeftLeg;
    Rotate rtRightLeg;
    public Timeline tlWalkLeft = new Timeline();
    public Timeline tlWalkRight = new Timeline();
    private final int playerSpeedWalk = 250;
    private final int playerAngleWalk = 25;
    private String playerState = "front"; // front, back, sideLeft, sideRight

    // Player Movement
    private double positionX;
    private double positionY;
    private double velocityX = 0;
    private double velocityY = 0;

    public Player(String NAME, String LOADOUT, int xP, int xCoord, int yCoord, double WIDTH, double HEIGHT) {
        // Set x and y coords
        super(xCoord, yCoord);

        this.NAME = NAME;
        this.LOADOUT = LOADOUT;
        this.xP = xP; // Initial xp
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        rgHead = new Rectangle(HEIGHT / 48, HEIGHT / 48);
        rgTorso = new Rectangle(HEIGHT / 30, HEIGHT / 30);
        rgLeftArm = new Rectangle(HEIGHT / 90, HEIGHT / 40);
        rgRightArm = new Rectangle(HEIGHT / 90, HEIGHT / 40);
        rgLeftLeg = new Rectangle(HEIGHT / 90, HEIGHT / 36);
        rgRightLeg = new Rectangle(HEIGHT / 90, HEIGHT / 36);

        positionX = WIDTH / 2;
        positionY = HEIGHT / 2;

        // Change normal player state
        changeState(playerState);

        // Draw body
        gBody.getChildren().addAll(rgHead,
                rgLeftArm, rgLeftLeg, rgRightLeg,
                rgTorso, rgRightArm);

        gBody.setTranslateX(positionX);
        gBody.setTranslateY(positionY);

        this.getChildren().add(gBody);

        // Setup animations
        setAnimations();

        // Determine loadout specs
        loadout();

        // Player loop;
        AnimationTimer gameLoop = new GameTimer();
        gameLoop.start();
    }

    public void setAnimations() {
        // Reset animations
        tlWalkLeft.getKeyFrames().clear();
        tlWalkRight.getKeyFrames().clear();

        // Define walking rotations
        rtLeftLeg = new Rotate(0,
                rgLeftLeg.getX() + rgLeftLeg.getWidth() / 2,
                rgLeftLeg.getY());

        rtRightLeg = new Rotate(0,
                rgRightLeg.getX() + rgRightLeg.getWidth() / 2,
                rgRightLeg.getY());

        rgLeftLeg.getTransforms().add(rtLeftLeg);
        rgRightLeg.getTransforms().add(rtRightLeg);

        // Animate walking left
        KeyValue kvWalkLeftF1LL = new KeyValue(rtLeftLeg.angleProperty(), playerAngleWalk);
        KeyValue kvWalkLeftF1LR = new KeyValue(rtRightLeg.angleProperty(), 0);
        KeyValue kvWalkLeftF2LL = new KeyValue(rtLeftLeg.angleProperty(), 0);
        KeyValue kvWalkLeftF2LR = new KeyValue(rtRightLeg.angleProperty(), 0);
        KeyValue kvWalkLeftF4LL = new KeyValue(rtLeftLeg.angleProperty(), 0);
        KeyValue kvWalkLeftF4LR = new KeyValue(rtRightLeg.angleProperty(), playerAngleWalk);
        KeyValue kvWalkLeftF5LL = new KeyValue(rtLeftLeg.angleProperty(), 0);
        KeyValue kvWalkLeftF5LR = new KeyValue(rtRightLeg.angleProperty(), 0);
        KeyFrame kfWalkLeftF1 = new KeyFrame(Duration.millis((playerSpeedWalk / 4) * 1), kvWalkLeftF1LL, kvWalkLeftF1LR);
        KeyFrame kfWalkLeftF2 = new KeyFrame(Duration.millis((playerSpeedWalk / 4) * 2), kvWalkLeftF2LL, kvWalkLeftF2LR);
        KeyFrame kfWalkLeftF4 = new KeyFrame(Duration.millis((playerSpeedWalk / 4) * 3), kvWalkLeftF4LL, kvWalkLeftF4LR);
        KeyFrame kfWalkLeftF5 = new KeyFrame(Duration.millis((playerSpeedWalk / 4) * 4), kvWalkLeftF5LL, kvWalkLeftF5LR);
        tlWalkLeft.setCycleCount(1);
        tlWalkLeft.setAutoReverse(false);
        tlWalkLeft.getKeyFrames().addAll(kfWalkLeftF1, kfWalkLeftF2, kfWalkLeftF4, kfWalkLeftF5);

        // Animate walking right
        KeyValue kvWalkRightF1LL = new KeyValue(rtLeftLeg.angleProperty(), 0);
        KeyValue kvWalkRightF1LR = new KeyValue(rtRightLeg.angleProperty(), -playerAngleWalk);
        KeyValue kvWalkRightF2LL = new KeyValue(rtLeftLeg.angleProperty(), 0);
        KeyValue kvWalkRightF2LR = new KeyValue(rtRightLeg.angleProperty(), 0);
        KeyValue kvWalkRightF4LL = new KeyValue(rtLeftLeg.angleProperty(), -playerAngleWalk);
        KeyValue kvWalkRightF4LR = new KeyValue(rtRightLeg.angleProperty(), 0);
        KeyValue kvWalkRightF5LL = new KeyValue(rtLeftLeg.angleProperty(), 0);
        KeyValue kvWalkRightF5LR = new KeyValue(rtRightLeg.angleProperty(), 0);
        KeyFrame kfWalkRightF1 = new KeyFrame(Duration.millis((playerSpeedWalk / 4) * 1), kvWalkRightF1LL, kvWalkRightF1LR);
        KeyFrame kfWalkRightF2 = new KeyFrame(Duration.millis((playerSpeedWalk / 4) * 2), kvWalkRightF2LL, kvWalkRightF2LR);
        KeyFrame kfWalkRightF4 = new KeyFrame(Duration.millis((playerSpeedWalk / 4) * 3), kvWalkRightF4LL, kvWalkRightF4LR);
        KeyFrame kfWalkRightF5 = new KeyFrame(Duration.millis((playerSpeedWalk / 4) * 4), kvWalkRightF5LL, kvWalkRightF5LR);
        tlWalkRight.setCycleCount(1);
        tlWalkRight.setAutoReverse(false);
        tlWalkRight.getKeyFrames().addAll(kfWalkRightF1, kfWalkRightF2, kfWalkRightF4, kfWalkRightF5);
    }

    public void changeState(String playerState) {
        // Set new player state
        this.playerState = playerState;

        // Adjust body to fit new state
        // Forward view
        if (playerState.equals("front")) {
            // Rectangle for left arm
            rgLeftArm.setArcHeight(5);
            rgLeftArm.setArcWidth(5);
            rgLeftArm.setX(0);
            rgLeftArm.setFill(Color.web("0000ff"));
            rgLeftArm.setY(rgHead.getHeight());

            // Rectangle for torso
            rgTorso.setFill(Color.web("000000"));
            rgTorso.setWidth(HEIGHT / 30);
            rgTorso.setX(rgLeftArm.getWidth());
            rgTorso.setY(rgHead.getHeight());

            // Rectangle for head
            rgHead.setFill(Color.web("ff0000"));
            rgHead.setX(rgLeftArm.getWidth() + rgTorso.getWidth() / 2 - rgHead.getWidth() / 2);

            // Rectangle for right arm
            rgRightArm.setArcHeight(5);
            rgRightArm.setArcWidth(5);
            rgRightArm.setFill(Color.web("0000ff"));
            rgRightArm.setX(rgLeftArm.getWidth() + rgTorso.getWidth());
            rgRightArm.setY(rgHead.getHeight());

            // Rectangle for left leg
            rgRightLeg.setArcHeight(5);
            rgRightLeg.setArcWidth(5);
            rgRightLeg.setFill(Color.web("ffff00"));
            rgRightLeg.setX(rgTorso.getX() + rgLeftLeg.getWidth() * 2
                    - rgLeftLeg.getWidth() / 3);
            rgRightLeg.setY(rgHead.getHeight() + rgTorso.getWidth());

            // Rectangle for right leg
            rgLeftLeg.setArcHeight(5);
            rgLeftLeg.setArcWidth(5);
            rgLeftLeg.setFill(Color.web("ff9600"));
            rgLeftLeg.setX(rgTorso.getX() + rgTorso.getWidth()
                    - rgRightLeg.getWidth() * 3 + rgRightLeg.getWidth() / 3);
            rgLeftLeg.setY(rgHead.getHeight() + rgTorso.getWidth());
        } else if (playerState.equals("sideLeft")) {
            // Rectangle for torso
            rgTorso.setWidth(HEIGHT / 40);
            rgTorso.setX(0);

            // Rectangle for right arm
            rgRightArm.setX(rgTorso.getX() + rgTorso.getWidth() / 2
                    - rgRightLeg.getWidth() / 2);

            // Rectangle for left arm
            rgLeftArm.setX(rgTorso.getX() + rgTorso.getWidth() / 2
                    - rgRightLeg.getWidth() / 2);

            // Rectangle for head
            rgHead.setFill(Color.web("ff0000"));
            rgHead.setX(rgTorso.getWidth() / 2 - rgHead.getWidth() / 2);

            // Rectangle for left leg... front
            rgLeftLeg.setX(rgTorso.getX() + rgTorso.getWidth() / 2
                    - rgRightLeg.getWidth() / 2);

            // Rectangle for right leg... back
            rgRightLeg.setX(rgTorso.getX() + rgTorso.getWidth() / 2
                    - rgRightLeg.getWidth() / 2);
        } else if (playerState.equals("sideRight")) {
            // Rectangle for torso
            rgTorso.setWidth(HEIGHT / 40);
            rgTorso.setX(0);

            // Rectangle for right arm
            rgRightArm.setX(rgTorso.getX() + rgTorso.getWidth() / 2
                    - rgRightLeg.getWidth() / 2);

            // Rectangle for left arm
            rgLeftArm.setX(rgTorso.getX() + rgTorso.getWidth() / 2
                    - rgRightLeg.getWidth() / 2);

            // Rectangle for head
            rgHead.setFill(Color.web("ff0000"));
            rgHead.setX(rgTorso.getWidth() / 2 - rgHead.getWidth() / 2);

            // Rectangle for left leg... front
            rgLeftLeg.setX(rgTorso.getX() + rgTorso.getWidth() / 2
                    - rgRightLeg.getWidth() / 2);

            // Rectangle for right leg... back
            rgRightLeg.setX(rgTorso.getX() + rgTorso.getWidth() / 2
                    - rgRightLeg.getWidth() / 2);
        } else if (playerState.equals("back")) {

        }
    }

    private class GameTimer extends AnimationTimer {

        @Override
        public void handle(long l) {
            // Move player
            setPositionX(getPositionX() + getVelocityX());
            setPositionY(getPositionY() + getVelocityY());
            gBody.setTranslateX(getPositionX());
            gBody.setTranslateY(getPositionY());
        }

    }

    public void loadout() {
        if (null != LOADOUT) {
            switch (LOADOUT) {
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

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return this.NAME;
    }

    public String getLoadout() {
        return LOADOUT;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getXP() {
        return this.xP;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setXP(int xp) {
        this.xP = xp;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
}
