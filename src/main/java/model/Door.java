package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Door implements Composant {
    public  int Xgraphic;
    public  int Ygraphic;
    public int inextroom;


    public Door(int xgraphic, int ygraphic, int inextroom) {
        Xgraphic = xgraphic;
        Ygraphic = ygraphic;
        this.inextroom = inextroom;

    }

    @Override
    public void render(Graphics graphics) throws IOException, InterruptedException {
        File path = new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageGazon = ImageIO.read(new File(path, "stone.png"));
        graphics.drawImage(imageGazon, Xgraphic, Ygraphic, null);
         path = new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
       imageGazon = ImageIO.read(new File(path, "porte.png"));
        graphics.drawImage(imageGazon, Xgraphic, Ygraphic, null);
    }

    @Override
    public void setxgraphic(int x) {
         Xgraphic=x;
    }


    @Override
    public void setygraphic(int y) {
       Ygraphic=y;
    }

    @Override
    public int getxgraphic() {
        return Xgraphic;
    }

    @Override
    public int getygraphic() {
        return Ygraphic;
    }

    public Door(int xgraphic, int ygraphic) {
        Xgraphic = xgraphic;
        Ygraphic = ygraphic;
    }

}
