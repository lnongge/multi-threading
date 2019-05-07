package day07_multithreadsharedata;

/**
 * @Description: 多个线程共享变量演示二: 方式一(2个Runable对象,一个共享数据对象)
 * 面试题(见word)4个线程2个对j--,2个对j++
 * @Author: lianws
 * @Date: 2019/5/7 7:59
 */
public class MultiThreadShareData2 {

    public static void main(String[] args) {
        ShareData2 data2 = new ShareData2();
        new Thread(new MyRunable1(data2)).start();
        new Thread(new MyRunable2(data2)).start();
    }

}

class MyRunable1 implements Runnable {
    private ShareData2 data;

    public MyRunable1(ShareData2 data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.increment();
    }
}
class MyRunable2 implements Runnable {
    private ShareData2 data;

    public MyRunable2(ShareData2 data) {
        this.data = data;
    }
    @Override
    public void run() {
        data.decrement();
    }
}

class ShareData2 {
    private int j = 0;
    public synchronized void increment() {
        j++;
    }
    public synchronized void decrement() {
        j--;
    }

}