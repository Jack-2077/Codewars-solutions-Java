public class DRoot {
  public static int digital_root(int n) 
  {
        String s = String.valueOf(n);
        int x = itr(s);
        while(x >= 10)
            x = itr(String.valueOf(x));
        return x;
  }
  
  private static int itr(String d)
    {
        int a = 0;
        for(int i = 0; i < d.length(); i++)
             a += Integer.parseInt(String.valueOf(d.charAt(i)));
        return a;
    }
}
