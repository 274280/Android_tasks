class even_odd_printer {
	public void even_printer() {
		for(int i=0;i<=20;i+=2) {
			System.out.println(i);
		}
	}
	public void odd_printer() {
		for(int i=1;i<=19;i+=2) {
			System.out.println(i);
		}
	}
}
class even_odd {
	public static void main(String[] args) {
		even_odd_printer obj = new even_odd_printer();
		Thread t1 = new Thread(()-> {obj.even_printer();});
		Thread t2 = new Thread(()-> {obj.odd_printer();});

		t1.start();
		t2.start();
	}
}
