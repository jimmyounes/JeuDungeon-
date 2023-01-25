package model.Arm;

import model.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Hand extends Arm {
    public BufferedImage[] imageattack;

    public Hand() throws IOException {
        this.degat = 40;
        initialize();
    }

    @Override
    public void renderArm(Graphics graphics, int x, int y, String direction) {

    }

    @Override
    public void rendereffet(Graphics graphics, int x, int y, String direction) throws IOException {
        File path = new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageattack = ImageIO.read(new File(path, "attack.png"));
     /*   if(direction=="left") imageattack= ImageIO.read(new File(path,"attackleft.png"));
        if(direction=="down") imageattack= ImageIO.read(new File(path,"attackdown.png"));
        if(direction=="up") imageattack= ImageIO.read(new File(path,"attackup.png"));
        graphics.drawImage(imageattack,x,y,null);*/
        for (int i = 0; i < 4; i++) {
            graphics.drawImage(this.imageattack[i], x, y, null);

        }

    }
    public void initialize() throws IOException {
        File pathh = new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageattac = ImageIO.read(new File(pathh, "effecthand.png"));
        this.imageattack = new BufferedImage[4];
        int yy = 0;
        for (int i = 0; i < 4; i++) {
            this.imageattack[i] = imageattac.getSubimage(0, yy, 44, 50);
            yy = yy + 44;
        }
    }

    @Override
    public void render(Graphics graphics) throws IOException {

    }

    @Override
    public void updateplayer(Player player) {

    }
}
