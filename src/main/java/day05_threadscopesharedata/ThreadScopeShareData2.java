package day05_threadscopesharedata;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Description: 线程范围内共享数据
 * @Author: lianws
 * @Date: 2019/4/21 23:32
 */
public class ThreadScopeShareData2 {
    
    private  static int data=0;
    // 创建一个static的Map存线程和数据data
    private static Map<Thread,Integer> threadData=new HashMap<>();
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data=new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()
                            +" has put the data of :"+data);
                    threadData.put(Thread.currentThread(),data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    /**
     * A,B 模块从Map中取数据
     */
    static class A{
        
        public void get(){
            int data=threadData.get(Thread.currentThread());
            System.out.println("A from "+Thread.currentThread().getName()
                    +" get data:"+data);
        }
    }

    static class B {

        public void get() {
            int data=threadData.get(Thread.currentThread());
            System.out.println("B from " + Thread.currentThread().getName() 
                    + " get data:" + data);
        }
    }
}
