package streamsExample;

import java.util.ArrayList;

public class LearningIntStream <X>{
     ArrayList<X> list = new ArrayList<X>();

    LearningIntStream(X t){
        list.add(t);
    }
    public void printList(){
        for (X x: list){
            System.out.println(x);
        }
    }
}
