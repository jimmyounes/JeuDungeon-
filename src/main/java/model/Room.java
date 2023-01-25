package model;

import model.Chest.Chest;
import model.Enemy.Enemy;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Room {
    public int iRoom;

    Tile tile;
    public ArrayList<Enemy> ListOfEnemiesen;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;
    public static final int SizeofTile=50;
    public Composant[][] composants=new Composant[16][10];
    ArrayList<Room> neighboursrooms=new ArrayList<>();
    ArrayList<Chest> ListofChest=new ArrayList<>();



    public Room(int iRoom, Tile tile) {
        this.iRoom = iRoom;
        this.tile=tile;
        ListOfEnemiesen=new ArrayList<>();

    }

    public void render(Graphics graphics) throws IOException, InterruptedException {
        int icount=0;
        int ycount=0;
        for(int i=0;i<16;i++){
            for(int j=0;j<10;j++){

                composants[i][j].setygraphic(ycount);
                composants[i][j].setxgraphic(icount);
                ycount=ycount+50;
                composants[i][j].render(graphics);

            }
            ycount=0;
            icount=icount+50;
        }

        for(int i=0;i<ListofChest.size();i++){
            ListofChest.get(i).render(graphics);
        }
        for(int i=0;i<ListOfEnemiesen.size();i++){
            ListOfEnemiesen.get(i).render(graphics);
        }
    }

    public void addneighboursrooms(Room room){
        neighboursrooms.add(room);
    }
    public void deleteneighboursroom(int index){
        if(index<0 || index>=neighboursrooms.size())throw new IndexOutOfBoundsException();
        neighboursrooms.remove(index);
    }
    public boolean IsWall(int x,int y){
        x=x/SizeofTile;
        y=y/SizeofTile;
        if(x<0 ||y<0)return true;
        return (composants[x][y] instanceof Wall) ;
    }
    public void AddWall(int i,int j){
        composants[i][j]=new Wall(i*SizeofTile,j*SizeofTile);


    }
    public void AddDoor(int i,int j,int inextroom){
        this.composants[i][j]=new Door(i*SizeofTile,j*SizeofTile,inextroom);
        System.out.println(iRoom);

    }
    public void AddDoor(Door door){
        this.composants[door.Xgraphic][door.Ygraphic]=door;

    }
   public void initialize(){
       int icount=0;
       int ycount=0;
       for(int i=0;i<16;i++){
           for(int j=0;j<10;j++){
               if(icount==0 ||ycount==0 ||  icount==750 || ycount==450 )composants[i][j]=new Stones(icount,ycount);
               else composants[i][j]=tile;
               composants[i][j].setygraphic(ycount);
               composants[i][j].setxgraphic(icount);
               ycount=ycount+SizeofTile;

           }
           ycount=0;
           icount=icount+SizeofTile;
       }


   }
   public boolean isDoor(int i,int y){
        i=i/SizeofTile;
        y=y/SizeofTile;
        return (composants[i][y] instanceof Door);
   }
   public Door getDoor(int i,int y){
       i=i/SizeofTile;
       y=y/SizeofTile;

       if(composants[i][y] instanceof Door)return (Door) composants[i][y];
       else return null;
   }
   public void AddEnemey(Enemy enemy){
        Enemy cloneenemy=enemy;
        ListOfEnemiesen.add(cloneenemy);
   }
   public void AddChest(Chest chest){ListofChest.add(chest);}

    public void PlayerBehindChest(Player player){

        for(int i=0;i<ListofChest.size();i++){
            Chest chest=ListofChest.get(i);
            if(( (player.currentx+30>chest.currentx && chest.currentx>=player.currentx && ((player.currenty+30>chest.currenty && chest.currenty>=player.currenty) || (player.currenty+30< chest.currenty && player.currenty> chest.currenty))) || (player.currentx-30< chest.currentx && player.currentx> chest.currentx && ((player.currenty+30>chest.currenty && chest.currenty>=player.currenty) || (player.currenty-30< chest.currenty && player.currenty> chest.currenty))))) {

                ListofChest.get(i).Openchest();
            }
        }
    }
    public void Takeelementofchest(Player player){
        for(int i=0;i<ListofChest.size();i++){
            if(ListofChest.get(i).open)ListofChest.get(i).PLayerbehindelement(player);
        }

    }
}
