package lesson18;

import java.util.Scanner;

public class testABC {
	public static void main(String[] args) {
				System.out.println("请输入你的数字：");
		        Scanner sc = new Scanner(System.in);
		        String line = sc.nextLine();
		        System.out.println("你的数字是："+line);
		        String[] numbers = line.split(" ");
		        int sum = 0;
		        for(String n:numbers){
		            sum += Integer.parseInt(n);
		        System.out.println(sum);

		       }
	}
}

