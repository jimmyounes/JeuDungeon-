package model.Chest;

import model.ElementOfChest.ElementOFchest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ChestClose extends Chest{

    public ChestClose(int currentx, int currenty, ArrayList<ElementOFchest> elementsofChest) {
        this.currentx=currentx;
        this.currenty=currenty;
        this.elementsofChest=elementsofChest;
    }

    @Override
    public void render(Graphics graphics) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imagechest= ImageIO.read(new File(path,"chestclose.png"));
        graphics.drawImage(imagechest,currentx,currenty,null);
    }
}
