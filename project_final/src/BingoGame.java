

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class BingoGame {
			static JPanel panelNorth; //Top view
		   static JPanel panelCenter; //Game View
		   static JLabel labelMessage;
		   static JButton[] buttons = new JButton[16];
		   static String[] images = {
		         "cardpengsu/su01.png", "cardpengsu/su02.png", "cardpengsu/su03.png", "cardpengsu/su04.png",
		         "cardpengsu/su05.png", "cardpengsu/su06.png", "cardpengsu/su07.PNG", "cardpengsu/su08.PNG",
		         "cardpengsu/su01.png", "cardpengsu/su02.png", "cardpengsu/su03.png", "cardpengsu/su04.png",
		         "cardpengsu/su05.png", "cardpengsu/su06.png", "cardpengsu/su07.PNG", "cardpengsu/su08.PNG",
		   };
		   static int openCount = 0;  //Opened Card Count; 0, 1, 2
		   static int buttonIndexSave1 = 0; //First opened card index: 0-15
		   static int buttonIndexSave2 = 0; //Second opened card index: 0-15
		   static Timer timer; 
		   static int tryCount = 0; //Try Count
		   static int successCount = 0; //Bingo Count: 0-8
   static class MyFrame extends JFrame implements ActionListener {
      public MyFrame(String title) {
         super(title);
         this.setLayout(new BorderLayout());
         this.setSize(400,500);
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         initUI(this); //Screen UI Set.
         mixCard(); //Mix PengSoo Card
         
         this.pack(); //Pack Empty Space.
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
         
         if(openCount ==2 ) {
            return;
         }
         
         JButton btn = (JButton)e.getSource();
         int index = getButtonIndex( btn );
         btn.setIcon(changeImage(images[index]));
         
         openCount++;
         if(openCount == 1 ) { //first card?
            buttonIndexSave1 = index;
         }
         else if(openCount == 2) { //Second card?
            buttonIndexSave2 = index;
            tryCount++;
            labelMessage.setText("Find same PengSoo!" + " Try"+ tryCount);
            
            //Judge Logic
            boolean isBingo = checkCard(buttonIndexSave1, buttonIndexSave2);
            if(isBingo == true) {
               openCount = 0;
               successCount++;
               if(successCount == 8) {
                  labelMessage.setText("Game Over" + "Try " + tryCount);                  
               }
            }else {
               backToQuestion();
            }
         }
      }
      
      public void backToQuestion() {
         //Time 1Sec later
         timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("Timer.");
               
               openCount = 0;
               buttons[buttonIndexSave1].setIcon( changeImage("cardpengsu/question.png"));
               buttons[buttonIndexSave2].setIcon( changeImage("cardpengsu/question.png"));
               timer.stop();
            }
            
         });
         timer.start();
      }
      
      public boolean checkCard(int index1, int index2) {
         if(index1 == index2) {
            return false;
         }
         if(images[index1].equals(images[index2])) {
            return true;
         }else {
            return false;
         }
      }
      
      public int getButtonIndex(JButton btn) {
         int index = 0;
         for(int i = 0; i<16; i++) {
            if(buttons[i] == btn) {//same instance?
               index = i;
            }
         }
         return index;
      }
   }
   
   static void mixCard() {
      Random rand = new Random();
      for(int i=0; i<1000; i++) {
         int random = rand.nextInt(15)+1; //1~15
         //swap
         String temp = images[0];
         images[0] = images[random];
         images[random] = temp;
      }
   }
   
   static void initUI(MyFrame myFrame) {
      panelNorth = new JPanel();
      panelNorth.setPreferredSize(new Dimension(400,100));
      panelNorth.setBackground(Color.BLUE);
      labelMessage = new JLabel("Find same PengSoo!" + " Try 0");
      labelMessage.setPreferredSize(new Dimension(400,100));
      labelMessage.setForeground(Color.WHITE);
      labelMessage.setFont(new Font("Monaco", Font.BOLD, 20));
      labelMessage.setHorizontalAlignment(JLabel.CENTER);
      panelNorth.add(labelMessage);
      myFrame.add("North", panelNorth);
      
      panelCenter = new JPanel();
      panelCenter.setLayout(new GridLayout(4,4));
      panelCenter.setPreferredSize(new Dimension(400,400));
      for(int i=0; i<16; i++) {
         buttons[i] = new JButton();
         buttons[i].setPreferredSize(new Dimension(100,100));
         buttons[i].setIcon(changeImage("cardpengsu/question.png"));
         buttons[i].addActionListener(myFrame);
         panelCenter.add(buttons[i]);
      }
      myFrame.add("Center",panelCenter);
   
   }
   
   static ImageIcon changeImage(String filename) {
      ImageIcon icon = new ImageIcon( filename);
      Image originImage = icon.getImage();
      Image changedImage = originImage.getScaledInstance(95, 95, Image.SCALE_SMOOTH);
      ImageIcon icon_new = new ImageIcon(changedImage);
      return icon_new;
   }
   
   public static void main(String[] args) {
      new MyFrame("Bingo Game");
	  

   }

}