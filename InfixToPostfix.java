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
             * 높은 연산자가 rst += tmp되고 낮은게 push되면됨
             * 
             * if. 스택에 낮은연산자가 있고 높은연산자가 들어올때 이때 그냥 스택에 쌓인다. > 스택에 +가 있고 * 또는 / 가 들어오면 그냥
             * 쌓인다. > 스택에 -가 있고 * 또는 / 가 들어오면 그냥 쌓인다.
             * 
             * else if 2. 스택에 높은 연산자가 있고 낮은 연산자가 들어올때. 이때는 스택에서 pop을 해서 아웃풋에넣고 낮은걸 스택에 푸쉬 >
             * 스택에 * 가있고 + 또는 -가 들어오면 *를 팝하고 아웃풋에 출력하고 + - 를 푸쉬한다. > 스택에 / 가있고 + 또는 -가 들어오면
             * /를 팝하고 아웃풋에 출력하고 + - 를 푸쉬한다.
             * 
             * else 같은순위끼리는 그냥 푸쉬한다.
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