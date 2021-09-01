
import java.util.Arrays;
import java.util.Scanner;

public class lotto_game_excercise_2 {
   static int sort(int a[],int b) {
      int index=0;
      for(int i=0; i<6;i++) {
         if(a[b]>a[i])
            index++;   
      }
      return index;   
   }
   static int sort(int a[][],int b, int c) {
      int index=0;
      for(int i=0; i<6;i++) {
         if(a[b][c]>a[b][i])
            index++;   
      }
      return index;   
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner scanner = new Scanner(System.in);
      System.out.print("!!LOTTO GAME!!\n금액을 입력해주세요 : ");
      int input_money = scanner.nextInt();
      System.out.print("원하시는 게임 수를 입력해주세요 : ");
      int playtime = scanner.nextInt();
      boolean start_game=false;
      do {
      if(input_money>playtime*1000) {
         int output_money=input_money-playtime*1000;
         System.out.println("거스름돈 "+output_money+"원을 받으세요.");
         start_game=true;
      }else if(input_money<playtime*1000) {
         int extra_money=playtime*1000-input_money;
         System.out.print("금액이 부족합니다. "+extra_money+"원을 더 넣어주세요.>>");
         input_money = input_money+scanner.nextInt();
      }else {
         start_game=true;
      }

      }while(start_game==false);
         
      System.out.print("게임을 시작합니다.\n원하시는 수동 게임의 숫자를 입력해주세요.>>");
      int hand_operated_num = scanner.nextInt();
      while(hand_operated_num>playtime){
         System.out.print("가능한 게임 수보다 많습니다. 다시 입력해주세요.\\n원하시는 수동 게임의 숫자를 입력해주세요.>>");
         hand_operated_num = scanner.nextInt();
      }
      
      int [][] lottoNumberArray = new int[playtime][6];
      boolean scanOK=true;
      
      for(int i =0; i<hand_operated_num;i++) {
         System.out.print((i+1)+"번째 게임 : 6개의 번호를 수동으로 입력해주세요. 예시) 2 7 13 30 31 43\n>>");
         for(int q=0;q<6;q++) 
            lottoNumberArray[i][q]=scanner.nextInt();
         
         for(int k=0;k<6;k++) {
            if((lottoNumberArray[i][k]<=0)||(lottoNumberArray[i][k]>45))
               scanOK=false;
         
            for(int j=0;j<k;j++) {
               if(lottoNumberArray[i][j]==lottoNumberArray[i][k]) 
                  scanOK=false;
            }
         }
         
         if(scanOK==false) {
               System.out.println("잘못입력하였습니다. 재입력을 시작합니다.");
               i--; scanOK=true;
         }
      }
      
      //자동 추출   
      for(int i =hand_operated_num; i<playtime;i++) {
         for(int k=0;k<6;k++) {
            lottoNumberArray[i][k]=(int)(Math.random()*45)+1;
            for(int j=0;j<k;j++) {
               if(lottoNumberArray[i][k]==lottoNumberArray[i][j])
                  i--;
            }
         }
      }   
      
      
      int anw[]=new int[6];
      for(int i=0; i<6;i++) {
         anw[i]=(int)(Math.random()*45)+1;
         for(int j=0;j<i;j++) {
            if(anw[i]==anw[j])
            i--;
         }
      }
      
      for(int i=0;i<playtime;i++)
         Arrays.sort(lottoNumberArray[i]);
      Arrays.sort(anw);
      
      System.out.println("\t\t\t- LOTTO -\n");
      System.out.print("이번주 당첨 번호 : ");
      for(int i=0; i<6;i++)
         System.out.print("\t"+anw[i]);
      
      System.out.println("\n\n");
      for(int i =0; i<playtime;i++) {
         for(int k=0;k<6;k++) {
            System.out.print("\t"+lottoNumberArray[i][k]);
         }
         System.out.println("");
      }
      scanner.close();
   }
}  