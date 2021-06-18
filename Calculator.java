package mycalculator;

import java.util.*;

public class Calculator {

   //rst�� ��Ʈ���� �ƴ϶� ��Ʈ����̷� �־��ش�.
   
   //0���� ������ �ϴ»�Ȳ�� �������� num2�� 0�ϰ��. error�߻� try catch�� �Ѵ�. 
   
   private String[] postfix;
   private double calrst = 0;

   public Calculator(String[] result) {

      this.postfix = result;

      Stack<Double> calstack = new Stack<>();

      /*
       * ó�� �����Ѱ� postfix���� ���� ���ÿ� ����ְ� pop�ϸ鼭 ����ؾ߰ڴٰ� �����ϰ� �ڵ带 ­�´� ���� ���ϱ� �׳� �������
       * Ǫ���ϴٰ� operator�� ������ 2�� pop�ؼ� ����ϸ��. push�ϴٰ� operator�� ������ ���ؼ� ����Ѵ����� �ٽ� Ǫ��.
       */

      for (int i = 0; postfix[i] != null ; i++) {
        double num2, num1, tmp;

         if (postfix[i].equals("+")) {

            num2 = calstack.pop(); // �ι�° ���ڴϱ� num2�� ǥ��
            num1 = calstack.pop();
            tmp = num1 + num2;
            calstack.push(tmp);
         }

         else if (postfix[i].equals("-")) {
            
            num2 = calstack.pop(); // �ι�° ���ڴϱ� num2�� ǥ��
             num1 = calstack.pop();
             tmp = num1 - num2;
             calstack.push(tmp);
         }

         else if (postfix[i].equals("*")) {

            num2 = calstack.pop(); // �ι�° ���ڴϱ� num2�� ǥ��
             num1 = calstack.pop();
             tmp = num1 * num2;
             calstack.push(tmp);
         }

         else if (postfix[i].equals("/")) {

            num2 = calstack.pop(); // �ι�° ���ڴϱ� num2�� ǥ��
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