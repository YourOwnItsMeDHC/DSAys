
/*
Series of sequence provided  : S = 1 + (x+2)/2! + (2x+3)/3! + (3x+4)/4! + ……… to n terms
 */


import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value for n : ");
        int n = sc.nextInt();

        System.out.println("Enter the value for x : ");
        int x = sc.nextInt();

//        double sum = 1;
//        for(int i=2; i<=n; i++) {
////            int val = 0;
//            sum = sum +  (((i-1) * x) + i) / fact(i);
////            System.out.println(sum);
////            sum += val;
//        }

        double sum = 1;
        double ans = 0;
        for(int i=2; i<=n; i++) {
//            sum = sum + ((i*x)+(i+1) / fact(i+1));
            sum = sum + ( ((i-1)*x) + i  / fact(i));
//            sum = sum + ((i-1)+(x+i) / fact(i));
            System.out.println(sum);
            ans += sum;
        }
/*
Series of sequence provided  : S = 1 + (x+2)/2! + (2x+3)/3! + (3x+4)/4! + ……… to n terms
 */

        System.out.println("Sum of the series is : " + ans);

    }

    public static double fact(int n) {
        int fact = 1;
        for(int i=n; i>=1; i--) {
            fact = fact * i;
        }
        return fact;
    }
}
