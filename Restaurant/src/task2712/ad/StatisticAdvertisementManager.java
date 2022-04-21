package task2712.ad;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StatisticAdvertisementManager {
    //AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private StatisticAdvertisementManager(){
    }
    public static StatisticAdvertisementManager getInstance(){
        if(instance == null){
            instance = new StatisticAdvertisementManager();
        }
        return instance;
    }
    public Map<String,Integer>pullsOut(){

        List<Advertisement>videos = AdvertisementStorage.getInstance().list();
        Map<String,Integer>statisticActive = new TreeMap<>();
        for(Advertisement a:videos){
            String name = a.getName();
            int views = a.getHits();
            statisticActive.put(name,views);
        }
        return statisticActive;
    }



}
