package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private AbstractIntGenerator generator;
    private final int id;

    public EvenChecker(AbstractIntGenerator g,int ident) {
        this.generator = g;
        this.id = ident;
    }


    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val = generator.next();
            if(val % 2 != 0){
                System.out.println(val + " not event! ");
                generator.cancel();
            }

        }
    }
    public static void test(AbstractIntGenerator gp, int count){
        System.out.println("press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < count; i ++){
            exec.execute(new EvenChecker(gp,i));
        }
        exec.shutdown();

    }
}
