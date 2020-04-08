import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Project made by Adam Smith


public class RunSweeper extends JFrame  {

    public static JLabel lose;
    public static JLabel win;
    public static JButton start;

    RunSweeper(){
       createGUI();

    }

    public MineGrid ms= new MineGrid(15);
    public ActionListener mineClicked = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
            for(int x = 0;x < ms.grid.length;x++) {
                for (int y = 0; y < ms.grid[x].length; y++) {
                    if (ms.grid[x][y].getButton() == clicked) {
                        ms.grid[x][y].showNum();
                       // ms.grid[x][y].whenClicked();
                        ms.deleteZeros(x,y);
                        ms.lose(ms.grid[x][y]);
                        checkWin();
                    }
                }
            }
        }
    };
    public ActionListener startE = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            ms.fillGrid();
            remove(start);
            for(int x = 0;x < ms.grid.length;x++){
                for(int y = 0;y < ms.grid[x].length;y++){
                    ms.grid[x][y].getButton().addActionListener(mineClicked);
                    int finalY = y;
                    int finalX = x;
                    ms.grid[x][y].getButton().addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                            if (SwingUtilities.isRightMouseButton(e)){
                                if(ms.grid[finalX][finalY].isFlagged() == false){
                                    ms.grid[finalX][finalY].setFlagged(true);
                                }else {
                                    ms.grid[finalX][finalY].setFlagged(false);
                                }
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                    ms.grid[x][y].getButton().setBounds((x*50)+250,(y*50)+100,50,50);
                    ms.grid[x][y].getButton().setFont(new Font("Comic Sans MS", Font.BOLD, 20));
                    add(ms.grid[x][y].getButton());

                }
            }
            //revalidate();
            repaint();


        }


    };
    public void checkWin(){
        if(MineSpot.getWin() == 0 && MineGrid.lose == false){
            win.setVisible(true);
            MineGrid.win = true;

        }
    }
    private void createGUI(){

        start = new JButton("Start");
         lose = new JLabel("You Lost");
        lose.setBounds(450,50,200,50);
        lose.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(lose);
        lose.setVisible(false);
        win = new JLabel("You Win");
        win.setBounds(450,50,200,50);
        win.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        add(win);
        win.setVisible(false);
        start.setBounds(0,600,100,100);
        start.addActionListener(startE);
        add(start);
        setSize(1000,750);
        setTitle("MineSweeper");
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        setVisible(true);
    }


    public static void main(String[] args) {


        new RunSweeper();


    }
}

/**/