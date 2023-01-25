package GameState;

import java.awt.*;
import java.io.IOException;

public class GameOver implements GameState{
    @Override
    public void render(Graphics graphics) throws IOException, InterruptedException {
     graphics.setColor(Color.BLUE);
     graphics.setFont(new Font("Araial", Font.PLAIN, 100));
        graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);
        graphics.setColor(Color.CYAN);
     graphics.drawString("GAME OVER",200,200);
    }

    public GameOver() {
    }

    @Override
    public void keyPressed(Game currentgamestate, char event) throws InterruptedException {
        switch (event){
            case 10:
                currentgamestate.setCurrentgamestate(new Gamestatestart());
                break;
        }
    }
}
