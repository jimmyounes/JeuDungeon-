package model.Enemy;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Aigle extends Enemy {

    boolean atack=false;

    public Aigle(int currentx, int currenty) {
        this.currentx=currentx;
        this.currenty=currenty;
        xMinMove=currentx;
        yMinMove=currenty;
        direction="right";
        vitality=100;
        strength=10;
        attack=false;
        startAttack=2*Math.pow(10,9);
    }
    public Aigle(int currentx,int currenty,int xmax,int ymax){
        this.currentx=currentx;
        this.currenty=currenty;
        xMinMove=currentx;
        yMinMove=currenty;
        direction="right";
        vitality=100;
        strength=10;
        attack=false;
        startAttack=2*Math.pow(10,9);
        xMaxMove=xmax;
        yMaxMove=ymax;
    }

    public Aigle() {
        xMinMove=300;
        yMinMove=300;
        currentx=300;
        currenty=300;
        vitality=100;
        strength=5;
        startAttack=2*Math.pow(10,9);
        attack=false;
    }

    @Override
    public void render(Graphics graphics) throws IOException {
        File path = new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageplayer = ImageIO.read(new File(path, "enemy.png"));

        if (move == 0) {
            imageplayer = ImageIO.read(new File(path, "enemy.png"));
            move++;
        }
        else{
            move=0;
            imageplayer = ImageIO.read(new File(path, "enemy_2.png"));
        }

        graphics.drawImage(imageplayer, currentx, currenty, null);
        if(attack){
            BufferedImage imageattack= ImageIO.read(new File(path,"attack.png"));
            if(direction=="left") imageattack= ImageIO.read(new File(path,"attackleft.png"));
            if(direction=="down") imageattack= ImageIO.read(new File(path,"attackdown.png"));
            if(direction=="up") imageattack= ImageIO.read(new File(path,"attackup.png"));
            graphics.drawImage(imageattack,currentx,currenty,null);
            attack=false;
        }
        graphics.drawString("enemy aigle "+vitality,300,0);

    }

    @Override
    public void attack() {

    }
}
