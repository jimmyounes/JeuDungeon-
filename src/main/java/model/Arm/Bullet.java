package model.Arm;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet {
    public int currentx;
    public int currenty;
    public String direction;

    public Bullet(int currentx, int currenty,String direction) {
        this.currentx = currentx;
        this.currenty = currenty;
        this.direction=direction;
    }
    public void render(Graphics graphics) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imagearm= ImageIO.read(new File(path,"balleup.png"));
        if(direction=="up")imagearm= ImageIO.read(new File(path,"balleup.png"));
        if(direction=="down")imagearm= ImageIO.read(new File(path,"balledwon.png"));
        if(direction=="right") imagearm= ImageIO.read(new File(path,"balle.png"));
        if(direction=="left") imagearm= ImageIO.read(new File(path,"balleleft.png"));
        graphics.drawImage(imagearm,currentx,currenty,null);
    }
}
