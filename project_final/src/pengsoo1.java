


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class pengsoo1{
    public static void main(String[] args){
            Frame frame = new Frame();
            pengsoo b = new pengsoo();
    }
}

class Frame extends JFrame{
	View mView;
    public Frame(){
             mView = new View();
             add(mView);
             setTitle("Game");
             setSize(600, 600);
             setVisible(true);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 class View extends JPanel
			implements MouseListener, ActionListener{
			final int WIDTH_COUNT;
			final int HEIGHT_COUNT;

			int[][] mData;
			int mStartNumber;
			int mNextNumber;

			Random mRandom = new Random();


Timer mTimer = new Timer(1000, this);
int mTime = 30;

@Override
public void actionPerformed(ActionEvent arg0) {
	if(mTimer == arg0.getSource())
	{
		mTime--;
		if(mTime <= 0)
		{
			mTimer.stop();
			JOptionPane.showMessageDialog(this, "GameOver", "info", JOptionPane.INFORMATION_MESSAGE);
		}
		repaint();
	}
}

public void mixNumber(int count)
{
	int p1 = 0;
	int p2 = 0;
	for(int i=0; i<count; i++)
	{
		int dir = mRandom.nextInt(4);
		
		switch(dir)
		{
		case 0:
			if(checkMove(p1, p2, p1-1, p2))
			{
				p1--;
			}
			break;
		case 1:
			if(checkMove(p1, p2, p1+1, p2))
			{
				p1++;
			}
			break;
		case 2:
			if(checkMove(p1, p2, p1, p2-1))
			{
				p2--;
			}
			break;
		case 3:
			if(checkMove(p2, p2, p2, p2+1))
			{
				p2++;
			}
			break;
			default:
				break;
		}
	}
}

@Override
public void paint(Graphics g) {
	//paintComponent(g);
	super.paint(g);
	
	drawMap(g);
	drawNumber(g);	
	String msg = "time: " + mTime;
	g.setFont(g.getFont().deriveFont(15.0f));
	g.drawString(msg, 510, 20);
}

public boolean checkMove(int a, int b, int c, int d){
	if(a < 0 || b < 0 || c < 0 || d < 0){
		return false;
	}
	if(WIDTH_COUNT <= a || HEIGHT_COUNT <= b || WIDTH_COUNT <= c || HEIGHT_COUNT <= d){
		return false;
	}
	
	int tmp = mData[d][c];
	
	mData[d][c] = mData[b][a];
	mData[b][a] = tmp;
	
	return true;
}

public View(){
	WIDTH_COUNT = 5;
	HEIGHT_COUNT = 5;
	
	mData = new int[HEIGHT_COUNT][WIDTH_COUNT];

	mStartNumber = 1;
	mNextNumber = 1;
	for(int y=0; y<HEIGHT_COUNT; y++){
		for(int x=0; x<WIDTH_COUNT; x++){
			mData[y][x] = mNextNumber;
			mNextNumber++;
		}
	}
	
	mixNumber(1000);
	addMouseListener(this);
	mTimer.start();
}
public void drawNumber(Graphics g){
	int xpos;
	int ypos;
	for(int y=0; y<HEIGHT_COUNT; y++){
		for(int x=0; x<WIDTH_COUNT; x++){
			xpos = x * 100 + 40;
			ypos = y * 100 + 60;
			String msg = "" + mData[y][x];
			g.setFont(g.getFont().deriveFont(30.0f));
			g.drawString(msg, xpos, ypos);
		}
	}
}
public void drawMap(Graphics g){
	int xpos, ypos;
	for(int y=0; y<HEIGHT_COUNT; y++){
		for(int x=0; x<WIDTH_COUNT; x++){
			xpos = x * 100;
			ypos = y * 100;
			g.drawRect(xpos, ypos, 100, 100);
		}
	}
}
public void ClickNumber(int x, int y){
	if(mData[y][x] == mStartNumber){
		if(mData[y][x]==30) {
			mTimer.stop();
			JOptionPane.showMessageDialog(this, "¼º°ø", "info", JOptionPane.INFORMATION_MESSAGE);
		}
			
		if(mNextNumber<=30) {
			mData[y][x] = mNextNumber;
			mNextNumber++;
		}else {
			mData[y][x] =0;
		}
		
		mStartNumber++;
	
		repaint();
	}
}
@Override
public void mouseClicked(MouseEvent arg0){	
}
@Override
public void mouseEntered(MouseEvent arg0){
}
@Override
public void mouseExited(MouseEvent arg0){	
}
@Override
public void mousePressed(MouseEvent e){
	for(int y=0; y<HEIGHT_COUNT; y++){
		for(int x=0; x<WIDTH_COUNT; x++){
			Rectangle r = new Rectangle(x*100, y*100, 100, 100);
			if(r.contains(e.getX(), e.getY())){
				ClickNumber(x, y);
			}
		}
	}
}

@Override
public void mouseReleased(MouseEvent e) {
	
}
}

public void mouseReleased(MouseEvent arg0){
}
}

class pengsoo extends JFrame{
    JFrame f = new JFrame();
      JPanel panel = new JPanel();
      MainPanel main = new MainPanel();
      class MainPanel extends JPanel{
         ImageIcon image = new ImageIcon("img/jump.png");
         Image img = image.getImage();
          public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,40, this);
         }
      }  
      public pengsoo(){   
      
      setTitle("Æë¼ö");
       setSize(600,450);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       JPanel panel1=new JPanel();
       JLabel l1= new JLabel("Æë¼ö ¼ýÀÚ´©¸£±â °ÔÀÓ");
       l1.setFont(new Font("³ª´®°íµñ", Font.BOLD,17));
       main.add(l1);
       
       this.add(main); 
       add(main);
      
     
      
      
      setVisible(true);
      }
}

