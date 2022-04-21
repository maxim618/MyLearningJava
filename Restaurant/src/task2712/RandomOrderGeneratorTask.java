package task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    List<Tablet> tablets;
    int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        int size = tablets.size();
        if (size>0){
            while (!Thread.currentThread().isInterrupted()){
                int randomNumber = (int) Math.random() * size;
                Tablet tablet = tablets.get(randomNumber);
                tablet.createOrder();
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                   break;
                }
            }
        }

    }
}
