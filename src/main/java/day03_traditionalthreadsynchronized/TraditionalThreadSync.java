package day03_traditionalthreadsynchronized;

/**
 * @Description: 传统线程同步
 * @Author: lianws
 * @Date: 2019/4/18 7:29
 */
public class TraditionalThreadSync {
    
    public static void main(String[] args) {
        new TraditionalThreadSync().init();
    }
    
    private void init(){
        final Outter outter=new Outter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    outter.output("zhangxiaoxiang");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    outter.output3("lihuoming");
                }
            }
        }).start();
    }
    
   static class Outter{
        public void output(String name){
            synchronized (Outter.class){
                for (int i = 0; i < name.length(); i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }
        
        public synchronized void output2(String name){
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
            
        }

        public static synchronized void output3(String name) {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();

        }
        
        
    }
}
