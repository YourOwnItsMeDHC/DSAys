/*
Write a java program to find the dynamics max ad min value according to user defined position
 */

package mock;
import java.util.Arrays;
import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the array : ");
        int len = sc.nextInt();

        int[] nums = new int[len];
        for(int i=0; i<len; i++) {
            System.out.println("Enter the element for index : " + i);
            nums[i] = sc.nextInt();
        }

        System.out.println("Array : " + Arrays.toString(nums));
//
//        boolean flag = false;

        int max1 = nums[0];
        int max2 = nums[1];

        for(int i=2; i<nums.length; i++) {
            if(max1 > nums[i]) {
                max2 = max1;
                max1 = nums[i];
            }
            else if(max2 > nums[i]) {
                max2 = nums[i];
            }
        }
        System.out.println("MaX -1 : " + max1 + ", Max - 2 : " +  max2);


//        System.out.println("Do you want max or min : ");
//        String query = sc.next();
//
//        if()

//        Arrays.sort(nums);
        bubbleSort(nums);
        System.out.println("After sorting : " + Arrays.toString(nums));

        System.out.println("Which min value you do want ");
        int min = sc.nextInt();

        System.out.println(nums[min-1]);

    }


    public static void bubbleSort(int[] nums) {
        //Iteration
        boolean swapped = false;
        for(int i=0; i<nums.length; i++) {
            for(int j=1; j<=nums.length-i-1; j++) {
                if(nums[j-1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
                swapped = true;
            }
            if(!swapped) {
                break;
            }
        }
    }


}
