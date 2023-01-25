package model;

import java.awt.image.BufferedImage;

public abstract class Entity {
    public  int strength ;
    public  int vitality;
    public String direction;
    public int currentx;
    public int currenty;
    public boolean attack;
    public BufferedImage imagedown[];
    public BufferedImage imageup[];
    public BufferedImage imageright[];
    public BufferedImage imageleft[];

    public Entity(){}
    public Entity(int currentx, int currenty) {
        currentx = currentx;
        currenty = currenty;
    }

    public Entity(int strength, int vitality, int currentx, int currenty) {
        this.strength = strength;
        this.vitality = vitality;
        currentx = currentx;
        currenty = currenty;
    }


    public int getStrength() {
        return strength;
    }

    public int getVitality() {
        return vitality;
    }
}
