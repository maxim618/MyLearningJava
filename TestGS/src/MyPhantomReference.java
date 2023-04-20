import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

//класс, который имплементирует PhantomReference
public class MyPhantomReference<TestClass> extends PhantomReference<TestClass> {

    public MyPhantomReference(TestClass obj, ReferenceQueue<TestClass> queue) {

        super(obj, queue);

        Thread thread = new QueueReadingThread<TestClass>(queue);

        thread.start();
    }

    public void cleanup() {
        System.out.println("Очистка фантомной ссылки, удаление объекта из памяти!");
        clear();
    }
}