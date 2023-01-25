package model;

import model.Arm.Mitraillete;
import model.Arm.TirFlamme;
import model.Chest.Chest;
import model.ElementOfChest.PotionSoin;
import model.Enemy.Aigle;
import model.Enemy.Dragon;
import model.Enemy.Goblin;

import java.io.IOException;

public class Loader {

    public static void LoaderRoomsMonster(Dungeon dungeon) throws IOException {
        dungeon.rooms[0]=new Room(0,new ColdTIle(0,0));

        dungeon.rooms[1]=new Room(1,new ColdTIle(0,0));
        dungeon.rooms[2]=new Room(2,new ColdTIle(0,0));
        dungeon.rooms[3]=new Room(3,new DirtTile(0,0));
        dungeon.rooms[4]=new Room(4,new MagmaTile(0,0));
        dungeon.rooms[3].initialize();
         dungeon.rooms[2].initialize();
        dungeon.rooms[0].initialize();
        dungeon.rooms[1].initialize();
        Goblin goblin=new Goblin();
        goblin.xMaxMove=300;
        goblin.yMaxMove=300;
        //dungeon.rooms[0].AddEnemey(goblin);
        Aigle aigle=new Aigle();
        aigle.xMaxMove=400;
        aigle.yMaxMove=400;
        Chest chest=new Chest(400,200);
        chest.addElementforChest(new PotionSoin(410,200));
        chest.addElementforChest(new PotionSoin(390,200));
        chest.addElementforChest(new TirFlamme(400,220));
        Dragon dragon =new Dragon(400,200);
        dragon.xMaxMove=450;
        dragon.yMaxMove=250;

        //dungeon.rooms[0].AddEnemey(dragon);
        dungeon.rooms[0].AddEnemey(new Aigle(400,200,450,250));
        dungeon.rooms[0].AddEnemey(new Aigle(100,100,300,300));
        dungeon.rooms[0].AddChest(chest);
        dungeon.rooms[0].AddEnemey(aigle);
        dungeon.rooms[0].AddWall(10,7);
        dungeon.rooms[0].AddWall(10,3);
        dungeon.rooms[0].AddWall(10,1);
        dungeon.rooms[0].AddWall(4,5);
        dungeon.rooms[0].AddWall(3,5);
        dungeon.rooms[0].AddWall(3,7);
        dungeon.rooms[0].AddWall(3,9);
        dungeon.rooms[0].AddWall(4,7);
        dungeon.rooms[0].AddWall(4,9);
        dungeon.rooms[0].AddWall(4,3);
        dungeon.rooms[0].AddWall(3,3);
        dungeon.rooms[0].AddWall(3,1);
        dungeon.rooms[0].AddWall(4,1);
        dungeon.rooms[0].AddWall(11,1);
        dungeon.rooms[0].AddWall(11,3);
        dungeon.rooms[0].AddWall(11,5);



        dungeon.rooms[0].AddDoor(15,4,1);



        dungeon.currentRoom=dungeon.rooms[0];
        dungeon.rooms[1].AddDoor(15,4,2);
        dungeon.rooms[1].AddDoor(0,4,0);


        dungeon.rooms[1].AddWall(3,1);
        dungeon.rooms[1].AddWall(3,2);
        dungeon.rooms[1].AddWall(3,3);
        dungeon.rooms[1].AddWall(3,4);
        dungeon.rooms[1].AddWall(3,5);
        dungeon.rooms[1].AddWall(3,6);
        dungeon.rooms[1].AddWall(3,8);
        dungeon.rooms[1].AddWall(6,8);
        dungeon.rooms[1].AddWall(6,7);
        dungeon.rooms[1].AddWall(6,6);
        dungeon.rooms[1].AddWall(6,5);
        dungeon.rooms[1].AddWall(6,4);
        dungeon.rooms[1].AddWall(6,3);
        dungeon.rooms[1].AddWall(6,1);
        dungeon.rooms[1].AddWall(9,1);
        dungeon.rooms[1].AddWall(9,2);
        dungeon.rooms[1].AddWall(9,3);
        dungeon.rooms[1].AddWall(9,4);
        dungeon.rooms[1].AddWall(9,5);
        dungeon.rooms[1].AddWall(9,6);
        dungeon.rooms[1].AddWall(9,8);
        dungeon.rooms[1].AddWall(12,8);
        dungeon.rooms[1].AddWall(12,7);
        dungeon.rooms[1].AddWall(12,6);
        dungeon.rooms[1].AddWall(12,5);
        dungeon.rooms[1].AddWall(12,4);
        dungeon.rooms[1].AddWall(12,3);
        dungeon.rooms[1].AddWall(12,1);
        Chest chest1=new Chest(400,100);
        chest1.addElementforChest(new PotionSoin(410,100));
        chest1.addElementforChest(new PotionSoin(400,90));
        dungeon.rooms[1].AddChest(chest1);
        Aigle aigle1=new Aigle(350,100);
        aigle1.xMaxMove=400;
        aigle1.yMaxMove=300;
        Aigle aigle2=new Aigle(200,100);
         aigle2.yMaxMove=450;
         aigle2.xMaxMove=250;
         Aigle aigle3=new Aigle(50,400);
        aigle3.yMaxMove=450;
        aigle3.xMaxMove=150;
        Goblin goblin2=new Goblin(500,300);
        goblin2.xMaxMove=550;
        goblin2.yMaxMove=350;
        Goblin goblin3=new Goblin(650,150);
        goblin3.xMaxMove=700;
        goblin3.yMaxMove=200;

        dungeon.rooms[1].AddEnemey(aigle1);
        dungeon.rooms[1].AddEnemey(aigle2);
        dungeon.rooms[1].AddEnemey(aigle3);
        dungeon.rooms[1].AddEnemey(goblin2);
        dungeon.rooms[1].AddEnemey(goblin3);

        Chest chest3=new Chest(500,80);
        chest3.addElementforChest(new PotionSoin(500,90));
        chest3.addElementforChest(new PotionSoin(490,80));
        chest3.addElementforChest(new Mitraillete(500,100));
         dungeon.rooms[2].AddChest(chest3);
        dungeon.currentRoom.addneighboursrooms(dungeon.rooms[1]);

        dungeon.rooms[1].addneighboursrooms(dungeon.rooms[0]);
        dungeon.rooms[1].addneighboursrooms(dungeon.rooms[2]);
        dungeon.rooms[2].addneighboursrooms(dungeon.rooms[1]);
        dungeon.rooms[2].addneighboursrooms(dungeon.rooms[3]);
        dungeon.rooms[2].AddWall(4,6);
        dungeon.rooms[2].AddWall(5,6);
        dungeon.rooms[2].AddWall(6,6);
        dungeon.rooms[2].AddWall(7,6);
        dungeon.rooms[2].AddWall(8,6);
        dungeon.rooms[2].AddWall(9,6);
        dungeon.rooms[2].AddWall(10,6);
        dungeon.rooms[2].AddWall(10,5);
        dungeon.rooms[2].AddWall(10,4);
        dungeon.rooms[2].AddWall(4,5);
        dungeon.rooms[2].AddWall(4,4);
        dungeon.rooms[2].AddWall(5,4);
        dungeon.rooms[2].AddWall(6,4);
        dungeon.rooms[2].AddWall(9,4);
        dungeon.rooms[2].AddWall(8,4);
        dungeon.rooms[2].AddDoor(7,5,3);
        dungeon.rooms[2].AddDoor(0,4,1);


        dungeon.rooms[3].AddEnemey(new Dragon(100,100,200,200));
        dungeon.rooms[3].AddEnemey(new Dragon(100,300,200,350));
        dungeon.rooms[3].AddEnemey(new Dragon(300,100,400,200));
        dungeon.rooms[3].AddEnemey(new Dragon(300,200,400,300));
        dungeon.rooms[3].AddDoor(15,4,4);
        dungeon.rooms[3].addneighboursrooms(dungeon.rooms[4]);


        Dragon dragon2=new Dragon(100,0);
        dragon2.yMaxMove=400;
        dragon2.xMaxMove=300;
        dungeon.rooms[2].AddEnemey(new Goblin(100,0,300,200));
        dungeon.rooms[2].AddEnemey(new Goblin(300,400,0,150));
        dungeon.rooms[2].AddEnemey(new Goblin(100,200,250,250));
        dungeon.rooms[2].AddEnemey(new Goblin(300,200,350,250));
       // dungeon.rooms[2].AddEnemey(dragon2);
       // dungeon.rooms[2].AddEnemey(new Dragon(500,0,700,400));
       // dungeon.rooms[2].AddEnemey(new Dragon(300,250,350,300));


    }
}
