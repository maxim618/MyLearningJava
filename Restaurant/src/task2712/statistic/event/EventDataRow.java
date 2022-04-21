package task2712.statistic.event;

import java.util.Date;

public interface EventDataRow {
    public EventType getType();
    public Date getDate(); //реализация которого вернет дату создания записи;
    public int getTime();//реализация которого вернет время или продолжительность.

}
