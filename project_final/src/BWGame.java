
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;
 
class bluewhite_game extends JFrame{
	//û�� ��� ��ư
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
		setTitle("����� û�������");
		setSize(520,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pass_num.setText("���� �� : 0 ��");
		
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
			t1.setText("�����! û�� �÷�!");
			break;
		case 1 : 
			t1.setText("�����! û�� ����!");
			break;
		case 2 : 
			t1.setText("�����! ��� �÷�!");
			break;

		case 3 : 
			t1.setText("�����! ��� ����!");
			break;				
		}
	}
	public void pass() {
		t2.setText("����");
		pass++;
		pass_num.setText("���� �� : "+pass+" ��");
		game();
	}
	public void fail() {
		t2.setText("����");
		t1.setText("GAME OVER");
	}
	class MainPanel extends JPanel{ //��� ���
		ImageIcon main = new ImageIcon("img/img5.jpg");
		Image img = main.getImage();
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img,0, 165, this);
		}			
	}
 
	public class MyActionListener implements ActionListener{ // ��ư Ŭ�� �̺�Ʈ
		public void actionPerformed(ActionEvent e) {			
			JButton eventbt  = (JButton)e.getSource();
			
			switch(game){
			case 0 : 
				t1.setText("û�� �÷�!");
				if(e.getSource() == bt[0])
					pass();
				else{
					fail();
					return;
				}
				break;
			case 1 : 
				t1.setText("û�� ����!");
				if(e.getSource() == bt[1])
					pass();
				else{
					fail();
					return;
				}
				break;
 
			case 2 : 
				t1.setText("��� �÷�!");
				if(e.getSource() == bt[2])
					pass();
				else{
					fail();
					return;
				}
				break;
 
			case 3 : 
				t1.setText("��� ����!");
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
