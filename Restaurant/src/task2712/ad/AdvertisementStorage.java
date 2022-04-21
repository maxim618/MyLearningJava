package task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage instance;
    private final List<Advertisement> videos = new ArrayList<>();
    AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60) );// 3 min
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)) ;//10 min
        videos.add(new Advertisement(someContent, "четвёртое видео", 200,4,20 * 60));
    }
    public static AdvertisementStorage getInstance(){
      if(instance==null) {
          instance = new AdvertisementStorage();
      }
      return instance;
    }
    public List<Advertisement> list(){
        return  videos;
    }
    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }
}
