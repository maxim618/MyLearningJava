public class TestClass {
    private StringBuffer data;
    public TestClass() {
        this.data = new StringBuffer();
        for (long i = 0; i < 50000000; i++) {
            this.data.append('x');
        }
    }
    //переопределяем метод finalize(), чтобы увидеть, что он сработал:
    @Override
    protected void finalize() {
        System.out.println("У объекта TestClass вызван метод finalize!!!");
    }
}