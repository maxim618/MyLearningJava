package streamsExample;

public class Data {

    private final Long number;

    public Data() {
        number = System.currentTimeMillis();
    }
    public Long data(){
        return number;
    }
    public Data(Long data){
        this.number = data;

    }
}
