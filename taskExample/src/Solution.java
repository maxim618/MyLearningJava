import java.util.concurrent.Executor;

public class Solution {
    public static void main(String []args) throws Exception {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task executed");
            }
        };
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable runnable) {
                new Thread(runnable).start();
            }
        };
        executor.execute(task);
    }
}
