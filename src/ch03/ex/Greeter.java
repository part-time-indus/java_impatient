package ch03.ex;

public class Greeter implements Runnable {
    String target;
    int n;
    public Greeter(String target, int n){
        this.target = target;
        this.n = n;
    }
    @Override
    public void run(){
        for(int i = 0; i < n; i++){
            System.out.println("Hello " + target);
        }
    }

    public static void runTogether(Runnable... tasks){
        for(Runnable task: tasks){
            Thread thread = new Thread(task);
            thread.start();
        }

    }

    public static void runInOrder(Runnable... tasks){

        for(Runnable task: tasks){
            task.run();
        }


    }

    public static Runnable RunSync(Runnable[] inst){
        return () -> {
            for(Runnable run: inst){
                run.run();
            }
        };

    }

    public static void main(String[] varargs){
        Runnable task1 = new Greeter("Kutta", 10);
        Runnable task2 = new Greeter("Kanjar", 25);
        runInOrder(task1, task2);

    }


}
