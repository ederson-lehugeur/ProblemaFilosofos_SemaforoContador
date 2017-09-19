package main;

public class Main {
	public static void main(String[] args) {
		Hashis hashis = new Hashis(5);
		Filosofo filosofo0 = new Filosofo(0, hashis);
		Filosofo filosofo1 = new Filosofo(1, hashis);
		Filosofo filosofo2 = new Filosofo(2, hashis);
		Filosofo filosofo3 = new Filosofo(3, hashis);
		Filosofo filosofo4 = new Filosofo(4, hashis);

		filosofo0.start();
		filosofo1.start();
		filosofo2.start();
		filosofo3.start();
		filosofo4.start();
	}
}
