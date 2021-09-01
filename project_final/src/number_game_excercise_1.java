import java.util.*;
public class number_game_excercise_1 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      System.out.println("<<숫자 맞추기 게임>>\n");
      
      int input = 0;
      int answer = 0;
      
      answer = (int)(Math.random()*50)+1;
      
      Scanner scanner = new Scanner(System.in);
      
      int count = 0;
      
      do {
         System.out.print("1과 50 사이의 정수를 입력하세요. 가능한 시도 횟수 "+(5-count)+"회 >>");
         input = scanner.nextInt();
         count++;
         if(input > answer && count <= 5) {
            System.out.println("더 작은 수로 다시 시도해보세요.\n");
         }
         else if(input < answer && count <= 5) {
            System.out.println("더 큰 수로 다시 시도해보세요.\n");
         }
         else if(input == answer) {
            System.out.println("\n정답입니다!");
            System.out.println("시도횟수 : "+count);
            break;
         }
      }while(count<5);
      
      scanner.close();
      
      if(input != answer) {
         System.out.println("\n정답은 "+answer+" 였습니다.");
         System.out.println("총 시도 횟수 : " + count);
      }
   }
}
