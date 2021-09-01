
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;
 
class bluewhite_game extends JFrame{
	//청기 백기 버튼
	ImageIcon [] btimg = { new ImageIcon("img/i1.png"),
				    	new ImageIcon("img/i2.png"),
			            new ImageIcon("img/i3.png"),
			            new ImageIcon("img/i4.png") 
	};
	MainPanel mainpanel = new MainPanel();
	JButton[] bt = new JButton[4];
	JLabel pass_num = new JLabel();
	JTextField t1=new JTextField(50);
	JTextField t2=new JTextField(50);
	int pass=0;
	MyActionListener lis = new MyActionListener(); 
	int game = (int)(Math.random()*4);
	
	bluewhite_game(){
		setTitle("펭수의 청기백기게임");
		setSize(520,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pass_num.setText("정답 수 : 0 개");
		
		for(int i=0; i<bt.length; i++){ 
			bt[i] = new JButton(btimg[i]);
			
			bt[i].addActionListener(lis);
		}

		game();
		t2.setEditable(false);
		mainpanel.add(pass_num);
		mainpanel.add(t1);
		mainpanel.add(t2);
		mainpanel.add(bt[0]);
		mainpanel.add(bt[1]);
		mainpanel.add(bt[2]);
		mainpanel.add(bt[3]);
		
		add(mainpanel);
		setVisible(true);
	}
	
	public void game() {
		game = (int)(Math.random()*4);
		
		switch(game){
		case 0 : 
			t1.setText("펭수야! 청기 올려!");
			break;
		case 1 : 
			t1.setText("펭수야! 청기 내려!");
			break;
		case 2 : 
			t1.setText("펭수야! 백기 올려!");
			break;

		case 3 : 
			t1.setText("펭수야! 백기 내려!");
			break;				
		}
	}
	public void pass() {
		t2.setText("정답");
		pass++;
		pass_num.setText("정답 수 : "+pass+" 개");
		game();
	}
	public void fail() {
		t2.setText("오답");
		t1.setText("GAME OVER");
	}
	class MainPanel extends JPanel{ //펭수 배경
		ImageIcon main = new ImageIcon("img/img5.jpg");
		Image img = main.getImage();
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img,0, 165, this);
		}			
	}
 
	public class MyActionListener implements ActionListener{ // 버튼 클릭 이벤트
		public void actionPerformed(ActionEvent e) {			
			JButton eventbt  = (JButton)e.getSource();
			
			switch(game){
			case 0 : 
				t1.setText("청기 올려!");
				if(e.getSource() == bt[0])
					pass();
				else{
					fail();
					return;
				}
				break;
			case 1 : 
				t1.setText("청기 내려!");
				if(e.getSource() == bt[1])
					pass();
				else{
					fail();
					return;
				}
				break;
 
			case 2 : 
				t1.setText("백기 올려!");
				if(e.getSource() == bt[2])
					pass();
				else{
					fail();
					return;
				}
				break;
 
			case 3 : 
				t1.setText("백기 내려!");
				if(e.getSource() == bt[3])
					pass();
				else{
					fail();
					return;
				}		
				break;				
			}
		}		
	}
}

public class BWGame {
	public static void main(String[] args){
		bluewhite_game b = new bluewhite_game();
	}
}
