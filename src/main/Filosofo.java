package main;

public class Filosofo extends Thread {
	private int idFilosofo;
	private int vezesPensando;
	private int vezesComendo;
	private Hashis hashis;

	public Filosofo(int idFilosofo, Hashis hashis) {
		this.vezesPensando = 0;
		this.vezesComendo = 0;
		this.idFilosofo = idFilosofo;
		this.hashis = hashis;
	}

	public void pensar() throws InterruptedException {
		System.out.println("Filosofo #" + idFilosofo + " Pensando pela " + (++vezesPensando) + "ª vez...");
		Thread.sleep((long)(Math.random() * 1000));
	}

	public void comer() throws InterruptedException {
		System.out.println("Filosofo #" + idFilosofo + " Comendo pela " + (++vezesComendo) + "ª vez...");
		Thread.sleep((long)(Math.random() * 1000));
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				pensar();

				hashis.pegarHashi(idFilosofo);

				comer();

				hashis.liberarHashi(idFilosofo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
