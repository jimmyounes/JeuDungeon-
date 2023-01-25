package model.Enemy;

import model.Entity;

import java.awt.*;
import java.io.IOException;

public abstract class Enemy extends Entity {
    public int move = 0;
    public int xMaxMove;
    public int xMinMove;
    public int yMaxMove;
    public int yMinMove;
   public  int moveAxisX=1;
    public int moveAxisy=1;
    public String moveIn="x";
    public double startAttack;
    public boolean FollowPlayer=false;

    public Enemy() {
    }

    public Enemy(int currentx, int currenty) {
        super(currentx, currenty);
    }

    public abstract  void render(Graphics graphics) throws IOException;
    public abstract void attack();
}
