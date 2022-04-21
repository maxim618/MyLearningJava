package task2712;


import task2712.ad.AdvertisementManager;
import task2712.ad.NoVideoAvailableException;
import task2712.kitchen.Order;
import task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tablet  {
    private final int number; //- это номер планшета
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public Tablet(int number) {
        this.number = number;
        
    }
    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            if(order.isEmpty())return null;
            //setChanged();
            //notifyObservers(order);
            queue.put(order);
            AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            manager.processVideos();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }catch (NoVideoAvailableException N){
            logger.log(Level.INFO,"No video is available for the order "+order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return order;
    }
    public void createTestOrder() {
        Order order = null;
        try {
            order = new TestOrder(this);
           
            //setChanged();
            //notifyObservers(order);
            queue.put(order);
            AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            manager.processVideos();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }catch (NoVideoAvailableException N){
            logger.log(Level.INFO,"No video is available for the order "+order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    @Override
    public String toString() {
       return  "Tablet{" +
                "number=" + number +
                "}";
    }
}
