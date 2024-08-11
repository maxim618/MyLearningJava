package task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

  private  static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  public static void writeMessage(String message){
  System.out.println(message);
}
  public static String readString() {
     // String str = null;
      while (true) {
          try {
              String str = bufferedReader.readLine();
              return str;
          } catch (IOException e) {
              System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
          }
      }
    
}
  public static int readInt(){
       String res = "";
       int result;

      try {
          res = readString();
          result = Integer.parseInt(res);
          }catch (NumberFormatException e){
          System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
          res= readString();
          result = Integer.parseInt(res);
      }
    return result;
  }
}
