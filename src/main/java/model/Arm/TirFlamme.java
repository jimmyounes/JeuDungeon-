package model.Arm;

import model.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TirFlamme extends Arm{
    public TirFlamme(int x,int y){
        currentx=x;
        currenty=y;
        degat=30;
        Capabledetirer=false;
    }
    @Override
    public void renderArm(Graphics graphics, int x, int y, String direction) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imagearm= ImageIO.read(new File(path,"pistoletflammes.png"));
        if(direction=="up")   imagearm= ImageIO.read(new File(path,"pistoletflammesup.png"));
        if(direction=="down")   imagearm= ImageIO.read(new File(path,"pistoletflammesdown.png"));
        if(direction=="right")   imagearm= ImageIO.read(new File(path,"pistoletflammes.png"));
        if(direction=="left")   imagearm= ImageIO.read(new File(path,"pistoletflammesleft.png"));
        graphics.drawImage(imagearm,x,y,null);
    }

    @Override
    public void rendereffet(Graphics graphics, int x, int y, String direction) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageEffect= ImageIO.read(new File(path,"fire.png"));
        if (direction=="right"){
            imageEffect= ImageIO.read(new File(path,"fire.png"));
            graphics.drawImage(imageEffect,x+50,y+5,null);
        }
        if(direction=="up"){
            imageEffect= ImageIO.read(new File(path,"fireup.png"));
            graphics.drawImage(imageEffect,x,y-40,null);
        }
        if(direction=="down"){
            imageEffect= ImageIO.read(new File(path,"firedown.png"));
            graphics.drawImage(imageEffect,x-5,y+50,null);
        }
        if(direction=="left"){
            imageEffect= ImageIO.read(new File(path,"fireleft.png"));
            graphics.drawImage(imageEffect,x-30,y,null);
        }

    }

    public TirFlamme() {
        degat=30;
        Capabledetirer=false;

    }

    @Override
    public void render(Graphics graphics) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imagearm= ImageIO.read(new File(path,"pistoletflammes.png"));
        graphics.drawImage(imagearm,currentx,currenty,null);
    }

    @Override
    public void updateplayer(Player player) {
        player.arm=this;
    }
}
