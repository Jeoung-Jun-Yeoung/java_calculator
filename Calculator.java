package mycalculator;

import java.util.*;

public class Calculator {

   //rst로 스트링이 아니라 스트링어레이로 넣어준다.
   
   //0으로 나눠야 하는상황이 생겼을때 num2가 0일경우. error발생 try catch를 한다. 
   
   private String[] postfix;
   private double calrst = 0;

   public Calculator(String[] result) {

      this.postfix = result;

      Stack<Double> calstack = new Stack<>();

      /*
       * 처음 생각한건 postfix식을 전부 스택에 집어넣고 pop하면서 계산해야겠다고 생각하고 코드를 짯는대 명세를 보니까 그냥 순서대로
       * 푸쉬하다가 operator를 만나면 2개 pop해서 계산하면됨. push하다가 operator를 만나면 팝해서 계산한다음에 다시 푸쉬.
       */

      for (int i = 0; postfix[i] != null ; i++) {
        double num2, num1, tmp;

         if (postfix[i].equals("+")) {

            num2 = calstack.pop(); // 두번째 숫자니까 num2로 표현
            num1 = calstack.pop();
            tmp = num1 + num2;
            calstack.push(tmp);
         }

         else if (postfix[i].equals("-")) {
            
            num2 = calstack.pop(); // 두번째 숫자니까 num2로 표현
             num1 = calstack.pop();
             tmp = num1 - num2;
             calstack.push(tmp);
         }

         else if (postfix[i].equals("*")) {

            num2 = calstack.pop(); // 두번째 숫자니까 num2로 표현
             num1 = calstack.pop();
             tmp = num1 * num2;
             calstack.push(tmp);
         }

         else if (postfix[i].equals("/")) {

            num2 = calstack.pop(); // 두번째 숫자니까 num2로 표현
             num1 = calstack.pop();
             tmp = num1 / num2;
             calstack.push(tmp);
         }

         else {
            calstack.push(Double.parseDouble(postfix[i]));
         }
         
      }
      calrst = calstack.pop();
      
   }

   public double calculate() {

      return this.calrst;
   }

}