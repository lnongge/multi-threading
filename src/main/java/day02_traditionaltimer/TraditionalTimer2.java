package day02_traditionaltimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description: 子母弹(一次性的)
 * @Author: lianws
 * @Date: 2019/4/17 7:37
 */
public class TraditionalTimer2 {
    
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!");
                //炸完之后再创建一个定时器(炸弹)
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("bombing! ");
                    } 
                },2000);
            }
        },2000);
        
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
