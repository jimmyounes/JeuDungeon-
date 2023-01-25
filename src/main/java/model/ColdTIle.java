package model;

import model.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColdTIle extends Tile {
    public ColdTIle(int xgraphic, int ygaphic) {
        super(xgraphic, ygaphic);
    }

    @Override
    public void render(Graphics graphics) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageGazon= ImageIO.read(new File(path,"cold.jpg"));
        graphics.drawImage(imageGazon,Xgraphic,Ygraphic,null);
    }
}
