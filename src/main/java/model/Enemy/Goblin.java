package model.Enemy;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Goblin extends Enemy{
    public static int i=0;
    public Goblin(int currentx,int currenty,int xmax,int ymax) throws IOException {
        this.currentx=currentx;
        this.currenty=currenty;
        xMinMove=currentx;
        yMinMove=currenty;
        direction="right";
        vitality=100;
        strength=10;
        attack=false;
        startAttack=2*Math.pow(10,9);
        yMaxMove=ymax;
        xMaxMove=xmax;
        initialize();
    }

    public Goblin() throws IOException {
        super();
        currentx=100;
        currenty=100;
        xMinMove=100;
        yMinMove=100;
        direction="right";
        vitality=100;
        strength=10;
        attack=false;
        startAttack=2*Math.pow(10,9);
        initialize();
    }

    public Goblin(int currentx, int currenty) throws IOException {
       this.currentx=currentx;
       this.currenty=currenty;
       xMinMove=currentx;
       yMinMove=currenty;
        direction="right";
        vitality=100;
        strength=10;
        attack=false;
        startAttack=2*Math.pow(10,9);
        initialize();
    }

    @Override
    public void render(Graphics graphics) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        if(direction=="back")graphics.drawImage(imageup[i],currentx,currenty,null);
        else if(direction=="right")graphics.drawImage(imageright[i],currentx,currenty,null);
        else if(direction=="left")graphics.drawImage(imageleft[i],currentx,currenty,null);
        else  graphics.drawImage(imagedown[i],currentx,currenty,null);
        move++;
        if(move==4){
            i++;
            move=0;
        }
        if(i==4)i=0;
       /* BufferedImage imageplayer= ImageIO.read(new File(path,"goblin.png"));
       if(move<5){
           if(direction=="right")imageplayer= ImageIO.read(new File(path,"goblin_right.png"));
           else if(direction=="left") imageplayer= ImageIO.read(new File(path,"goblin_left.png"));
           else if(direction=="back")imageplayer= ImageIO.read(new File(path,"goblin_back.png"));
       move++;
       }
       else {
           if(direction=="right") imageplayer= ImageIO.read(new File(path,"goblin_right2.png"));
           else if(direction=="left") imageplayer= ImageIO.read(new File(path,"goblin_left2.png"));
           else if(direction=="back")imageplayer= ImageIO.read(new File(path,"goblin_back2.png"));
           else imageplayer= ImageIO.read(new File(path,"goblin_2.png"));
          move++;
           if(move>10)move=0;
       }
        graphics.drawImage(imageplayer,currentx,currenty,null);*/
       if(attack){
        BufferedImage imageattack= ImageIO.read(new File(path,"attack.png"));
        if(direction=="left") imageattack= ImageIO.read(new File(path,"attackleft.png"));
        if(direction=="down") imageattack= ImageIO.read(new File(path,"attackdown.png"));
        if(direction=="up") imageattack= ImageIO.read(new File(path,"attackup.png"));
        graphics.drawImage(imageattack,currentx,currenty,null);
       attack=false;
           graphics.drawString("enemy aigle "+vitality,400,0);
       }

    }

    @Override
    public void attack() {

    }
    public void initialize() throws IOException {
        this.imagedown=new BufferedImage[4];
        this.imageleft=new BufferedImage[4];
        this.imageright=new BufferedImage[4];
        this.imageup=new BufferedImage[4];
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageEnemy= ImageIO.read(new File(path,"gob.png"));
        int x=0; int y=0;
        for(int i=0;i<4;i++){
            imagedown[i]=imageEnemy.getSubimage(x,y,80,80);
            x=x+80;
        }
        y=y+80;x=0;
        for(int i=0;i<4;i++){
            imageleft[i]=imageEnemy.getSubimage(x,y,80,80);
            x=x+80;
        }
        y=y+80;x=0;
        for(int i=0;i<4;i++){
            imageright[i]=imageEnemy.getSubimage(x,y,80,80);
            x=x+80;
        }
        y=y+80;x=0;
        for(int i=0;i<4;i++){
            imageup[i]=imageEnemy.getSubimage(x,y,80,80);
            x=x+80;
        }
    }

}
