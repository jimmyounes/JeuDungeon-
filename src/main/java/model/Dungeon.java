package model;

import model.Chest.Chest;
import model.ElementOfChest.PotionSoin;
import model.Enemy.Aigle;
import model.Enemy.Goblin;

import java.awt.*;
import java.io.IOException;

public class Dungeon {
   public  Room[] rooms=new Room[8];
    public  Room currentRoom;
    public Dungeon() {

    }
    public void render(Graphics graphics) throws IOException, InterruptedException {
       currentRoom.render(graphics);
    }
    public void changeroom(int i){
        currentRoom=rooms[i];

    }
   public void addDoorforRoom(int iRoom,Door door){
        rooms[iRoom].AddDoor(door);
   }
}
