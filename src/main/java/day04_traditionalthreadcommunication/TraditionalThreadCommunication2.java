package day04_traditionalthreadcommunication;

/**
 * @Description: zxx面试题28
 * @Author: lianws
 * @Date: 2019/4/19 7:43
 */
public class TraditionalThreadCommunication2 {

    public static void main(String[] args) {
        final Business business=new Business();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                   business.sub(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.main(i);
                }
                
            }
        }).start();
    } 
    
}
class Business{
    private boolean bShouldSub=true; //是否该子线程标志 true 是 
    public synchronized void sub(int i){
        while(!bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < 10; j++) {
            System.out.println("sub thread of "+j+",loop of "+i);
        }
        bShouldSub=false;
        this.notify();
    }

    public synchronized void main(int i)  {
        while(bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < 100; j++) {
            System.out.println("main thread of "+j+",loop of "+i);
        }
        bShouldSub=true;
        this.notify();
    }
}
