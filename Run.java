public class Run extends Thread {
  //private Thread t;
  private String threadName;
  private int initial;
  ResourceLock lock;
  public Run(String name, int init, ResourceLock lock){
    threadName = name;
    initial = init;
    this.lock = lock;
    System.out.println("Creating "+name);
  }

  public void run() {
      try {
//        for(int i = initial; i < 100; i = i +3){
//            System.out.println(threadName + ": " + i);
//            Thread.sleep(50);}

        synchronized (lock) {

            for (int i = initial; i < 100; i = i +3) {

                while(lock.flag != initial){
                    lock.wait();
                }
                System.out.println(threadName + ": " + i);
                Thread.sleep(50);
                if(lock.flag == 3){
                lock.flag =  1;}
                else{
                	lock.flag = initial + 1;
                }
                lock.notifyAll();
            }
         }
        }
       catch (InterruptedException e) {
         System.out.println(threadName + " interrupted");
      }
      System.out.println(threadName + " over");
   }

//  public void start(String threadName){
//    System.out.println("Start "+threadName);
//    if(t == null){
//      t = new Thread(threadName);
//      t.start();
//    }
//  }
}
