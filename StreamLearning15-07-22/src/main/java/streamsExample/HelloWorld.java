package streamsExample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HelloWorld {

    public static class SomeType<T> {
        public <E> void test(Collection<E> collection) {
            for (E element : collection) {
                System.out.println(element);
            }

        }
        public void test(List<Integer> collection) {
            for (Integer element : collection) {
                System.out.println(element);
            }
        }


    }
    public static  void main(String []args) {
        HelloWorld.SomeType<Data> st = new HelloWorld.SomeType<>();
        Data data3 = new Data(123456L);
        //data3 = new Data();
        List<Data> list = Arrays.asList( new Data(),new Data(),new Data(),data3);
        //st.test(list);

        Data data = list.stream().filter((Data i) -> {
            int y = list.indexOf(i);

            if(list.get(y).data()==123456L){
                System.out.println("y = " + y);
                return true;
            }else {
                return false;
            }
        }).findFirst().orElse(new Data(0L));

        System.out.println(data.data());

        System.out.println(System.currentTimeMillis());
        Stream.of("qwe","rty","uisop","asdf","ghjk")
                .filter(s -> s.contains("o")&s.contains("s")).map(a  -> a + "xxx")
                .limit(8).forEach(System.out::println);
        System.out.println(System.currentTimeMillis());


        String[] array1 = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray1 = Arrays.stream(array1);
        streamOfArray1.map(s->s.split("")) //Преобразование слова в массив букв
                .flatMap(array2 -> Arrays.stream(array2))
                .distinct() //выравнивает каждый сгенерированный поток в один поток
                .collect(Collectors.toList()).forEach(System.out::println);

        String[] array = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s->s.split("")) //Преобразование слова в массив букв
                .map(array2 -> Arrays.stream(array2)).distinct() //Сделать массив в отдельный поток
                .collect(Collectors.toList()).forEach(System.out::println);

        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(x1 -> System.out.println(x1));// 010120012

        Stream.of(2, 3, 0, 1, 3)
                .map(x -> IntStream.range(0, x))
                .forEach(x1 -> System.out.println(x1));//перечень стримов(потоков);


        List<String>arrayList = Arrays.asList("qwerty", "uiop", "asdfg", "hjkl", "zxcv", "bnm");





    }

}
