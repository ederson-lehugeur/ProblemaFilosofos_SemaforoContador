package main;

import java.util.concurrent.Semaphore;

public class Hashis {
	private int quantidadeDeHashis;
	Semaphore[] hashis;
	Semaphore filosofos;

	public Hashis(int quantidadeDeHashis) {
		this.quantidadeDeHashis = quantidadeDeHashis;
		this.filosofos = new Semaphore(quantidadeDeHashis - 1);
		this.hashis = new Semaphore[quantidadeDeHashis];
		for (int i = 0; i < quantidadeDeHashis; i++)
			hashis[i] = new Semaphore(1);
	}

	public void pegarHashi(int idFilosofo) throws InterruptedException {
		int esquerda = idFilosofo;
		int direita = (idFilosofo + 1) % quantidadeDeHashis;

		filosofos.acquire();

		hashis[esquerda].acquire();
		hashis[direita].acquire();
	}

	public void liberarHashi(int idFilosofo) {
		int esquerda = idFilosofo;
		int direita = (idFilosofo + 1) % quantidadeDeHashis;

		hashis[esquerda].release();
		hashis[direita].release();

		filosofos.release();
	}
}
