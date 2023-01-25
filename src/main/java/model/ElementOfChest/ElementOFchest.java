package model.ElementOfChest;

import model.Player;

import java.awt.*;
import java.io.IOException;

public abstract class ElementOFchest {
    public int currentx;
    public int currenty;
    public abstract void render(Graphics graphics) throws IOException;
    public abstract void updateplayer(Player player);
}
