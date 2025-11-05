import java.util.Scanner;
import mypackage.*;
public class MainClass {
    public static void main(String[] args) {
        int a,b;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a and b values:");
        a=sc.nextInt();
        b=sc.nextInt();
        Addition a1=new Addition();
        a1.add(a,b);

    }
}
