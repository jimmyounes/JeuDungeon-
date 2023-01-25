package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Arm.Arm;
import model.Arm.Hand;
import model.Arm.Mitraillete;
import model.Arm.TirFlamme;
import view.ConsoleView;
import view.View;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity{
    View view ;
    public Arm arm;
    public static int mov=0;

    public double startshot;
    public static int i=0;

    public Player(View view) {
        super();
        this.view = view;
        this.vitality=100;
        attack=false;
        startshot=2*Math.pow(10,9);
    }

    public void goNorth() {
        view.handleMove(new Move("You face a wall"));
    }
    String currentDirection;


    public Player(int strength, int vitality) throws IOException {
        super(strength, vitality);
        currentx=60;
        currenty=60;
        direction="fixe";
        this.vitality=100;
        attack=false;
        arm=new Hand();
        initialize();
    }

    public void setCurrentDirection(String currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void render(Graphics graphics) throws IOException {
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
      //  System.out.println(direction);

        if(direction=="up"){
            arm.renderArm(graphics,currentx,currenty-20,"up");
            graphics.drawImage(imageup[i],currentx,currenty,null);
        }
        else if(direction=="right"){
            arm.renderArm(graphics,currentx+10,currenty+5,"right");
            graphics.drawImage(imageright[i],currentx,currenty,null);

        }
        else if(direction=="left"){
            arm.renderArm(graphics,currentx-20,currenty+5,"left");
            graphics.drawImage(imageleft[i],currentx,currenty,null);

        }
        else if(direction=="down"){
            arm.renderArm(graphics,currentx,currenty+20,"down");
            graphics.drawImage(imagedown[i],currentx,currenty,null);

        }
     //  if(mov==4){
           i++;
          // mov=0;
       //}
        if(i==4)i=0;
        mov++;


        BufferedImage imageheart=ImageIO.read(new File(path,"heart.png"));

        graphics.drawImage(imageheart,50,0,null);
        String vit=Integer.toString(this.vitality);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("TimesRoman", Font.PLAIN,40));
        graphics.drawString(vit,120,50);
        if(attack){

          if(direction=="right")  arm.rendereffet(graphics,currentx+3,currenty,direction);
          else if(direction=="left")arm.rendereffet(graphics,currentx-20,currenty,direction);
          else if(direction=="down")arm.rendereffet(graphics,currentx,currenty+3,direction);
          else arm.rendereffet(graphics,currentx,currenty-15,direction);
            attack=false;
        }
    }
    public void Moveright(){
        currentx=currentx+10;
        direction="right";
        if(mov==0)mov=1;
        else mov=0;

    }
    public void Moveleft(){
        currentx=currentx-10;
        direction="left";
        if(mov==0)mov=1;
        else mov=0;
    }
    public void MoveUp(){
        currenty=currenty-10;
        direction="up";
        if(mov==0)mov=1;
        else mov=0;
    }
    public void MoveDown(){
        currenty=currenty+10;
        direction="down";
        if(mov==0)mov=1;
        else mov=0;
    }
    public void initialize() throws IOException {
        this.imagedown=new BufferedImage[4];
        this.imageleft=new BufferedImage[4];
        this.imageright=new BufferedImage[4];
        this.imageup=new BufferedImage[4];
        File path= new File("/home/younes/IdeaProjects/dungeon/src/main/java/ressources");
        BufferedImage imageEnemy= ImageIO.read(new File(path,"playerc.png"));
        int x=0; int y=0;
        for(int i=0;i<4;i++){
            imagedown[i]=imageEnemy.getSubimage(x,y,32,48);
            x=x+32;
        }
        y=y+48;x=0;
        for(int i=0;i<4;i++){
            imageleft[i]=imageEnemy.getSubimage(x,y,32,48);
            x=x+32;
        }
        y=y+48;x=0;
        for(int i=0;i<4;i++){
            imageright[i]=imageEnemy.getSubimage(x,y,32,48);
            x=x+32;
        }
        y=y+48;x=0;
        for(int i=0;i<4;i++){
            imageup[i]=imageEnemy.getSubimage(x,y,32,48);
            x=x+32;
        }

    }
}
