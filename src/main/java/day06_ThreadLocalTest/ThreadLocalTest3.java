package day06_ThreadLocalTest;

import java.util.Random;

/**
 * @Description: ThreadLocal演示二: 有多个变量存到ThreadLocal (优雅的代码演示)
 * @Author: lianws
 * @Date: 2019/4/28 21:53
 */
public class ThreadLocalTest3 {
    // 1.创建ThreadLocal
    private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    threadLocal.set(data);// 2.存值
                    System.out.println(Thread.currentThread().getName()+" has put data:"+data);
                    MyThreadScopeData2.getInstance().setName("name"+data);
                    MyThreadScopeData2.getInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {// 3.取值
            System.out.println("A from " + Thread.currentThread().getName() + " has get data:"
                    + threadLocal.get());
            MyThreadScopeData2 mts=MyThreadScopeData2.getInstance();
            System.out.println("A from "+Thread.currentThread().getName()+" has get mts:"+mts.getName()
                    +",age"+mts.getAge());
        }
    }

    static class B {
        public void get() {// 3.取值
            System.out.println("B from " + Thread.currentThread().getName() + " has get data:"
                    + threadLocal.get());
            MyThreadScopeData2 mts=MyThreadScopeData2.getInstance();
            System.out.println("B from "+Thread.currentThread().getName()+" has get mts:"+mts.getName()
                    +",age"+mts.getAge());
        }
    }
}

class MyThreadScopeData2{
    private MyThreadScopeData2(){};
    private static ThreadLocal<MyThreadScopeData2> threadLocal=new ThreadLocal<>();
    public static /*synchronized*/ MyThreadScopeData2 getInstance(){
        MyThreadScopeData2 instance=threadLocal.get();
        if(instance==null){
            instance=new MyThreadScopeData2();
            threadLocal.set(instance);
        }
        return instance;
    }
    
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
