import javax.swing.*;
import java.awt.*;

public class MineSpot {
    private JButton spot;
    private int num;
    private boolean mine;
    private boolean flagged;

    public MineSpot(int n,boolean m){
        num = n;
        mine = m;
        spot = new JButton("");
        flagged = false;
    }
    public void showNum(){
        if (num >= 9){
            spot.setText("*");
        }else if(num == 0) {
            spot.setText("");
            spot.setVisible(false);
        }else{
                spot.setText(String.valueOf(num));
            }

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
