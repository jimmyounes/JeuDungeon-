package GameState;

import java.awt.*;
import java.io.IOException;

public interface GameState {
    public void render(Graphics graphics) throws IOException, InterruptedException;
    public void keyPressed(Game currentgamestate,char event) throws InterruptedException, IOException;

}
