package IOmethods;

import java.util.Scanner;

public class IOwithScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.print("The sum of these three numbers is ");
        System.out.println(a + b + c);
    }
}