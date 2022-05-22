import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution implements Comparable<Solution>{
    private String name;
    private Integer age;
    private String email;
    public Solution (String name, int age, String email){
        this.name=name;
        this.age=age;
        this.email=email;
    }
    @Override
    public int compareTo(Solution o) {
        return  this.age.compareTo(o.age);
    }

    @Override
    public String toString(){
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }


    public static void main(String[] args) {
        List <Solution> list = new ArrayList<>();
        Solution name1 = new Solution("Андрей", 19, "andryha@mail.ru");
        Solution name2 = new Solution("Олег", 25, "oleg@mail.ru");
        Solution name3 = new Solution("Андрей", 24,"opr@google.com");
        Solution name4 = new Solution("Игорь", 16, "igor@mail.ru");
        Solution name5 = new Solution("Андрей", 44,"stary@google.com");
        list.add(name1);
        list.add(name2);
        list.add(name3);
        list.add(name4);
        list.add(name5);

        System.out.println("-------до сортировки--------");
        for(Solution s:list){
            System.out.println(s);
        }
        System.out.println("-------после сортировки-----");
        Collections.sort(list);
        for(Solution s:list){
            System.out.println(s);
        }
    }
}
