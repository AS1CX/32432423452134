import javax.swing.*;
import java.awt.*;

public class MineSpot {
    private JButton spot;
    private int num;
    private boolean mine;
    private boolean flagged;
    private boolean shown;
    public static int win = 100-MineGrid.mines;

    public MineSpot(int n,boolean m){
        num = n;
        mine = m;
        spot = new JButton("");
        flagged = false;
        shown = false;
    }
    public void showNum(){
        if (num >= 9){
            spot.setText("*");
        }else if(num == 0) {
            spot.setText("");
            spot.setVisible(false);
        }else{
            if(num == 1){
                spot.setForeground(Color.BLUE);
            }
            if(num == 2){
                spot.setForeground(new Color(0,128,0));
            }
            if(num == 3){
                spot.setForeground(Color.RED);
            }
            if(num == 4){
                spot.setForeground(new Color(128,0,128));
            }
            if(num == 5){
                spot.setForeground(new Color(128,0,0));
            }
            if(num == 6){
                spot.setForeground(new Color(21, 132, 121));
            }
            if(num == 7){
                spot.setForeground(Color.BLACK);
            }
            if(num == 8){
                spot.setForeground(Color.DARK_GRAY);
            }
                spot.setText(String.valueOf(num));
            }
        if (shown == false){
            win -=1;
            System.out.println(win);
        }
        shown = true;


    }

    public JButton getButton(){
        return spot;
    }

        public void setFlagged(boolean flagged) {
            this.flagged = flagged;
            if(flagged == true){
                this.getButton().setBackground(Color.RED);
            }else{
                this.getButton().setBackground(null);
            }

        }
    public static int getWin(){
        return win;
    }

    public boolean isFlagged() {
            return flagged;
        }

        public int getNumber(){
            return num;
        }
    public String toString(){
        return spot.getText();
    }
    public boolean getMine(){
        return mine;
    }
}
