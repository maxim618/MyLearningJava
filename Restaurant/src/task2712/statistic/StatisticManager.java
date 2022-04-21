package task2712.statistic;


import task2712.statistic.event.CookedOrderEventDataRow;
import task2712.statistic.event.EventDataRow;
import task2712.statistic.event.EventType;
import task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    //private Set<Cook>cooks = new HashSet<>();

    private static StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
   private StatisticManager(){
        
    }
    public static StatisticManager getInstance(){
        
        return instance;
    }
    public void register(EventDataRow data){
        
        this.statisticStorage.put(data);
    }
   /* public void  register(Cook cook){

       this.cooks.add(cook);
    }

    */

    /*public Set<Cook> getCooks() {
        return cooks;
    }

     */

    public Map<String, Double> reklama() {
        Map<String, Double> result = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (EventDataRow video : statisticStorage.getStorage(EventType.SELECTED_VIDEOS)) {
            VideoSelectedEventDataRow videoRow = (VideoSelectedEventDataRow) video;
            double allMoney = videoRow.getAmount();
            String data = sdf.format(videoRow.getDate());
            if (result.containsKey(data)) {
                result.put(data, result.get(data) + allMoney / 100.00);
            }
            else {
                result.put(data, allMoney / 100.00);
            }
        }
        return result;
    }

    public Map<String, Map<String, Integer>> povar() {
        Map<String, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (EventDataRow event : statisticStorage.getStorage(EventType.COOKED_ORDER)) {
            CookedOrderEventDataRow cookRow = (CookedOrderEventDataRow) event;
            String data = sdf.format(cookRow.getDate());
            String name = cookRow.getCookName();
            Integer time =  cookRow.getTime() / 60;
            if (time > 0) {
                if (!result.containsKey(data)) {
                    Map<String, Integer> inner = new TreeMap<>();
                    inner.put(name, time);
                    result.put(data, inner);
                } else {
                    Map<String, Integer> inner = result.get(data);
                    if (!inner.containsKey(name)) {
                        inner.put(name, time);
                    } else {
                        inner.put(name, inner.get(name) + time);
                    }
                }
            }
        }
        return result;
    }
    private class  StatisticStorage{

        Map<EventType, List<EventDataRow>> storage = new HashMap<>();
        StatisticStorage(){
            EventType[]eventTypes = EventType.values();
            for(int i = 0;i<eventTypes.length;i++){
                storage.put(eventTypes[i],new ArrayList<>());
            }
        }
        private List<EventDataRow> getStorage(EventType type) {
            return storage.get(type);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
        //public Map<EventType, List<EventDataRow>> getStorage() {
          //  return storage;
       // }

        private void put(EventDataRow data){
             EventType eventType = data.getType();
             storage.get(eventType).add(data);
            if (!this.storage.containsKey(eventType))
                throw new UnsupportedOperationException();

        }
    }
}
