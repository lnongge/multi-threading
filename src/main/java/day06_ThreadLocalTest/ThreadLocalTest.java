package day06_ThreadLocalTest;

import java.util.Random;

/**
 * @Description: ThreadLocal演示一: 只有一个变量能存到
 * @Author: lianws
 * @Date: 2019/4/28 21:53
 */
public class ThreadLocalTest {
    // 1.创建ThreadLocal
    private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    threadLocal.set(data);// 2.存值
                    System.out.println(Thread.currentThread().getName()+"has put data:"+data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }
    
   static class A{
        public void get(){// 3.取值
            System.out.println("A from"+Thread.currentThread().getName()+"has get data:"
                    +threadLocal.get());
        }
    }
    
   static class B{
        public void get(){// 3.取值
            System.out.println("B from"+Thread.currentThread().getName()+"has get data:"
                    +threadLocal.get());
        }
    }
}
