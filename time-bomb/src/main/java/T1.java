public class T1 implements Runnable{

	protected static Integer counter = 0;

	public static void main(String[] args) throws InterruptedException {
		T1 t = new T1();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
	}

	public static void boom(){
		System.out.println("\nboom...");
	}

	public void increment(){
		T1.counter++;
		System.out.print(" "+ T1.counter);
	}
	
	@Override
	public void run() {
		synchronized(this){
			increment();
			increment();
			increment();
		}
	}

}
