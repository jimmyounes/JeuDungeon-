package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MagmaTile extends Tile{
    public MagmaTile(int xgraphic, int ygraphic) {
        super(xgraphic, ygraphic);
    }

    @Override
    public void render(Graphics graphics) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageGazon= ImageIO.read(new File(path,"magma.jpg"));
        graphics.drawImage(imageGazon,Xgraphic,Ygraphic,null);
    }
}
