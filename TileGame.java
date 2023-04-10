import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
public class TileGame{
    public static int correctNum=1;
    public static JFrame f;
    public static JPanel p;
    public static int round=4;
    public static int[][] board;
    public static JFrame Game(JPanel p){
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
        p=new JPanel();
        p.setSize(1000, 500);
        f.add(p);
        JButton start=new JButton("Start");
        start.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                Game(p);
                p.remove(start);
                f.setVisible(true);
            } 
        });
        start.setBounds(0,0,100,50);
        p.add(start);





        f.setSize(1000,500); 
        f.setLayout(new GridLayout(5,6));
        f.setVisible(true);
    }
    public static void check(JButton a){
        if(a.getText().equals(Integer.toString(correctNum))){
            correctNum++;
            if(correctNum==round){
                p.setVisible(false);
                p.setSize(1000,500); 
                p.setLayout(new GridLayout(5,6));
                p.setVisible(true);
                Game(p);
                correctNum=1;

            }
        }else if(!a.getText().equals(Integer.toString(correctNum))){
            p.setVisible(false);
            JLabel failed=new JLabel("Failed");
            failed.setHorizontalAlignment(JLabel.CENTER);
            failed.setVerticalAlignment(JLabel.CENTER);
            JButton restart=new JButton("Restart?");
            restart.setBounds(0,0,100,50);
            restart.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent e) { 
                    Window();
                    correctNum=1;
                    p.setVisible(false);
                    round=4;
                } 
            });
            p.add(restart);
            p.setSize(1000,500); 
            p.add(failed);
            p.setVisible(true);
            
        }
    }
    public static void buttonClearer(int[][] board){
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
                            check(a);
    
                } 
            });
                }
            }
        
        }
        f.setSize(1000,500);
        p.setLayout(new GridLayout(5,6));
        p.setVisible(true);
    }

    public static void main(String[] args) {
        Window();
       
    }
}