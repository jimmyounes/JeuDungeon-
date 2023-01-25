package model;

import java.awt.*;
import java.io.IOException;

public interface Composant {
    public void render(Graphics graphics) throws IOException, InterruptedException;
    public void setxgraphic(int x);
    public void setygraphic(int y);
    public int getxgraphic();
    public int getygraphic();
}
