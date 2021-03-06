package task2712.ad;

public class Advertisement {

    private Object content; //- видео
    private String name; // - имя/название
    private long initialAmount; // начальная сумма, стоимость рекламы в копейках.
    private int hits;         //- количество оплаченных показов
    private int duration;         // - продолжительность в секундах
    private long amountPerOneDisplaying;//- стоимость показа одного рекламного объявления в копейках


    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if(hits>0) {
            this.amountPerOneDisplaying = initialAmount / hits;
        }else amountPerOneDisplaying = 0;

    }
    public int getHits() {
        return hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
    public void revalidate(){
        if(hits<1){
            throw new NoVideoAvailableException();
        }
        hits--;
    }

    public boolean isActive() {
        return hits > 0;
    }
}
