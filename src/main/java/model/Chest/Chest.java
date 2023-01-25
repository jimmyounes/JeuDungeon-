package model.Chest;

import model.Arm.Mitraillete;
import model.ElementOfChest.ElementOFchest;
import model.Player;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Chest {
       public int currentx;
       public int currenty;
       public  Chest currentChest;
       public boolean open;

    public Chest(int currentx, int currenty) {
        this.currentx = currentx;
        this.currenty = currenty;
        currentChest=new ChestClose(currentx,currenty,elementsofChest);
        open=false;
    }

    public ArrayList<ElementOFchest> elementsofChest=new ArrayList<>();

    public Chest() {
    }

    public  void render(Graphics graphics) throws IOException{
        currentChest.render(graphics);
    }
    public void Openchest(){
        currentChest=new ChestOpen(currentx,currenty,elementsofChest);
        open=true;
    }
    public void addElementforChest(ElementOFchest element){this.elementsofChest.add(element);}

    public boolean PLayerbehindelement(Player player){
        for(int i=0;i<elementsofChest.size();i++){
            ElementOFchest chest=elementsofChest.get(i);

            if(( (player.currentx+30>chest.currentx && chest.currentx>=player.currentx && ((player.currenty+30>chest.currenty && chest.currenty>=player.currenty) || (player.currenty+30< chest.currenty && player.currenty> chest.currenty))) || (player.currentx-30< chest.currentx && player.currentx> chest.currentx && ((player.currenty+30>chest.currenty && chest.currenty>=player.currenty) || (player.currenty-30< chest.currenty && player.currenty> chest.currenty))))) {
                chest.updateplayer(player);
                elementsofChest.remove(i);
                return true;
            }

        }
        return false;
    }

}
