package day07_multithreadsharedata;

/**
 * @Description: 多个线程共享变量演示二: 方式二(Runable作为内部类,共享数据对象作为成员变量)
 * @Author: lianws
 * @Date: 2019/5/7 7:59
 */
public class MultiThreadShareData3 {
    private static ShareData3 data3 = new ShareData3();
    public static void main(String[] args) {
//        共享数据对象不作为成员变量,作为局部变量也可以
//       final ShareData3 data3 = new ShareData3();
        new Thread(new Runnable() {
            @Override
            public void run() {
                data3.increment();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                data3.decrement();
            }
        }).start();
    }

}

class ShareData3 {
    private int j = 0;
    public synchronized void increment() {
        j++;
    }
    public synchronized void decrement() {
        j--;
    }

}