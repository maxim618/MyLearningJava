public class User
{
    String name;
    short age;
    int height;

    public User(String name, short age, int height)
    {
      this.name = name;
      this.age = age;
      this.height = height;
    }
    public  User(short age, String name, int height)
    {
        this.age = age;
        this.name = name;
        this.height = height;
    }
    public User(int height, String name, short age)
    {
        this.height = height;
        this.name = name;
        this.age = age;
    }
public User(String name,int height,short age)
    {
        this.height = height;
        this.name = name;
        this.age = age;
    }


    public static void main(String[] args)
    {
        User v1 = new User("Pieter", (short) 120, 70);
        System.out.println(v1.name);
        System.out.println(v1.height);
        System.out.println(v1.age);
    }
}
