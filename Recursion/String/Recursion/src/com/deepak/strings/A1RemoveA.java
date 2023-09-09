//Skkiping a character - Skip a character, whenever we encunter 'a'

package com.deepak.strings;
public class A1RemoveA {
    public static void main(String[] args) {
        String s = "abcaabbacbcac";

        skip("", s);                              // bcbbcbcc

        System.out.println(skipp(s));                //bcbbcbcc
    }




    //Method, which, does not return anything, it only skips 'a'
    //p ==> processed string, which has been concatenated onto the answer string i.e.
    // string where 'a' has been skipped

    //up ==> unprocessed string, in which still removal of character 'a' is remaining
    public static void skip(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        //First character of the unprocessed string
        char ch = up.charAt(0);

        if(ch == 'a') {
            //Here, we have encountered 'a' as the first character in unprocessed string
            //Hence, we have to skip that first character from the unprocessed string
            skip(p, up.substring(1));
        }
        else {
            //Else, just simply, add that first character in the processed string
            //Here, also we have to move to the next character in the unprocessed string, for the next function call
            skip(p + ch, up.substring(1));
        }
    }







    //Method, which, which return string with skiped 'a' character
    public static String skipp(String s) {
        if(s == "") {
            //If string doesn't have any character, that means we have traversed the whole string, just simply return
            return "";
        }

        // First character of the unprocessed string
        char ch = s.charAt(0);

        if(ch == 'a') {
            // Here, we don't have to concatenate 'a' in our answer string
            return skipp(s.substring(1));
        }
        else {
            // Here, we have to concatenate the encountered character
            return ch + skipp(s.substring(1));
        }
    }


}

