import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private static final Map<Integer,Character> map = new TreeMap<Integer,Character>();
    private static boolean isValid = true;
    static {
        map.put(10,'a');
        map.put(11,'b');
        map.put(12,'c');
        map.put(13,'d');
        map.put(14,'e');
        map.put(15,'f');
        map.put(0,'0');
        map.put(1,'1');
        map.put(2,'2');
        map.put(3,'3');
        map.put(4,'4');
        map.put(5,'5');
        map.put(6,'6');
        map.put(7,'7');
        map.put(8,'8');
        map.put(9,'9');
    }

    public static void validityControl(int value,String digit){
        char []ch = digit.toCharArray();
        for (Character character:ch){
            if(!map.containsValue(character)){
                isValid = false;
                break;}
            for (Map.Entry<Integer,Character>m:map.entrySet()){
                if(character.equals(m.getValue())){
                    if(m.getKey()>=value){
                        isValid = false;
                    }
                }
            }
        }
    }
    public  static boolean check(){
        return isValid;
    }

    public static void main(String[] args) {

        validityControl(2,"100");
        System.out.println("валидность данных: " + check());
        isValid=true;
        validityControl(2,"1003");
        System.out.println("валидность данных: " + check());
        isValid=true;
        validityControl(2,"100");
        System.out.println("валидность данных: " + check());

    }

}
