import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class PathOpener {

    public static File[] arrayPaths(String pathToAnimals){
        File[] tempList = new File(pathToAnimals).listFiles();
        assert tempList != null;
        List<File>list = new ArrayList<>();
        for (File f:tempList){
           if(f.getName().endsWith(".class")){
               list.add(f);
           }
       }
        return list.toArray(new File[0]);
    }
}
