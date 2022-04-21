package task2712.kitchen;

//import com.javarush.task.task31.task3110.ConsoleHelper;



import task2712.ConsoleHelper;
import task2712.statistic.StatisticManager;
import task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;



public class Cook extends Observable implements  Runnable{
    private final String name;
    boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public boolean isBusy() {
        return busy;
    }

    public Cook(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }


    public void startCookingOrder(Order order) throws InterruptedException {
        busy=true;
        Order order1 = order;
        ConsoleHelper.writeMessage("Start cooking - " + order1);
        setChanged();
        notifyObservers(order1);
        CookedOrderEventDataRow row = new CookedOrderEventDataRow(order1.getTablet().toString(), name, order1.getTotalCookingTime() * 60, order1.getDishes());
        StatisticManager.getInstance().register(row);
        Thread.sleep((long) order1.getTotalCookingTime() *10);
        busy=false;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(10);
                if (!queue.isEmpty()) {
                    if (!this.isBusy()) {
                        this.startCookingOrder(queue.take());
                    }
                }
            }
        } catch (InterruptedException e) {
        }
    }
}

