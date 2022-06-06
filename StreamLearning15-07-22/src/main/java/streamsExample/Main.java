package streamsExample;

import com.sun.deploy.util.JVMParameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main <X>{
    List<Integer> list =  Arrays.asList(0,10,2,6,10,10);
    int dataIndex;


    public void set(X data){
        dataIndex = IntStream
                .range(0, 2)
                .filter((int index) -> this.list.get(index)==data).findFirst().orElse(-1);
    }
    int dataIndex2 =     list. stream().filter((Integer x)-> x==10).findFirst().orElse(-1);


}
