package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description
 * Date 2021/5/22 10:56 上午
 *
 * @author dafu
 */
public class ThreadTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
       Thread a = new Thread(()->{
           System.out.println("线程A 运行");
           try {
               Thread.sleep(10*1000);
           } catch (InterruptedException e) {
               System.out.println(Thread.currentThread().isInterrupted());
               e.printStackTrace();
           }
           System.out.println("线程唤醒");
       });
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.interrupt();
    }
}
