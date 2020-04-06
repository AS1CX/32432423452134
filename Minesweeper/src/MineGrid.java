import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class MineGrid {

    public MineSpot[][] grid;
    public ArrayList<MineSpot> mineArr;
    public int[][] statN;
    public boolean[][] statM;
    public int mines;



    public MineGrid(int m){
        grid = new MineSpot[10][10];
        statN = new int[10][10];
        statM = new boolean[10][10];
        mineArr = new ArrayList<MineSpot>();
        mines = m;

    }
    public void fillGrid(){
        genMine(mines);
        genNumber();
       //System.out.println(Arrays.deepToString(statN));
        //System.out.println(Arrays.deepToString(statM));


        for(int x = 0;x < grid.length;x++){
            for(int y = 0;y < grid[x].length;y++){
                grid[x][y] = new MineSpot(getNumber(x,y),getMine(x,y));
                mineArr.add(grid[x][y]);
            }
        }
        System.out.println(Arrays.deepToString(grid));
    }
    public void genMine(int mines){
        int minesLeft = mines;
        int randX;
        int randY;
        while(minesLeft>0){
             randX = (int)(Math.random()*10);
             randY = (int)(Math.random()*10);
             if(statM[randX][randY] != true){
                 statM[randX][randY] = true;
                 minesLeft -= 1;
                 System.out.print(minesLeft);
             }
        }
        for(int x = 0;x < statM.length;x++){
            for(int y = 0;y < statM[x].length;y++){
                if(statM[x][y] != true) {
                    statM[x][y] = false;
                }
            }
        }


    }
    public void checkWin(){
        for (int i = 0; i < mineArr.size(); i++) {
            if(mineArr.get(i).isFlagged() == false){
                return;
            }
        }

    }
    public boolean check(int x,int y){
        try{
            return statM[x][y];
        }catch(Exception e) {
            return false;
        }

    }
    public boolean checkZ(int x,int y){
        try{
            return grid[x][y].getNumber() == 0;
        }catch(Exception e) {
            return false;
        }

    }
    public void genNumber(){

        for (int x = 0; x < statN.length; x++) {
            for (int y = 0; y < statN[x].length; y++) {

                if (check(x,y) == true) {
                    statN[x][y] = 9;
                }if (check(x-1,y) == true) {
                    statN[x][y] += 1;
                }if (check(x+1,y) == true) {
                    statN[x][y] += 1;
                }if (check(x,y-1) == true) {
                    statN[x][y] += 1;
                }if (check(x,y+1) == true) {
                    statN[x][y] += 1;
                }if (check(x-1,y-1) == true) {
                    statN[x][y] += 1;
                }if (check(x-1,y+1) == true) {
                    statN[x][y] += 1;
                }if (check(x+1,y+1) == true) {
                    statN[x][y] += 1;
                }if (check(x+1,y-1) == true) {
                    statN[x][y] += 1;
                }

            }

        }
    }
    public int getNumber(int x, int y){
        return statN[x][y];
    }
    public boolean getMine(int x, int y){
        return statM[x][y];
    }


   public void deleteZeros(int x,int y){
       if(grid[x][y].getNumber() == 0) {
           try {
               if (!(grid[x + 1][y].getNumber() >= 9) && grid[x + 1][y].getButton().isVisible() ) {
                   grid[x + 1][y].showNum();

                   deleteZeros(x + 1, y);
               }
           } catch (Exception e) {
               System.out.println("not on grid");
           }
           try {
               if (!(grid[x - 1][y].getNumber() >= 9) && grid[x - 1][y].getButton().isVisible()) {
                   grid[x - 1][y].showNum();
                   deleteZeros(x - 1, y);
               }
           } catch (Exception e) {
               System.out.println("not on grid");
           }
           try {
               if (!(grid[x][y + 1].getNumber() >= 9) && grid[x][y + 1].getButton().isVisible()) {
                   grid[x][y + 1].showNum();
                   deleteZeros(x, y + 1);
               }
           } catch (Exception e) {
               System.out.println("not on grid");
           }
           try {
               if (!(grid[x][y - 1].getNumber() >= 9) && grid[x][y - 1].getButton().isVisible()) {
                   grid[x][y - 1].showNum();
                   deleteZeros(x, y - 1);
               }
           } catch (Exception e) {
               System.out.println("not on grid");
           }
           try {
               if (!(grid[x + 1][y + 1].getNumber() >= 9) && grid[x + 1][y + 1].getButton().isVisible()) {
                   grid[x + 1][y + 1].showNum();
                   deleteZeros(x + 1, y + 1);
               }
           } catch (Exception e) {
               System.out.println("not on grid");
           }
           try {
               if (!(grid[x + 1][y - 1].getNumber() >= 9) && grid[x + 1][y - 1].getButton().isVisible()) {
                   grid[x + 1][y - 1].showNum();
                   deleteZeros(x + 1, y - 1);
               }
           } catch (Exception e) {
               System.out.println("not on grid");
           }
           try {
               if (!(grid[x - 1][y + 1].getNumber() >= 9) && grid[x - 1][y + 1].getButton().isVisible()) {
                   grid[x - 1][y + 1].showNum();
                   deleteZeros(x - 1, y + 1);
               }
           } catch (Exception e) {
               System.out.println("not on grid");
           }
           try {
               if (!(grid[x - 1][y - 1].getNumber() >= 9) && grid[x - 1][y - 1].getButton().isVisible()) {
                   grid[x - 1][y - 1].showNum();
                   deleteZeros(x - 1, y - 1);
               }
           } catch (Exception e) {
               System.out.println("not on grid");
           }
       }



   }


public void lose(MineSpot s){
    if (s.toString().equals("*")){
        for(int x = 0;x < grid.length;x++){
            for(int y = 0;y < grid[x].length;y++){
                if(!(grid[x][y].getMine() == true)) {
                    grid[x][y].getButton().setVisible(false);
                    RunSweeper.lose.setVisible(true);

                }else{
                    grid[x][y].showNum();
                }
            }
        }
    }
}

}


