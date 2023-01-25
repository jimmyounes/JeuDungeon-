package GameState;

import java.awt.*;
import java.io.IOException;

public class Game {
    GameState currentgamestate;

    public Game() {
       currentgamestate=new Gamestatestart();
    }
    public void render(Graphics graphics) throws IOException, InterruptedException {
        currentgamestate.render(graphics);
    }
    public  void keyPressed(char event) throws InterruptedException, IOException {
        currentgamestate.keyPressed(this,event);
    }

    public void setCurrentgamestate(GameState currentgamestate) {
        this.currentgamestate = currentgamestate;
    }
}
