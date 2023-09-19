//public class Golden {
//    public static void main(String args[]) {
//
//
////        int n = 56;
////
////        //int ans = (int)(Math.pow(((1+Math.sqrt(5))/2), n)  - (Math.pow(((1+Math.sqrt(5))/2), n))/ Math.sqrt(5));
////        int ans2 = (int)((Math.pow(((1+Math.sqrt(5))/2), n)) - (Math.pow(((1-Math.sqrt(5))/2), n)) / Math.sqrt(5));
////        System.out.println("Sum of x+y = " + ans2)
//
//        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3};
//        int n = nums.length;
//
//        n = removeduplicates(nums, n);
//
//        for(int i=0; i<n; i++) {
//            System.out.println(nums[i]);
//        }
//
//    }
//
//    public static int removeduplicates(int[] nums, int n) {
//        if(n == 0 || n == 1) {
//            return n;
//        }
//
////        int[] temp = new int[n];
////        int j = 0;
////        for(int i=0; i<nums.length-1; i++) {
////            if(nums[i] != nums[i+1]) {
////                temp[j++] = nums[i];
////            }
////        }
//
////        temp[j++] = nums[n-1];
//
////        for(int i=0; i<j; i++) {
////            nums[i] = temp[i];
////        }
//
//        int j = 0;
//        for(int i=0; i<nums.length-1; i++) {
//            if(nums[i] != nums[i+1]) {
//                nums[j++] = nums[i];
//            }
//        }
//        nums[j++] = nums[n-1];
//
//        return j;
//    }
//}


import java.util.Iterator;
import java.util.LinkedHashSet;

//If array is not sorted
public class Golden {
    public static void main(String args[]) {
        int a[] = {5,2,6,8,6,7,5,2,8};

        // Function call
        removeDuplicates(a);
    }

    public static void removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> dupli = new LinkedHashSet<>();

        for(int i=0; i<nums.length; i++) {
            dupli.add(nums[i]);
        }

//        System.out.println(dupli);
        Iterator<Integer> itr = dupli.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
