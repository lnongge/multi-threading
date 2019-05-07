package day05_threadscopesharedata;

import java.util.Random;

/**
 * @Description: 线程范围内共享数据
 * 用for循环启动2个线程无法达到视频中效果,为什么? 难道跟JDK版本有关
 * @Author: lianws
 * @Date: 2019/4/21 23:32
 */
public class ThreadScopeShareData {
    
    private  static int data=0;
    
    public static void main(String[] args) {
//        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public  void run() {
                    data=new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()
                            +" has put the data of :"+data);
                    new A().get();
                    new B().get();
                }
            }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                data = new Random().nextInt();
                System.out.println(Thread.currentThread().getName()
                        + " has put the data of :" + data);
                new A().get();
                new B().get();
            }
        }).start();
//        }
    }
    
    static class A{
        
        public void get(){
            System.out.println("A from "+Thread.currentThread().getName()
                    +" get data:"+data);
        }
    }

    static class B {

        public void get() {
            System.out.println("B from " + Thread.currentThread().getName() 
                    + " get data:" + data);
        }
    }
}
