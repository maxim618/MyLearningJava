package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static task1.Main.Data.*;
import static task1.Main.Percentile.isDigit;
/*Расчёт перцентиля.
Для повышения точности используется линейная интерполяция между соседними значениями в наборе данных.
Это делается вместо округления до целого значения в соответствии с первым определением.
Дробный порядковый номер x рассчитывается по следующей формуле:
x = (P / 100 * (N - 1) + 1)
Дробная часть {x} результата вычисления дробного порядкового номера x затем используется для дальнейшего расчета
величины процентиля v по двум смежным значениям из исходного набора данных:
значения с рассчитанным порядковым номером vn и следующего за ним большего значения vn+1:
v(x)  =  v n  +  {x}  *  (v n+1   -   v n)
https://www.translatorscafe.com/unit-converter/ru-RU/calculator/percentile/
*/

public class Main {
    public static void main(String[] args) {
        pathName = args[0];
        ArrayList<Integer>integers = ReadFile.read();
        System.out.printf("%.2f%n", new Percentile().result(integers, 90));
        System.out.printf("%.2f%n", new Median().result(integers));
        System.out.printf("%.2f%n", new Max().result(integers));
        System.out.printf("%.2f%n", new Min().result(integers));
        System.out.printf("%.2f%n", new Mean().result(integers));
    }
    protected static class Data {
        protected static String pathName;
    }
    protected static class  ReadFile{
        public static ArrayList<Integer> read() {
            ArrayList<Integer> list = new ArrayList<>();
            File file = new File(pathName);

            return list;
        }
    }
    protected static class Percentile {
        public double result(List<Integer> list, int percentile){
            Collections.sort(list);
            int     maxRang = list.size();           //размер списка - максимальный ранг
            double  percentileDiv100 = percentile/100.0;//перцентиль / 100
            double  fractionalOrdinalNumber = percentileDiv100*(maxRang - 1) +1 ;// дробный порядковый номер
            int     fractionalNumber = (int)fractionalOrdinalNumber;
            double fractionalOrdinalNumberPart = fractionalOrdinalNumber - fractionalNumber; //Дробная часть {x} результата вычисления дробного порядкового номера
            return list.get(fractionalNumber - 1) +
                    fractionalOrdinalNumberPart *
                            (list.get(fractionalNumber + 1 - 1) - list.get(fractionalNumber - 1));
        }
        protected static boolean isDigit(String s) throws NumberFormatException {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
    protected static class Median {
        public double result(List<Integer>list){
            Collections.sort(list);
            if (list.size() % 2 == 0)  //если количество элементов в массиве чётное
            {
                //то возвращаем половину от суммы двух средних элементов массива
                return ((list.get( list.size()/2) + (list.get(list.size()/2-1))) / 2f);
            }
            //если количество элементов нечётное, то возвращаем средний элемент массива
            return (list.get(list.size()/2 - 1));
        }
    }
    protected static class Min {
        public double result(List<Integer> list) {
            int minimum = Short.MAX_VALUE;
            for (Integer integer : list) {
                minimum = Math.min(minimum, integer);
            }
            return minimum;
        }
    }
    protected static class Max {
        public double result (List<Integer> list) {
            int maximum = Short.MIN_VALUE;
            for (Integer integer : list) {
                maximum = Math.max(maximum, integer);
            }
            return maximum;
        }
    }
    protected static class Mean {
        public double result (List<Integer>list) {
            double arithmeticMean = 0.0;
            for (Integer integer : list) {
                arithmeticMean += integer;
            }
            return arithmeticMean / list.size();
        }
    }
}
