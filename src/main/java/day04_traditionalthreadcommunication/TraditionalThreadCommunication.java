package day04_traditionalthreadcommunication;

/**
 * @Description: zxx面试题28
 * @Author: lianws
 * @Date: 2019/4/19 7:43
 */
public class TraditionalThreadCommunication {

    public static void main(String[] args) {
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    synchronized (TraditionalThreadCommunication.class){
                        for (int j = 0; j < 10; j++) {
                            System.out.println("sub thread of "+j+",loop of "+i);
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    synchronized (TraditionalThreadCommunication.class){
                        for (int j = 0; j < 100; j++) {
                            System.out.println("main thread of "+j+",loop of "+i);
                        }
                    }
                }
                
            }
        }).start();
    }
    /**
     * 上述代码能实现互斥(子线程执行时主线程不干扰,反之亦是),但不是你一下,我一下即线程间没通信
     */
}
