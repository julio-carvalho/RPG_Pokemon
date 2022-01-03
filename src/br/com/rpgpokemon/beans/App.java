package br.com.rpgpokemon.beans;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Dados player = new Dados(null, null);
		Jogo jogo = new Jogo(player);
		
		char continuar = 's';
		
		System.out.println("Olá, bem vindo ao jogo de RPG do Pokemon");
		
		//Leitura nome do jogador
		System.out.println("Digite seu nome para começar a jogar: ");
		player.setNomeUser(scan.next());
		
		//Leitura do pokemon
		System.out.println("\nAgora digite qual é o seu pokemon: ");
		player.setNomePokemon(scan.next());
		

		
		//System.out.println("\nNome: " + player.getNomeUser() + "\nPokemon: " + player.getNomePokemon() );
		//jogo.impressaoHp(0, 0);
	
		while(continuar == 's') {
			int pontos = Jogo.combate();
			
			System.out.println("\nSeu Pokemon foi derrotado!");
			System.out.println("Recorde: " + pontos);
			System.out.println("Deseja continuar? (s/n)");
			continuar = scan.next().charAt(0);
		}
	}
}
