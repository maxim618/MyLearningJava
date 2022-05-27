import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        //создаем объект FileInputStream, привязанный к файлу «c:/javaTest/1.txt».
        FileInputStream inputStream = new FileInputStream("c:/javaTest/1.txt");
        long sum = 0;

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            sum += data; //добавить его к общей сумме
        }
        inputStream.close(); // закрываем поток

        System.out.println(sum); //выводим сумму на экран.

        //----------------------------------------------------

        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream2 = new FileInputStream("c:/javaTest/1.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("c:/javaTest/2.txt");

        while (inputStream2.available() > 0) //пока есть еще непрочитанные байты
        {
            int data = inputStream2.read(); // прочитать очередной байт в переменную data
            outputStream.write(data); // и записать его во второй поток
        }

        inputStream2.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }
}
