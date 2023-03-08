import javax.swing.*;  
import java.awt.event.*;
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
    public static void Game(){
        int round=4;
        int[][] board=new int[5][6];
        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){
                board[x][y]=0;
            }
        }
    for(int r=0;r<round;r++){
        int x=(int) Math.round(Math.random()*5);
        int y=(int) Math.round(Math.random()*6);
        System.out.println(x);
        System.out.println(y);
        board[x][y]=r;
    }

        System.out.println(Arrays.deepToString(board));
    }
    public static void Window() {
        JFrame f=new JFrame("Tile Game");
        JButton start=new JButton("Start");
        start.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                Game();
            } 
        });
        start.setBounds(0,0,100,50);
        f.add(start);





        f.setSize(1000,500); 
        f.setLayout(null); 
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Window();
    }
}