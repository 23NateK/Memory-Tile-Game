import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
public class TileGame{
    public static int correctNum=1;
    public static JFrame f;
    public static JPanel p;
    public static int round=4;
    public static int[][] board;
    public static void Game(JPanel p){
        p.setVisible(false);
        p.validate();
        board=new int[5][6];
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                board[x][y]=0;
            }
        }
    for(int r=1;r<=round;r++){
        int x=(int) Math.round(Math.random()*4);
        int y=(int) Math.round(Math.random()*5);
        while(board[x][y]!=0){
            x=(int) Math.round(Math.random()*4);
            y=(int) Math.round(Math.random()*5);
        }
        board[x][y]=r;
    }
    round++;
    for(int x=0;x<board.length;x++){
        for(int y=0;y<board[0].length;y++){
            if(board[x][y]==0){
                
                JButton a=new JButton("");
                a.setBackground(Color.GRAY);
                p.add(a);
            }else{
                JButton a=new JButton(Integer.toString(board[x][y]));
                a.setBackground(Color.WHITE);
                p.add(a);
                if(a.getText().equals("1")){
                    a.addActionListener(new ActionListener() { 
                        public void actionPerformed(ActionEvent e) { 
                            check(Integer.parseInt(a.getText()));
                            buttonClearer(board);
    
                } 
            });

                }else{
                a.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) { 
                        check(Integer.parseInt(a.getText()));

            } 
        });
            }
        }
        }
    
    }
    p.setVisible(true);
    }
    public static void Window() {
        f=new JFrame("Tile Game");
        p=new JPanel();
        p.setSize(1000, 500);
        f.setSize(1000, 500);
        f.add(p);
        JButton start=new JButton("Start");
        start.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                Game(p);
                p.remove(start);
            } 
        });
        start.setBounds(0,0,100,50);
        p.add(start);





        p.setLayout(new GridLayout(5,6));
        f.setVisible(true);
    }
    public static void check(int num){
        if(num==correctNum){
            correctNum++;
            if(correctNum==round){
                p.setVisible(false);
                p.removeAll();
                p.validate();
                p.setSize(1000,500); 
                p.setLayout(new GridLayout(5,6));
                p.setVisible(true);
                Game(p);
                correctNum=1;

            }
        }else if(num!=correctNum){
            p.setVisible(false);
            p.removeAll();
            p.validate();
            JLabel failed=new JLabel("Failed");
            failed.setHorizontalAlignment(JLabel.CENTER);
            failed.setVerticalAlignment(JLabel.CENTER);
            JButton restart=new JButton("Restart?");
            restart.setBounds(0,0,100,50);
            restart.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                    f.setVisible(false);
                    Window();
                    correctNum=1;
                    round=4;
                } 
            });
            p.setSize(1000,500); 
            p.add(failed);
            p.add(restart);
            p.setVisible(true);
            
        }
    }
    public static void buttonClearer(int[][] board){
        p.setVisible(false);
        p.removeAll();
        p.validate();
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                if(board[x][y]==0){
                    
                    JButton a=new JButton("");
                    a.setBackground(Color.GRAY);
                    p.add(a);
                }else{
                    JButton a=new JButton("");
                    a.setBackground(Color.WHITE);
                    p.add(a);
                    a.addActionListener(new ActionListener() { 
                        public void actionPerformed(ActionEvent e) { 
                            check(buttonLocate(a));
    
                } 
            });
                }
            }
        
        }
        f.setSize(1000,500);
        p.setSize(1000,500);
        p.setLayout(new GridLayout(5,6));
        p.setVisible(true);
    }

    public static int buttonLocate(JButton a){
        int x=-1;
        int y=-1;
        int bx=a.getX();
        int by=a.getY();
        if(bx==0){x=0;}else if(bx==164){x=1;}else if(bx==328){x=2;}else if(bx==492){x=3;}else if(bx==656){x=4;}else if(bx==820){x=5;}
        if(by==0){y=0;}else if(by==92){y=1;}else if(by==184){y=2;}else if(by==276){y=3;}else if(by==368){y=4;}
        int value=board[x][y];
        return value;
    }
    // 0  164 328 492 656 820
    // 1   2   3   4   5   6
    //0
    //92
    //184
    //276
    //368
    
    public static void main(String[] args) {
        Window();
       
    }
}