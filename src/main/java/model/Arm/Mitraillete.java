package model.Arm;

import model.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Mitraillete extends Arm{
     public Mitraillete(int x,int y){
         this.currentx=x;
         this.currenty=y;
         degat=50;
         Capabledetirer=true;
     }
    public Mitraillete() {
        degat=30;
        Capabledetirer=true;
    }

    @Override
    public void renderArm(Graphics graphics, int x, int y, String direction) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imagearm= ImageIO.read(new File(path,"ak.png"));
       if(direction=="up")imagearm= ImageIO.read(new File(path,"akup.png"));
       if(direction=="down")imagearm= ImageIO.read(new File(path,"akdown.png"));
       if(direction=="right") imagearm= ImageIO.read(new File(path,"ak.png"));
       if(direction=="left") imagearm= ImageIO.read(new File(path,"akleft.png"));
       graphics.drawImage(imagearm,x,y,null);
       for (int i=0;i<listdeballes.size();i++){
           listdeballes.get(i).render(graphics);
       }

    }

    @Override
    public void rendereffet(Graphics graphics, int x, int y, String direction) throws IOException {

    }

    @Override
    public void render(Graphics graphics) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imagepotion= ImageIO.read(new File(path,"ak.png"));
        graphics.drawImage(imagepotion,currentx,currenty,null);
    }

    @Override
    public void updateplayer(Player player) {

        player.arm=this;

    }
}
