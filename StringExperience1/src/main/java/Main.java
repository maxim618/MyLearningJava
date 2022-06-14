import org.example.HiringDepartment;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String ... args){
        //Определяем контекст файл в котором содержатся прописанные нами бины
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Получем бины, которые были определены в файле applicationContext.xml
        HiringDepartment hiringDepartment = context.getBean("hiringDepartment", HiringDepartment.class);

        hiringDepartment.displayInfo();

        context.close(); //Контекст всегда должен закрываться
    }
}
