public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{ 1, 2, 3,
                4, 5, 6 };
        int n = 6;
        print(a, n, 1);
    }

    public static void print(int a[], int n, int ind){
        // Создаем вспомогательный массив
        // двойного размера.
        int  [] b = new int [(2 * n)];
        // Копируем a [] в b [] два раза
        for (int i = 0; i < n; i++)
            b[i] = b[n + i] = a[i];
        // печатаем из ind-го индекса в
        // (n + i) -й индекс.
        for (int i = ind; i < n + ind; i++)
            System.out.print(b[i] + " ");
    }
}
