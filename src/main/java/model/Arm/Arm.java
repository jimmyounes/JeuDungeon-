package model.Arm;


import model.ElementOfChest.ElementOFchest;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Arm extends ElementOFchest{
    public    int degat;
    public boolean Capabledetirer=false;
    public ArrayList<Bullet> listdeballes=new ArrayList<>();
    public abstract  void renderArm(Graphics graphics,int x,int y,String direction) throws IOException;
    public abstract void rendereffet(Graphics graphics,int x,int y,String direction) throws IOException;


    public Arm() {
    }

}
