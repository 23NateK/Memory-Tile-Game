import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
import java.util.Arrays;
public class TileGame{
    public static void Example() {  
        JFrame f=new JFrame();//creating instance of JFrame  
                
        JButton b=new JButton("click");//creating instance of JButton  
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
                
        f.add(b);//adding button in JFrame  
                
        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  
    } 
    public static int correctNum=1;
    public static JFrame f2;
    public static JFrame Game(JFrame f){
        int round=4;
        int[][] board=new int[5][6];
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
                a.addActionListener(new ActionListener() { 
                    public void actionPerformed(ActionEvent e) { 
                        check(a);

            } 
        });
            }
        }
    
    }
    return f;
    }
    public static void Window() {
        JFrame f=new JFrame("Tile Game");
        JButton start=new JButton("Start");
        start.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                f2=Game(f);
                f2.remove(start);
                f2.setVisible(true);
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
        }else if(!a.getText().equals(Integer.toString(correctNum))){
            f2.setVisible(false);
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
                } 
            });
            f3.add(restart);
            f3.setSize(1000,500); 
            f3.add(failed);
            f3.setVisible(true);
            
        }
    }

    public static void main(String[] args) {
        Window();
       
    }
}