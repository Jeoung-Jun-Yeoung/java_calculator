package mycalculator;

import java.util.*;

public class ErrorCheck {

   private static boolean b_val;
   private static String cmp;
   private char array[] = new char[1000];
   private static int errornum;

   public ErrorCheck(String input) {

      this.cmp = input;

      b_val = false;

      if (nullCheck() && sizeCheck() && asciiCheck() && balancedCheck() && InfixCheck()) {
         b_val = true;
      }
   }

   public static boolean nullCheck() {
      if (cmp.length() == 0) {
         errornum = 4;
         return false;
      }
      return true;
   }

   public static boolean sizeCheck() {
      if (cmp.length() > 1000) {
         errornum = 0;
         return false;

      }
      return true;
   }

   public static boolean asciiCheck() {
      for (int i = 0; i < cmp.length(); i++) {

         int check = (int) cmp.charAt(i);

         if (40 <= check && check <= 57) {
            if (check == 44) {
               errornum = 1;
               return false;
            }

         }

         else {
            errornum = 1;
            return false;
         }

      }
      return true;
   }

   public static boolean balancedCheck() {
      final char left = '(';
      final char right = ')';

      Stack<Character> bal = new Stack();

      for (int i = 0; i < cmp.length(); i++) {

         if (cmp.charAt(i) == left) {
            bal.push(cmp.charAt(i));
         } else if (cmp.charAt(i) == right) {
            if (bal.isEmpty()) { // << 스택이 비어있는데 right가면 false ((()숫자가 안맞을때
               errornum = 2;
               return false;

            }

            bal.pop();

         }
      }

      if (bal.isEmpty() == false) {

         errornum = 2;
         return false;
      }
      return true;
   }

   public static boolean InfixCheck() {

      int condition = 1;
      if (cmp.charAt(0) == '+' || cmp.charAt(0) == '-' || cmp.charAt(0) == '*' || cmp.charAt(0) == '/' || cmp.charAt(0) == '.') {
         errornum = 3;
         return false;
      }

      for (int i = 1; i < cmp.length(); i++) {

         if (condition == 0) {
            if (cmp.charAt(i) == '+' || cmp.charAt(i) == '-' || cmp.charAt(i) == '*' || cmp.charAt(i) == '/' || cmp.charAt(i) == '.') {

               errornum = 3;
               return false;
            }

            else {

               condition = 1;

            }

         }

         else {

            if (cmp.charAt(i) == '+' || cmp.charAt(i) == '-' || cmp.charAt(i) == '*' || cmp.charAt(i) == '/' || cmp.charAt(i) == '.') {
               condition = 0;

            }
         }
      }
      if (condition == 0) {
         errornum = 3;
         return false;
      }
      return true;
   }

   public boolean right() {

      return b_val;

   }

   public int errorType() {
      return errornum;
   }

}