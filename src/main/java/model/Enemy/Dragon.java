package model.Enemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Dragon  extends Enemy{

    public static int i=0;
    public static int move=0;
    public Dragon(int currentx, int currenty) throws IOException {
        this.currentx=currentx;
        this.currenty=currenty;
        xMinMove=currentx;
        yMaxMove=currenty;
        direction="right";
        vitality=300;
        strength=50;
        attack=false;
        startAttack=2*Math.pow(10,9);
        initilize();
        direction="up";
    }
    public Dragon(int currentx, int currenty,int xmax,int ymax) throws IOException {
        this.currentx=currentx;
        this.currenty=currenty;
        xMinMove=currentx;
        yMinMove=currenty;
        xMaxMove=xmax;
        yMaxMove=ymax;
        direction="right";
        vitality=300;
        strength=50;
        attack=false;
        startAttack=2*Math.pow(10,9);
        initilize();
        direction="up";
    }

    @Override
    public void render(Graphics graphics) throws IOException {

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
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageEffect= ImageIO.read(new File(path,"fire.png"));
        int x=currentx;
        int y=currenty;
       if(attack){
           if (direction=="right"){
               imageEffect= ImageIO.read(new File(path,"firedragon.png"));
               graphics.drawImage(imageEffect,x+50,y+5,null);
           }
           if(direction=="back"){
               System.out.println("salut");
               imageEffect= ImageIO.read(new File(path,"fireupdragon.png"));
               graphics.drawImage(imageEffect,x,y-40,null);
           }
           if(direction=="down"){
               imageEffect= ImageIO.read(new File(path,"firedownragon.png"));
               graphics.drawImage(imageEffect,x-5,y+50,null);
           }
           if(direction=="left"){
               imageEffect= ImageIO.read(new File(path,"fireleftdragon.png"));
               graphics.drawImage(imageEffect,x-30,y,null);
           }
           attack=false;

       }



    }

    @Override
    public void attack() {

    }
    public void initilize() throws IOException {
        this.imagedown=new BufferedImage[4];
        this.imageleft=new BufferedImage[4];
        this.imageright=new BufferedImage[4];
        this.imageup=new BufferedImage[4];
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageEnemy= ImageIO.read(new File(path,"Dragon.png"));
        int x=0; int y=0;
        for(int i=0;i<4;i++){
            imagedown[i]=imageEnemy.getSubimage(x,y,100,100);
            x=x+100;
        }
        y=y+100;x=0;
        for(int i=0;i<4;i++){
            imageleft[i]=imageEnemy.getSubimage(x,y,100,100);
            x=x+100;
        }
        y=y+100;x=0;
        for(int i=0;i<4;i++){
            imageright[i]=imageEnemy.getSubimage(x,y,100,100);
            x=x+100;
        }
        y=y+100;x=0;
        for(int i=0;i<4;i++){
            imageup[i]=imageEnemy.getSubimage(x,y,100,100);
            x=x+100;
        }

    }
}
