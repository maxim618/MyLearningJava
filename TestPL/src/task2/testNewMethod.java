package task2;

public class testNewMethod {
    // Java-программа для оценки области
// многоугольника по формуле шнурка
        // (X [i], Y [i]) - координаты i-й точки.
        public static double polygonArea(double[] X, double []Y, int n) {
            // Initialize area
            double area = 0.0;
            // Рассчитать значение формулы шнурка
            int j = n - 1;
            for (int i = 0; i < n; i++)
            {
                area += (X[j] + X[i]) * (Y[j] - Y[i]);
                // j - предыдущая вершина i
                j = i;
            }
            // Возвращаем абсолютное значение
            return Math.abs(area / 2.0);
        }
        // Драйвер программы
        public static void main (String[] args)
        {
            double[] X = {0,   0, 5.5, 5.5};
            double[] Y = {0, 5.5, 5.5,   0};
            int n = 4;
            System.out.println(polygonArea(X, Y, n));
        }
    }
// Этот код предоставлен Sunnnysingh

