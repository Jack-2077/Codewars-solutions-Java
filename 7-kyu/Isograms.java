public class isogram {
    public static boolean  isIsogram(String str) {
        if(str == null)
           return false;
        if(str.isEmpty())
             return true;

        return str.length() == str.toLowerCase().chars().distinct().count();
    } 
}
