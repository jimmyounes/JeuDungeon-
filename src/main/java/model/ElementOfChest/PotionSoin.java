package model.ElementOfChest;

import model.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PotionSoin extends ElementOFchest{
    public int HealthIncrease;


    public void render(Graphics graphics,int x,int y) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imagepotion= ImageIO.read(new File(path,"potionsoin.png"));
        graphics.drawImage(imagepotion,x,y,null);
    }

    public PotionSoin(int currentx, int currenty) {
        this.currentx = currentx;
        this.currenty = currenty;
        this.HealthIncrease=40;
    }
    public void render(Graphics graphics) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imagepotion= ImageIO.read(new File(path,"potionsoin.png"));
        graphics.drawImage(imagepotion,currentx,currenty,null);
    }

    @Override
    public void updateplayer(Player player) {
        if(player.vitality+HealthIncrease>100)player.vitality=100;
        else player.vitality=player.vitality+HealthIncrease;
    }
}
