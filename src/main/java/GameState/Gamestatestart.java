package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Gamestatestart implements GameState{

    private String[] optionsMenu;
    private static final String START_GAME = "Start Game";
    private static final String QUIT_GAME = "Quit game";
    private int selected;

    public Gamestatestart() {
        this.optionsMenu = new String[] {START_GAME, QUIT_GAME};
        this.selected = 0;
    }



    @Override
    public void render(Graphics graphics) {

        graphics.setColor(Color.gray);
        graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);

        graphics.setFont(new Font("Araial", Font.PLAIN, 25));
        for(int i=0;i<this.optionsMenu.length;i++) {
            if(i==this.selected) graphics.setColor(Color.RED);
            else graphics.setColor(Color.WHITE);
            graphics.drawString(this.optionsMenu[i], 150, 100 + i * 40);
        }
        graphics.setFont(new Font("Araial", Font.PLAIN, 15));
        graphics.setColor(Color.cyan);
        graphics.drawString("Z : Se diriger vers le haut ",20,200);
        graphics.drawString("Q : Se diriger vers la gauche ",220,200);
        graphics.drawString("D : Se diriger vers la droite ",450,200);
        graphics.drawString("S : Se diriger vers le bas ",20,250);
        graphics.drawString("E : tirer avec une arme",220,250);
        graphics.drawString("A : Attacker ",450,250);
        graphics.setFont(new Font("Araial", Font.PLAIN, 30));
        graphics.setColor(Color.pink);
        graphics.drawString("Welcome to Dungeon Game",200,50);
    }

    @Override
   public  void keyPressed( Game currentgame,char event) throws IOException {
       System.out.println((int)event);
        switch(event) {
            case 'z':
                if(this.selected > 0) this.selected--;
                break;
            case 's':
                if(this.selected < this.optionsMenu.length-1) this.selected++;
                break;
            case 10:
                switch(this.optionsMenu[selected]) {
                    case START_GAME:
                        currentgame.setCurrentgamestate(new GameStateManager());
                        break;
                    case QUIT_GAME:
                        System.exit(0);
                        break;
                }
                break;
        }
    }

}
