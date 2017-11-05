package thread;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
          ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        for(int i=0;i<15;i++){
            MyTask myTask =new MyTask(i);
            threadPoolExecutor.execute(myTask);
            System.out.println("线程池中的线程数目：" + threadPoolExecutor.getPoolSize() +",队列中等待执行的任务数目："+threadPoolExecutor.getQueue().size()+",已经执行完的任务数目："+threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }

}

class MyTask implements  Runnable{
    private int taskNum;
    public MyTask(int num){
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+ taskNum);
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+ taskNum + "执行完毕");
    }
}
