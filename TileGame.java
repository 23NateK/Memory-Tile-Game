import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
public class TileGame{
    public static int correctNum=1;
    public static JFrame f;
    public static JFrame f2;
    public static JFrame f3;
    public static JFrame f4;
    public static JFrame f5;
    public static int round=4;
    public static int[][] board;
    public static JFrame Game(JFrame f){
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
                f.add(a);
            }else{
                JButton a=new JButton(Integer.toString(board[x][y]));
                a.setBackground(Color.WHITE);
                f.add(a);
                if(a.getText().equals("1")){
                    a.addActionListener(new ActionListener() { 
                        public void actionPerformed(ActionEvent e) { 
                            check(a);
                            buttonClearer(board);
    
                } 
            });

                }else{
                a.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) { 
                        check(a);

            } 
        });
            }
        }
        }
    
    }
    return f;
    }
    public static void Window() {
        f=new JFrame("Tile Game");
        JButton start=new JButton("Start");
        start.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                f=Game(f);
                f.remove(start);
                f.setVisible(true);
            } 
        });
        start.setBounds(0,0,100,50);
        f.add(start);





        f.setSize(1000,500); 
        f.setLayout(new GridLayout(5,6));
        f.setVisible(true);
    }
    public static void check(JButton a){
        if(a.getText().equals(Integer.toString(correctNum))){
            correctNum++;
            if(correctNum==round){
                f4=new JFrame("Tile Game");
                f.setVisible(false);
                f4.setVisible(false);
                f4.setSize(1000,500); 
                f4.setLayout(new GridLayout(5,6));
                f4.setVisible(true);
                f=Game(f4);
                f.setVisible(true);
                correctNum=1;

            }
        }else if(!a.getText().equals(Integer.toString(correctNum))){
            f.setVisible(false);
            f5.setVisible(false);
            JFrame f3=new JFrame("Tile Game");
            JLabel failed=new JLabel("Failed");
            failed.setHorizontalAlignment(JLabel.CENTER);
            failed.setVerticalAlignment(JLabel.CENTER);
            JButton restart=new JButton("Restart?");
            restart.setBounds(0,0,100,50);
            restart.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                    Window();
                    correctNum=1;
                    f3.setVisible(false);
                    round=4;
                } 
            });
            f3.add(restart);
            f3.setSize(1000,500); 
            f3.add(failed);
            f3.setVisible(true);
            
        }
    }
    public static void buttonClearer(int[][] board){
        f5=new JFrame("Tile Game");
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                if(board[x][y]==0){
                    
                    JButton a=new JButton("");
                    a.setBackground(Color.GRAY);
                    f5.add(a);
                }else{
                    JButton a=new JButton("");
                    a.setBackground(Color.WHITE);
                    f5.add(a);
                    a.addActionListener(new ActionListener() { 
                        public void actionPerformed(ActionEvent e) { 
                            check(a);
    
                } 
            });
                }
            }
        
        }
        f5.setSize(1000,500);
        f5.setLayout(new GridLayout(5,6));
        f5.setVisible(true);
        f.setVisible(false);
    }

    public static void main(String[] args) {
        Window();
       
    }
}