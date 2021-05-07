class Solution {
    public static String WhoLikesIt(String... names) {
        if(names.length != 0) {
           String output = "";
           int length = names.length;
             if (length == 1)
               return names[0] + " likes this";
             if (length >= 4)
               output = names[0] + ", " + names[1] + " and " + (length - 2) + " others";
             if (length == 3)
               output = names[0] + ", " + names[1] + " and " + names[2];
             if (length == 2)
               output = names[0] + " and " + names[1];
      return output + " like this";
       }
    return "no one likes this"; }}
