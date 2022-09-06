import org.example.HiringDepartment;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String ... args){
        //���������� �������� ���� � ������� ���������� ����������� ���� ����
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //������� ����, ������� ���� ���������� � ����� applicationContext.xml
        HiringDepartment hiringDepartment = context.getBean("hiringDepartment", HiringDepartment.class);

        hiringDepartment.displayInfo();

        context.close(); //�������� ������ ������ �����������
    }
}
