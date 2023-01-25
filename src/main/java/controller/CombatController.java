package controller;

import model.Arm.Bullet;
import model.Enemy.Enemy;
import model.Player;
import model.Room;

import java.util.ArrayList;

public class CombatController {
    Player player ;
    Enemy enemy;

    public CombatController(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }
    public static void PlayerAttack(Room room, Player player) {
        if ((System.nanoTime() - player.startshot) / Math.pow(10, 9) > 1) {
            player.attack=true;
            player.startshot=System.nanoTime();
            for (int i = 0; i < room.ListOfEnemiesen.size(); i++) {
                Enemy enemy = room.ListOfEnemiesen.get(i);
                if ((player.currentx + 40 > enemy.currentx && enemy.currentx >= player.currentx && ((player.currenty + 40 > enemy.currenty && enemy.currenty >= player.currenty) || (player.currenty - 40 < enemy.currenty && player.currenty > enemy.currenty))) || (player.currentx - 40 < enemy.currentx && player.currentx > enemy.currentx && ((player.currenty + 40 > enemy.currenty && enemy.currenty >= player.currenty) || (player.currenty - 40 < enemy.currenty && player.currenty > enemy.currenty)))) {
                    room.ListOfEnemiesen.get(i).vitality = room.ListOfEnemiesen.get(i).vitality - player.arm.degat;
                    if (room.ListOfEnemiesen.get(i).vitality < 0) room.ListOfEnemiesen.remove(i);
                }
            }
        }
    }
    public static void Enemyattack(Player player,Enemy enemy){
        player.vitality= player.vitality-enemy.strength;
    }
    public static void PlayerAttackwithBullet(Player player){
      //  player.arm.listdeballes.add(new Bullet(player.currentx, player.currenty+ 15,player.direction));
        if(player.direction=="up")player.arm.listdeballes.add(new Bullet(player.currentx, player.currenty-15,player.direction));
        if(player.direction=="right")player.arm.listdeballes.add(new Bullet(player.currentx+50, player.currenty+ 15,player.direction));
        if(player.direction=="left")player.arm.listdeballes.add(new Bullet(player.currentx-50, player.currenty+ 15,player.direction));
        if(player.direction=="down")player.arm.listdeballes.add(new Bullet(player.currentx, player.currenty+ 20,player.direction));
    }
    public static void GestionofBalleplayer(Player player,Room currentRoom){
        for(int index=0;index<player.arm.listdeballes.size();index++) {
            boolean utilise=false;
            for(int j=0;j<currentRoom.ListOfEnemiesen.size();j++){
                Enemy enemy=currentRoom.ListOfEnemiesen.get(j);
                Bullet ball=player.arm.listdeballes.get(index);
                if( (ball.currentx+40>enemy.currentx && enemy.currentx>=ball.currentx && ((ball.currenty+40>enemy.currenty && enemy.currenty>=ball.currenty) || (ball.currenty-40< enemy.currenty && ball.currenty> enemy.currenty))) || (ball.currentx-40< enemy.currentx && ball.currentx> enemy.currentx && ((ball.currenty+40>enemy.currenty && enemy.currenty>=ball.currenty) || (ball.currenty-40< enemy.currenty && ball.currenty> enemy.currenty))) ){
                    currentRoom.ListOfEnemiesen.get(j).vitality=currentRoom.ListOfEnemiesen.get(j).vitality-player.arm.degat;
                    if(currentRoom.ListOfEnemiesen.get(j).vitality<0)currentRoom.ListOfEnemiesen.remove(j);
                    player.arm.listdeballes.remove(index);
                    utilise=true;
                    break;
                }

            }
            if(!utilise) {
                if (player.arm.listdeballes.get(index).direction == "up")
                    player.arm.listdeballes.get(index).currenty = player.arm.listdeballes.get(index).currenty - 5;
                if (player.arm.listdeballes.get(index).direction == "right")
                    player.arm.listdeballes.get(index).currentx = player.arm.listdeballes.get(index).currentx + 5;
                if (player.arm.listdeballes.get(index).direction == "left")
                    player.arm.listdeballes.get(index).currentx = player.arm.listdeballes.get(index).currentx - 5;
                if (player.arm.listdeballes.get(index).direction == "down")
                    player.arm.listdeballes.get(index).currenty = player.arm.listdeballes.get(index).currenty + 5;

                if (currentRoom.IsWall(player.arm.listdeballes.get(index).currentx, player.arm.listdeballes.get(index).currenty) || currentRoom.isDoor(player.arm.listdeballes.get(index).currentx, player.arm.listdeballes.get(index).currenty))
                    player.arm.listdeballes.remove(index);
            }
            }

        }

    }

