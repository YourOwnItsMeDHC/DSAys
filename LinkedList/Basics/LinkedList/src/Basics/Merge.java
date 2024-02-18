package Basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Merge {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};

        int[] ans = mergeSort(nums);
        System.out.println("Sorted Array is : " + Arrays.toString(ans));

        int[] nums2 = {10, 65, 5, 88, 55, 887, 341, 54, 45, 96, 982, 65, 52};
        mergeSortInPlace(nums2, 0, nums2.length);
        System.out.println("Sorted array from merge sort - jn place : " + Arrays.toString(nums2));

        int[] arr = {4, 5, 8, 7, 4, 7, 6,7};
        freq(arr);
    }


    static int[] mergeSort(int[] nums) {
        if(nums.length == 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];

        int i=0, j=0, k=0;

        while(i<left.length && j<right.length) {
            if(left[i] < right[j]) {
                mix[k] = left[i];
                i++;
            }
            else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length) {
            mix[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length) {
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;
    }





    static void mergeSortInPlace(int[] nums, int start, int end) {
        if(end - start == 1) {
            return;
        }

        int mid = start + (end-start) / 2;

        mergeSortInPlace(nums, start, mid);
        mergeSortInPlace(nums, mid, end);

        mergeInPlace(nums, start, mid, end);
    }

    static void mergeInPlace(int[] nums, int start, int mid, int end) {
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while(i<mid && j<end) {
            if(nums[i] < nums[j]) {
                mix[k] = nums[i];
                i++;
            }
            else {
                mix[k] = nums[j];
                j++;
            }
            k++;
        }

        while(i < mid) {
            mix[k] = nums[i];
            i++;
            k++;
        }

        while(j < end) {
            mix[k] = nums[j];
            j++;
            k++;
        }

        for(int l=0; l<mix.length; l++) {
            nums[start + l] = mix[l];
        }
    }


    public static void freq(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();

        for(int ele : nums) {
            m.put(ele, m.getOrDefault(ele, 0) + 1);
        }

        int element = 0;
        int frequency = 0;
        for(Map.Entry<Integer, Integer> map : m.entrySet()) {
            if(map.getValue() > frequency) {
                element = map.getKey();
                frequency = map.getValue();
            }
        }

        System.out.println(element + " has the max frequency : " + frequency);
    }
}
