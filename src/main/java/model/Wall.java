package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Wall implements Composant {
    int xgraphic;
    int ygraphic;

    public Wall(int xgraphic, int ygraphic) {
        this.xgraphic = xgraphic;
        this.ygraphic = ygraphic;
    }

    @Override
    public void render(Graphics graphics) throws IOException {
        File path = new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageGazon = ImageIO.read(new File(path, "wall.png"));
        graphics.drawImage(imageGazon, xgraphic, ygraphic, null);
    }
    @Override
    public void setxgraphic(int x) {
        xgraphic = x;
    }

    @Override
    public void setygraphic(int y) {
        ygraphic = y;
    }
    public int getxgraphic(){
       return  xgraphic;
    }
    public int getygraphic(){
        return ygraphic;
    }
}