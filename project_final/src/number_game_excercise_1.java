import java.util.*;
public class number_game_excercise_1 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      System.out.println("<<���� ���߱� ����>>\n");
      
      int input = 0;
      int answer = 0;
      
      answer = (int)(Math.random()*50)+1;
      
      Scanner scanner = new Scanner(System.in);
      
      int count = 0;
      
      do {
         System.out.print("1�� 50 ������ ������ �Է��ϼ���. ������ �õ� Ƚ�� "+(5-count)+"ȸ >>");
         input = scanner.nextInt();
         count++;
         if(input > answer && count <= 5) {
            System.out.println("�� ���� ���� �ٽ� �õ��غ�����.\n");
         }
         else if(input < answer && count <= 5) {
            System.out.println("�� ū ���� �ٽ� �õ��غ�����.\n");
         }
         else if(input == answer) {
            System.out.println("\n�����Դϴ�!");
            System.out.println("�õ�Ƚ�� : "+count);
            break;
         }
      }while(count<5);
      
      scanner.close();
      
      if(input != answer) {
         System.out.println("\n������ "+answer+" �����ϴ�.");
         System.out.println("�� �õ� Ƚ�� : " + count);
      }
   }
}
