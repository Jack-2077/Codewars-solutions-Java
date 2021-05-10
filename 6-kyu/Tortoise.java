public class Tortoise {
    public static int[] race(int v1, int v2, int g) {
      if(v1 >= v2)
        return null; //B will never catch A
    int speedDifference = (v2 - v1);
    int resultInSeconds = g * 3600 / speedDifference; //*3600 to get in seconds
    int[] result = {resultInSeconds/3600, resultInSeconds%3600/60, resultInSeconds%3600%60};
    return result;   }}
