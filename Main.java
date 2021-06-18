package mycalculator;

import java.util.*;

public class Main {

	private static String[] errorArray = { "size가 1000을 초과했습니다.", "유효하지않은 기호나 문자가 입력되었습니다.", "알맞은 소괄호 표기가 아닙니다.",
			"표준 Infix 수식이 아닙니다.", "공백이 입력되었습니다." };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("=============== MyCalculator ================ ");
		System.out.println("MyCalculator를 사용을 환영합니다.");
		System.out.println("명세 1: 이 계산기는 양수에 대한 계산이 가능합니다.");
		System.out.println("명세 2: 숫자와 사칙연산을 포함한 갯수는 1000개 이하여야합니다.");
		System.out.println("명세 3: 숫자, (,),+,-,*,/를 제외한 기호를 받지 않습니다.");
		System.out.println("명세 4: 표준 Infix식에 어긋난 산수식은 받지 않습니다.");
		System.out.println("명세 5: 공백은 허용합니다.");
		System.out.println("명세 6: 사칙연산의 생략을 허용하지 않습니다. ex> 7(5+6) 허용하지 않습니다. ");
		System.out.println("명세 7: 계산값이 Infinity인 경우에는 나누는 값에 0이 있는 경우입니다.");
		System.out.println("=============================================== ");

		while (true) {

			System.out.println("Infix로 수식을 입력하시오.");

			String input = sc.nextLine();

			input = input.replaceAll(" ", "");
			input = input.replaceAll("\\p{Z}", "");

			// 인자를 에러를 체크하는 클래스로 넘겨서 확인.
			ErrorCheck eck = new ErrorCheck(input);

			if (eck.right() == false) {

				System.out.println(errorArray[eck.errorType()]);

				continue;

			}

			InfixToPostfix itp = new InfixToPostfix(input);

			String[] result = itp.getresult();

			System.out.print("Postfix로 변환 : ");

			for (int i = 0; result[i] != null; i++) {

				System.out.print(result[i]);

			}

			System.out.println("");

			while (true) {

				System.out.println("계산을 시작할까요? (Y/N)");

				String start = sc.nextLine().toUpperCase();

				if (start.equals("Y")) {

					Calculator cal = new Calculator(result);

					System.out.println("계산 값 : " + cal.calculate());
					break;

				}

				else if (start.equals("N")) {
					break;
				}

				System.out.println("잘못된 입력입니다.");

			}

			while (true) {

				System.out.println("계속하시겠습니까? (Y/N)");

				String con = sc.nextLine().toUpperCase();

				if (con.equals("Y")) {
					break;
				} else if (con.equals("N")) {
					System.out.println("사용해주셔서 감사합니다.");
					System.out.println("프로그램을 종료합니다.");
					System.out.println("==========================");
					return;
				}

				System.out.println("잘못된 입력입니다.");

			}

		}

	}
}