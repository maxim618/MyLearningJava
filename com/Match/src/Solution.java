import java.io.*;
import java.util.*;
/*
Прайсы
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        if(args.length == 0){    //Если запуск без параметров
            return;
        }else if(args[0].equals("-c")) {
            File myFile = new File(filePath);
            Scanner scanFile = new Scanner(myFile);              // Связываем объект Scanner с нашим файлом
            ArrayList<String> listStr = new ArrayList<>();
            ArrayList<Integer> listInt = new ArrayList<>();
            ArrayList<String> listStringFromFile = new ArrayList<>(); //Список для получения данных из файла

            // Пока в файле есть строки
            while (scanFile.hasNextLine()) {
                listStringFromFile.add(scanFile.nextLine()) ;                    //Следующая строка
            }
            for (String s:listStringFromFile){                  //Обрезаем до 8 символов и убираем пробелы
                s = s.substring(0, 8).replaceAll("\\D+","");
                listStr.add(s);
            }
            scanFile.close();

            for (String s : listStr) {                                  //Копирование:
                listInt.add(Integer.parseInt(s));                    //listStr -----> ListInt
            }
            //  for(int i = 0;i < listStr.size();i++){                   //Тестовый вывод ID из файла
            //     System.out.println(listStr.get(i));
            //  }
            Collections.sort(listInt);                                 //Сортировка для нахождения max
            int max = listInt.get(listInt.size()-1);                 //максимальный ID в имеющемся списке
            ArrayList<String>arrayOrArgs = new ArrayList<>();
            for(int i = 0; i < args.length;i++){
                arrayOrArgs.add(args[i]);
            }
            String priceFromArgs = "";                      //Строка для цены из args
            for(int i = 0; i < arrayOrArgs.size(); i++){                      //проверка arrayOrArgs
                if (arrayOrArgs.get(i).matches("[0-9]+\\.[0-9]+")){
                    priceFromArgs += arrayOrArgs.get(i);
                }
            }
            String quantity = "";                   //Количество товара
            for(int i = 1; i < arrayOrArgs.size(); i++){
                quantity = arrayOrArgs.get(arrayOrArgs.size()-1);
            }
            //System.out.println(quantity);
            String productName = "";                                     //Наименование продукта productName
            for (int i = 1; i < arrayOrArgs.size(); i++) {          //
                String tmp = arrayOrArgs.get(i)+" ";                    //Наименование продукта
                if (tmp.matches("\\D+")) {                   //
                    productName += tmp;                             //
                }                                                   //
            }                                                       //
            productName = productName.trim();              //Обрезаем пробелы по краям
            //System.out.println(priceFromArgs);               //проверка цены из args
            writer.newLine();
            writer.write(String.format("%-8d%-30s%-8s%-4s", ++max,productName,priceFromArgs,quantity));
        }
        writer.close();
    }
}

