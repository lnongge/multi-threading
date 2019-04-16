package day01_traditionalthread;

/**
 * @Description:
 * @Author: lianws
 * @Date: 2019/4/16 20:05
 */
public class TraditionalThread {

    public static void main(String[] args) throws Exception {

        // 创建线程方法一:
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("1:" + Thread.currentThread().getName());
                        System.out.println("1:" + this.getName());
                        /** 上面2句是等价的,但不推荐用this因为this不具有普适性(见方法二)
                         * Q: this代表谁?
                         * A: 代表run()方法所在的类的对象(即Thread类的对象)
                         */
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();

        // 创建线程二:
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("2:" + Thread.currentThread().getName());
//                        System.out.println("1:"+this.getName());
                        /**
                         * 这里就不能用this了,因为this代表runnable类的对象,显然它不是线程,没有getName()
                         */
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();

        // 问:下面代码运行那个run()?
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("run:" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }) {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("thread:" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }.start();
    }
}
