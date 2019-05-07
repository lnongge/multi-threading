package day07_multithreadsharedata;

/**
 * @Description: 多个线程共享变量演示一: 卖票
 *  一个线程就是一个卖票窗口,每个窗口干的活都一样是卖票
 *  如何解决线程安全问题? 待解决
 * @Author: lianws
 * @Date: 2019/5/7 7:59
 */
public class MultiThreadShareData {

    public static void main(String[] args) {
        ShareData shareData=new ShareData();
        new Thread(shareData).start();
        new Thread(shareData).start();
    }
    
}

class ShareData implements Runnable{
    private int count=100; //初始1000张票
    @Override
    public  void run() {
        while(count>0){
            count--;
            System.out.println(Thread.currentThread().getName()+"卖出一张票,余票:"+count);
        }
        System.out.println(Thread.currentThread().getName()+"窗口的票卖光了...");
    }
}