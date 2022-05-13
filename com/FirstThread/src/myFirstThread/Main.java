package myFirstThread;

public class Main extends MyFirstThread{
    public static void main(String[] args) throws InterruptedException {

        MyFirstThread t1 = new MyFirstThread();
        MyFirstThread t2 = new MyFirstThread();

        t1.start();


 /*Второй поток t2 начнет выполнение только после того, как будет завершен
       (или бросит исключение) первый поток - t1*/
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        //Главный поток продолжит работу только после того, как t1 и t2 завершат работу
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Все 2 потока закончили работу, программа завершена");

    }
}
