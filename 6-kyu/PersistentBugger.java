class Persist {
  public static int persistence(long n) 
  {
    String[] list = Long.toString(n).split("");
    if(list.length == 1) 
      return 0;
    int product = 1;
    for(String s : list)
    {
      int i = Integer.parseInt(s);
      product *= i;
     }
    return persistence(product) + 1;   
  }
}
