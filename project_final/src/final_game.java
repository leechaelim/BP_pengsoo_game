import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class final_game extends JFrame{
	static int random;
	JButton button;
	JTextField t1;
	public String[] args;
	
	public final_game() {
		setSize(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("펭수의 랜덤게임");
		JPanel panel1=new JPanel();
		
		JLabel label=new JLabel("          랜덤 게임을 시작할까요??           ");
		button=new JButton("START");
		button.addActionListener(new MyListener());
		panel1.add(label);
		panel1.add(button);
		this.add(panel1);
		
		setVisible(true);
	}
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==button){
				random = (int)(Math.random()*4+1);
				if(random==1) {
					bluewhite_game b = new bluewhite_game();
				}
				if(random==2) {
					BingoGame g = new BingoGame();
					g.main(args);
				}
				if(random==3) {
					pacman p = new pacman();
					p.main(args);
				}
				if(random==4) {
					pengsoo1 s = new pengsoo1();
					s.main(args);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final_game start = new final_game();
		
	}

}
