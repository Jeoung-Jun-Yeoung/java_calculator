package mycalculator;

import java.util.*;

public class Main {

	private static String[] errorArray = { "size�� 1000�� �ʰ��߽��ϴ�.", "��ȿ�������� ��ȣ�� ���ڰ� �ԷµǾ����ϴ�.", "�˸��� �Ұ�ȣ ǥ�Ⱑ �ƴմϴ�.",
			"ǥ�� Infix ������ �ƴմϴ�.", "������ �ԷµǾ����ϴ�." };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("=============== MyCalculator ================ ");
		System.out.println("MyCalculator�� ����� ȯ���մϴ�.");
		System.out.println("�� 1: �� ����� ����� ���� ����� �����մϴ�.");
		System.out.println("�� 2: ���ڿ� ��Ģ������ ������ ������ 1000�� ���Ͽ����մϴ�.");
		System.out.println("�� 3: ����, (,),+,-,*,/�� ������ ��ȣ�� ���� �ʽ��ϴ�.");
		System.out.println("�� 4: ǥ�� Infix�Ŀ� ��߳� ������� ���� �ʽ��ϴ�.");
		System.out.println("�� 5: ������ ����մϴ�.");
		System.out.println("�� 6: ��Ģ������ ������ ������� �ʽ��ϴ�. ex> 7(5+6) ������� �ʽ��ϴ�. ");
		System.out.println("�� 7: ��갪�� Infinity�� ��쿡�� ������ ���� 0�� �ִ� ����Դϴ�.");
		System.out.println("=============================================== ");

		while (true) {

			System.out.println("Infix�� ������ �Է��Ͻÿ�.");

			String input = sc.nextLine();

			input = input.replaceAll(" ", "");
			input = input.replaceAll("\\p{Z}", "");

			// ���ڸ� ������ üũ�ϴ� Ŭ������ �Ѱܼ� Ȯ��.
			ErrorCheck eck = new ErrorCheck(input);

			if (eck.right() == false) {

				System.out.println(errorArray[eck.errorType()]);

				continue;

			}

			InfixToPostfix itp = new InfixToPostfix(input);

			String[] result = itp.getresult();

			System.out.print("Postfix�� ��ȯ : ");

			for (int i = 0; result[i] != null; i++) {

				System.out.print(result[i]);

			}

			System.out.println("");

			while (true) {

				System.out.println("����� �����ұ��? (Y/N)");

				String start = sc.nextLine().toUpperCase();

				if (start.equals("Y")) {

					Calculator cal = new Calculator(result);

					System.out.println("��� �� : " + cal.calculate());
					break;

				}

				else if (start.equals("N")) {
					break;
				}

				System.out.println("�߸��� �Է��Դϴ�.");

			}

			while (true) {

				System.out.println("����Ͻðڽ��ϱ�? (Y/N)");

				String con = sc.nextLine().toUpperCase();

				if (con.equals("Y")) {
					break;
				} else if (con.equals("N")) {
					System.out.println("������ּż� �����մϴ�.");
					System.out.println("���α׷��� �����մϴ�.");
					System.out.println("==========================");
					return;
				}

				System.out.println("�߸��� �Է��Դϴ�.");

			}

		}

	}
}