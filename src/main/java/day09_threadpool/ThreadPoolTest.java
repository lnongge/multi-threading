package day09_threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 线程池demo
 * @Author: lianws
 * @Date: 2019/5/9 22:28
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //1.创建10个任务(就是Runable),1个任务执行10次 (分别用3中线程池运行,观察结果区别)
//        ExecutorService executorService = Executors.newFixedThreadPool(3); //固定大小线程池
//        ExecutorService executorService = Executors.newCachedThreadPool(); // 缓存线程池(无大小限制)
        ExecutorService executorService = Executors.newSingleThreadExecutor(); //单线程线程池(池中只有一个线程)
        for (int i = 1; i <= 10; i++) {
            final int task = i;//task是当前是第几个任务
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 10; j++) {// j是当前任务执行的第几次
                        System.out.println(Thread.currentThread().getName() + " is loop of " + j + " for task of " + task);
                    }
                }
            });
        }
        System.out.println("all of 10 task has commited!");
        executorService.shutdown(); //关闭线程池

        // 2.定时线程池演示
        //(1)创建一个定时线程,10s后执行任务
        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("bomb....!");
            }
        }, 10, TimeUnit.SECONDS);
        
        //(2)创建一个定时线程,6s后执行任务,之后每个2s重复执行
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("bomb...!");
            }
        },6,2,TimeUnit.SECONDS);
    }
}