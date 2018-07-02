public class threadRun{
  public static void main(String[] args) throws InterruptedException {
	 ResourceLock lock = new ResourceLock();

    Thread T1 = new Run("T1", 1, lock);
    T1.start();
    Thread T2 = new Run("T2", 2, lock);
    T2.start();
    Thread T3 = new Run("T3", 3, lock);
    T3.start();
  }
}
