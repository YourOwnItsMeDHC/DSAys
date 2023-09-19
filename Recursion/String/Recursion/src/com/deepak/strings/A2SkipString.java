//Skkiping a string- Skip "deepak"

package com.deepak.strings;

public class A2SkipString {
    public static void main(String[] args) {
        String s = "abcdeepakabc";

        System.out.println(skip(s));                 //abcabc
    }


    ////Method, which, which return string with skiped "deepak"
    public static String skip(String s) {
        if(s.isEmpty()) {
            return "";
        }

        //First character of the unprocessed string
        char ch = s.charAt(0);

        //Here, we have encountered "deepak" in unprocessed string
        //Hence, we have to skip that "deepak" from the unprocessed string
        // Here, we don't have to concatenate "deepak" in our answer string
        //"deepak" has 6 characters, so, here we have to skip these 6 characters
        //SO, in order to skip "deepak", we will jump directly onto the 6th index i.e. 7th character
        if(s.startsWith("deepak")) {
            return skip(s.substring(6));
        }
        else {
            return ch + skip(s.substring(1));
        }
        // Here, we have to concatenate the encountered character
        //Here, also we have to move to the next character in the unprocessed string, for the next function call

    }
}
