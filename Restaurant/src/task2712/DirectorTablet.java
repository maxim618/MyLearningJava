package task2712;



import task2712.ad.StatisticAdvertisementManager;
import task2712.statistic.StatisticManager;

import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class DirectorTablet {
   private final StatisticAdvertisementManager advertisementManager = StatisticAdvertisementManager.getInstance();
   private final StatisticManager manager              = StatisticManager.getInstance();
   public void printAdvertisementProfit() throws Exception {  //1. какую сумму заработали на рекламе, сгруппировать по дням;
      double total = 0.0;
      Map<String, Double> profit = manager.reklama();
      for (Map.Entry<String, Double> prof : profit.entrySet()) {
         ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", prof.getKey(), prof.getValue()));
         total += prof.getValue();
      }
      if (total > 0) {
         ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total));
      }
   }
   public void printCookWorkloading() {
      Map<String, Map<String, Integer>> loading = manager.povar();
      for (Map.Entry<String, Map<String, Integer>> load : loading.entrySet()) {
         ConsoleHelper.writeMessage(load.getKey());
         for (Map.Entry<String, Integer> inner : load.getValue().entrySet()) {
            //    int workTime = (int) Math.ceil(inner.getValue() / 60.0);
            ConsoleHelper.writeMessage(String.format("%s - %d min", inner.getKey(), inner.getValue()));
         }
         ConsoleHelper.writeMessage("");
      }
   }
   public void printActiveVideoSet(){ // 3. список активных роликов и оставшееся количество показов по каждому;
      Map<String,Integer>statistic = advertisementManager.pullsOut();
      SortedSet<String> videos = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
      for(Map.Entry<String,Integer>m:statistic.entrySet()){
         if(m.getValue()>0) {
            videos.add(m.getKey() + " - " + m.getValue());
         }
      }
      for(String v:videos){
         ConsoleHelper.writeMessage(v);
      }
   }
   public void printArchivedVideoSet(){ //4. список неактивных роликов (с оставшемся количеством показов равным нулю).

      Map<String,Integer>statistic = advertisementManager.pullsOut();
      SortedSet<String> videos = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
      for(Map.Entry<String,Integer>m:statistic.entrySet()){
         if(m.getValue()==0) {
            videos.add(m.getKey());
         }
      }
      for(String v:videos){
         ConsoleHelper.writeMessage(v);
      }
   }
}
