package mycalculator;

import java.util.*;

public class InfixToPostfix {

   private String str;
   private String rst[] = new String[1000];

   public InfixToPostfix(String input) {

      this.str = input;

      String tmp = "";

      int count = 0;

      Stack<String> itp = new Stack<String>();

      itp.push("null");

      for (int i = 0; i < str.length(); i++) {

         if (str.charAt(i) == '(') {

            itp.push(Character.toString(str.charAt(i)));

            if (tmp != "") {

               rst[count] = tmp;
               count++;
               tmp = "";
            }

         }

         else if (str.charAt(i) != '+' && str.charAt(i) != '-' && str.charAt(i) != '/' && str.charAt(i) != '*'
               && str.charAt(i) != ')') {

            tmp += Character.toString(str.charAt(i));

         }

         else if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '*') {
            if (tmp != "") {
               rst[count] = tmp;
               count++;
               tmp = "";

            }

            /*
             * ���� �����ڰ� rst += tmp�ǰ� ������ push�Ǹ��
             * 
             * if. ���ÿ� ���������ڰ� �ְ� ���������ڰ� ���ö� �̶� �׳� ���ÿ� ���δ�. > ���ÿ� +�� �ְ� * �Ǵ� / �� ������ �׳�
             * ���δ�. > ���ÿ� -�� �ְ� * �Ǵ� / �� ������ �׳� ���δ�.
             * 
             * else if 2. ���ÿ� ���� �����ڰ� �ְ� ���� �����ڰ� ���ö�. �̶��� ���ÿ��� pop�� �ؼ� �ƿ�ǲ���ְ� ������ ���ÿ� Ǫ�� >
             * ���ÿ� * ���ְ� + �Ǵ� -�� ������ *�� ���ϰ� �ƿ�ǲ�� ����ϰ� + - �� Ǫ���Ѵ�. > ���ÿ� / ���ְ� + �Ǵ� -�� ������
             * /�� ���ϰ� �ƿ�ǲ�� ����ϰ� + - �� Ǫ���Ѵ�.
             * 
             * else �������������� �׳� Ǫ���Ѵ�.
             */

            while (true) {

               if (itp.size() == 1 || itp.peek().equals("(")) {
                  break;
               }

               else if ((str.charAt(i) == '*' || str.charAt(i) == '/')) {

                  if (itp.peek().equals("+") || itp.peek().equals("-")) {
                     break;
                  }

               }
               if (tmp != "") {
                  rst[count] = itp.pop();
                  count++;
               }

            }
            itp.push(Character.toString(str.charAt(i)));
         }

         else {
            if (tmp != "") {
               rst[count] = tmp;
               count++;
               tmp = "";
            }

            while (itp.isEmpty() != true) {

               String tmp2 = itp.pop();
               if (tmp2.equals("(")) {
                  break;
               }
               rst[count] = tmp2;
               count++;

            }

         }
      }

      if (tmp != "") {
          rst[count] = tmp;
          count++;
          tmp = "";
       }

      while (itp.size() != 1)

      {

         rst[count] = itp.pop();
         count++;

      }

   }

   public String[] getresult() {
      return this.rst;
   }

}