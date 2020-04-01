import javax.swing.*;

    public class MineSpot {
    private JButton spot;
    private int num;
    private boolean mine;

    public MineSpot(int n,boolean m){
        num = n;
        mine = m;
        spot = new JButton("");
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
