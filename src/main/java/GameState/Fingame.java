package GameState;

import java.awt.*;
import java.io.IOException;

public class Fingame implements GameState{
    @Override
    public void render(Graphics graphics) throws IOException, InterruptedException {
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font("Araial", Font.PLAIN, 100));
        graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);
        graphics.setColor(Color.CYAN);
        graphics.drawString("Fin du game",50,200);
    }

    public Fingame() {
    }

    @Override
    public void keyPressed(Game currentgamestate, char event) throws InterruptedException, IOException {
        switch (event){
            case 10:
                currentgamestate.setCurrentgamestate(new Gamestatestart());
                break;
        }
    }
}
