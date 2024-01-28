class Hello extends Thread {
	public void run() {
		System.out.println("Hello_World");
	}
}
public class hello_world {
	public static void main(String[] args) {
		Hello obj = new Hello();
		obj.start();
	}
}
