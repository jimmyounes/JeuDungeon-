package controller;

import model.Enemy.Enemy;
import model.Player;
import model.Room;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class EnemyController {
     Enemy  enemy;


    public EnemyController(Enemy enemy) {
        this.enemy = enemy;
    }

    public void  FollowPlayer(Player player) {
                if (player.currentx == enemy.currentx && player.currenty > enemy.currenty) {

                    enemy.currenty = enemy.currenty + 1;

                } else if (player.currentx == enemy.currentx && player.currenty < enemy.currenty)
                    enemy.currenty = enemy.currenty - 1;
                else if (player.currenty == enemy.currenty && player.currentx < enemy.currentx){
                    enemy.currentx = enemy.currentx - 1;
                    enemy.direction="left";
                }
                else if (player.currenty == enemy.currenty && player.currentx > enemy.currentx){
                    enemy.direction="right";
                    enemy.currentx = enemy.currentx + 1;}
                else if (player.currentx > enemy.currentx && player.currenty > enemy.currenty) {

                    enemy.currentx = enemy.currentx + 1;
                    enemy.currenty = enemy.currenty + 1;
                    enemy.direction="right";
                } else if (player.currentx > enemy.currentx && player.currenty < enemy.currenty) {
                    enemy.currentx = enemy.currentx + 1;
                    enemy.currenty = enemy.currenty - 1;
                    enemy.direction="right";
                } else if (player.currentx < enemy.currentx && player.currenty > enemy.currenty) {
                    enemy.currentx = enemy.currentx - 1;
                    enemy.direction="left";
                    enemy.currenty = enemy.currenty + 1;
                } else if (player.currentx < enemy.currentx && player.currenty < enemy.currenty) {
                    enemy.currentx = enemy.currentx - 1;
                    enemy.direction="left";
                    enemy.currenty = enemy.currenty - 1;
                }



    }
    public void  enemyMove(Room room,Player player) {
        if(PlayerbehindEnemey(player)){
            if(((System.nanoTime()-enemy.startAttack)/Math.pow(10,9))>2){
            System.out.println();
            enemy.attack=true;
            enemy.startAttack=System.nanoTime();
            CombatController.Enemyattack(player,enemy);}
        }
       else  if (enemy.FollowPlayer) FollowPlayer(player);
             else {
            if(player.currentx>enemy.xMinMove && player.currentx<enemy.xMaxMove && player.currenty>enemy.yMinMove && player.currenty<enemy.yMaxMove){
                enemy.FollowPlayer=true;
                FollowPlayer(player);
               }
           else   if (enemy.moveIn == "x") {
                if (enemy.currentx + enemy.moveAxisX == enemy.xMaxMove) {
                    if (enemy.moveAxisX == -1) enemy.direction = "left";
                    else enemy.direction = "right";
                    enemy.currentx = enemy.currentx + enemy.moveAxisX;
                    enemy.moveAxisX = enemy.moveAxisX * -1;
                    enemy.moveIn = "Y";

                } else if (enemy.currentx + enemy.moveAxisX == enemy.xMinMove) {
                    if (enemy.moveAxisX == -1) enemy.direction = "left";
                    else enemy.direction = "right";
                    enemy.currentx = enemy.currentx + enemy.moveAxisX;

                    enemy.moveAxisX = enemy.moveAxisX * -1;
                    enemy.moveIn = "Y";
                } else {
                    if (enemy.moveAxisX == -1) enemy.direction = "left";
                    else enemy.direction = "right";
                    enemy.currentx = enemy.currentx + enemy.moveAxisX;
                }
            } else if (enemy.moveIn == "Y") {

                if (enemy.currenty + enemy.moveAxisy == enemy.yMaxMove) {
                    if (enemy.moveAxisy == -1) enemy.direction = "back";
                    else enemy.direction = "";
                    enemy.currenty = enemy.currenty + enemy.moveAxisy;
                    enemy.moveAxisy = enemy.moveAxisy * -1;
                    enemy.moveIn = "x";
                } else if (enemy.currenty + enemy.moveAxisy == enemy.yMinMove) {
                    if (enemy.moveAxisy == -1) enemy.direction = "back";
                    else enemy.direction = "";
                    enemy.currenty = enemy.currenty + enemy.moveAxisy;
                    enemy.moveAxisy = enemy.moveAxisy * -1;
                    enemy.moveIn = "x";
                } else {
                    if (enemy.moveAxisy == -1) enemy.direction = "back";
                    else enemy.direction = "";
                    enemy.currenty = enemy.currenty + enemy.moveAxisy;
                }
            }
        }
    }
    public boolean PlayerbehindEnemey(Player player){
        if( (player.currentx+40>enemy.currentx && enemy.currentx>=player.currentx && ((player.currenty+40>enemy.currenty && enemy.currenty>=player.currenty) || (player.currenty-40< enemy.currenty && player.currenty> enemy.currenty))) || (player.currentx-40< enemy.currentx && player.currentx> enemy.currentx && ((player.currenty+40>enemy.currenty && enemy.currenty>=player.currenty) || (player.currenty-40< enemy.currenty && player.currenty> enemy.currenty)))   ){

            return true;
        }
        return false;
    }

}
