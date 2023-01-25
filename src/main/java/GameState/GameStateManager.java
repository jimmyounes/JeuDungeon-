package GameState;

import controller.CombatController;
import controller.EnemyController;
import javafx.scene.canvas.GraphicsContext;
import model.Door;
import model.Dungeon;
import model.Enemy.Enemy;
import model.Loader;
import model.Player;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GameStateManager implements GameState {
    public Player player;
    Dungeon dungeon ;
    static int i=0;

    public GameStateManager() throws IOException {
        dungeon=new Dungeon();
        Loader.LoaderRoomsMonster(dungeon);
        player=new Player(200,100);

    }


    public  void render(Graphics g) throws IOException, InterruptedException {
          dungeon.render(g);
          player.render(g);
          MonsterMove();
          CombatController.GestionofBalleplayer(player, dungeon.currentRoom);
    }

    public  void keyPressed( Game currentgame,char event) throws InterruptedException {
        switch (event) {
            case 'd':
               if(!dungeon.currentRoom.IsWall(player.currentx+17, player.currenty)) player.Moveright();
                break;
            case 'q':
                if(!dungeon.currentRoom.IsWall(player.currentx-17, player.currenty))    player.Moveleft();
                break;
            case 'z':
                if(!dungeon.currentRoom.IsWall(player.currentx, player.currenty-17)) player.MoveUp();
            break;
            case 's':
                if(!dungeon.currentRoom.IsWall(player.currentx, player.currenty+17))  player.MoveDown();
            break;
            case 'o':
                if(dungeon.currentRoom.isDoor(player.currentx+10, player.currenty)){
                    Door door=dungeon.currentRoom.getDoor(player.currentx+10, player.currenty) ;
                       player.currentx=60;
                       player.currenty=60;

                    dungeon.changeroom(door.inextroom);

                }
                dungeon.currentRoom.PlayerBehindChest(player);
                break;
            case 'a':
                if(!player.arm.Capabledetirer ){

                CombatController.PlayerAttack(dungeon.currentRoom,player);
                }
                break;
            case 't':
                dungeon.currentRoom.Takeelementofchest(player);
                break;
            case 'e':
                 if(player.arm.Capabledetirer &&  ((System.nanoTime() - player.startshot) / Math.pow(10, 9) > 2) ){
                     player.startshot=System.nanoTime();
                     CombatController.PlayerAttackwithBullet(player);
                 }
        }
        if (0>player.vitality)currentgame.setCurrentgamestate(new GameOver());
        if(dungeon.currentRoom.iRoom==4)currentgame.setCurrentgamestate(new Fingame());

    }
    public void MonsterMove() throws InterruptedException {
        EnemyController enemyController;
        for(int i=0;i<dungeon.currentRoom.ListOfEnemiesen.size();i++){
            enemyController=new EnemyController(dungeon.currentRoom.ListOfEnemiesen.get(i));

            enemyController.enemyMove(dungeon.currentRoom,player);
        }


    }


}
