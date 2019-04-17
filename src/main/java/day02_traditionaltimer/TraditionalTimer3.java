package day02_traditionaltimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description: 子母弹(无穷版)
 * @Author: lianws
 * @Date: 2019/4/17 7:50
 */
public class TraditionalTimer3 {
    
    static int count=0;
    
    public static void main(String[] args) {
        count++;
        class MyTimeTask extends TimerTask{
            @Override
            public void run() {
                count=(count+1)%2;
                System.out.println("bombing!");
                new Timer().schedule(new MyTimeTask(),2000+2000*count);
            }
        }
        
        new Timer().schedule(new MyTimeTask(),2000);

        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    
   
}

