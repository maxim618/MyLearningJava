package task2712;


import task2712.kitchen.Cook;
import task2712.kitchen.Order;
import task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue(200);

    private static final int  ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) throws Exception {
         //Tablet tablet = new Tablet(5);
        List<Tablet>tabletsList = new ArrayList<>();
         Cook cook = new Cook("Amigo");
         cook.setQueue(ORDER_QUEUE);
         Cook cook2 = new Cook("Amigo2");
         cook2.setQueue(ORDER_QUEUE);
        for (int i = 1;i<=5;i++){
            Tablet tablet = new Tablet(i);
            tablet.setQueue(ORDER_QUEUE);
            tabletsList.add(tablet);

        }
        Thread cookK1 = new Thread(cook);
        cookK1.start();
        Thread cooKk2 = new Thread(cook2);
        cooKk2.start();

        

        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletsList, ORDER_CREATING_INTERVAL));
        thread.start();
         
        // tablet.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter);

        try {
            Thread.sleep(1000);
            thread.interrupt();
            thread.join();
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }

        
         DirectorTablet directorTablet = new DirectorTablet();
         directorTablet.printActiveVideoSet();
         directorTablet.printAdvertisementProfit();
         directorTablet.printCookWorkloading();
         directorTablet.printArchivedVideoSet();

         


    }


}
