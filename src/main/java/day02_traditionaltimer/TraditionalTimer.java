package day02_traditionaltimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description: 传统定时器
 * @Author: lianws
 * @Date: 2019/4/17 7:19
 */
public class TraditionalTimer {
    
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!");
            }
        },10000,3000);
        // 打印当前是多少秒
//        while (true){
//            System.out.println(new Date().getSeconds());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
