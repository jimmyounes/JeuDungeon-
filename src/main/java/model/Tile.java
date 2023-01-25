package model;

import java.awt.*;
import java.io.IOException;

public abstract class Tile implements Composant {
      public  int Xgraphic;
      public  int Ygraphic;

    public Tile(int xgraphic, int ygaphic) {
        Xgraphic = xgraphic;
        Ygraphic = ygaphic;
    }

    @Override
    abstract public void render(Graphics graphics) throws IOException;
    @Override
    public void setxgraphic(int x){
        Xgraphic=x;
    }
    @Override
    public void setygraphic(int y){
        Ygraphic=y;
    }
    @Override
    public int getxgraphic(){
      return Xgraphic;
    }
    @Override
    public int getygraphic(){
        return Ygraphic;
    }

}
