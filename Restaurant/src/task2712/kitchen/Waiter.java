package task2712.kitchen;

import task2712.ConsoleHelper;


import java.util.Observable;
import java.util.Observer;




public class Waiter implements Observer {
    @Override
    public void update(Observable cook, Object order) {
        ConsoleHelper.writeMessage(order + " was cooked by " + cook);
    }




}
