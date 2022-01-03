package br.com.rpgpokemon.beans;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
	static Dados player;
	
	public Jogo(Dados player) {
		Jogo.player = player;
	}
	
	public static int ataquePlayer() {
		Scanner scan = new Scanner(System.in);
		int escolha  = 0;
		System.out.println("Escolha seu ataque: \n1 - Soco\n2 - Ataque Especial");
		escolha = scan.nextInt();
		
		while(escolha != 1 && escolha != 2) {
			System.out.println("Opção inválida, escolha novamente o ataque: \n1 - Soco\n2 - Ataque Especial");
			escolha = scan.nextInt();
		}
		return escolha;
	}
	
	public static int ataqueComputador() {
		Random generate = new Random();
		return generate.nextInt(3)+1;
	}
	
	
	public static void impressaoHp(int hpPlayer, int hpComputador, String cpu, int contEspecial) {
		System.out.println("-------------------------");
		System.out.println("- HP " + player.getNomePokemon() + ": " + hpPlayer);
		System.out.println("- HP " + cpu + ": " + hpComputador);
		System.out.println("* Contagem Especiais: " + contEspecial);
		System.out.println("-------------------------");
	}
	
	public static int combate() {
		int hpPlayer = 150;
		int hpComputador = 11;
		int contEspecial = 5;
		int escolhaAtaque;
		int cont = 1;
		
		while(hpPlayer > 0) {
			String cpu = nomeCPU();
			hpComputador = 10 + cont;
			
			System.out.println("\n=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("INIMIGO: " + cpu);
			System.out.println("NÍVEL: " + cont);
			System.out.println("=-=-=-=-=-=-=-=-=-=-=");
			
			while(hpPlayer > 0 && hpComputador > 0) {
				
				impressaoHp(hpPlayer, hpComputador, cpu, contEspecial);
				
				escolhaAtaque = ataquePlayer();
				
				if(escolhaAtaque == 2) {
					if(contEspecial > 0) {
						escolhaAtaque = 2;
					}
					else {	
						boolean aux = true;
						while(aux) {
							System.out.println("\nVocê não possui mais ataques especiais");
							escolhaAtaque = ataquePlayer();
							if(escolhaAtaque == 1) {
								aux = false;
							}
						}
						
					}
				}
				switch(escolhaAtaque) {
					case 1:
						System.out.println("\n" + player.getNomePokemon() + " aplicou um soco em " + cpu + ".");
						hpComputador -= 7;
						break;
					case 2:
						System.out.println("\n" + player.getNomePokemon() + " aplicou um ataque especial em " + cpu + ".");
						hpComputador -= 20;
						contEspecial--;
					break;
					default:
						System.out.println("\nOpção inválida.");
					break;
				}
				if(hpComputador > 0) {
					escolhaAtaque = ataqueComputador();
					switch(escolhaAtaque) {
						case 1:
							System.out.println(cpu + " aplicou um soco em " + player.getNomePokemon() + ".");
							hpPlayer -= 2 + (int)(cont / 10);
						break;
						case 2:
							System.out.println(cpu + " aplicou um chute em " + player.getNomePokemon() + ".");
							hpPlayer -= 3 + (int)(cont / 10);
						break;
						case 3:
							System.out.println(cpu + " aplicou um ataque especial em " + player.getNomePokemon() + ".");
							hpPlayer -= 4 + (int)(cont / 20);
						break;
					}
				} else {
					System.out.println("Inimigo derrotado.");
				}
			}
			if (hpPlayer > 0) {
				hpPlayer += 5;
					if (hpPlayer > 150) {
						hpPlayer = 150;
					}
					if (cont % 10 == 0) {
						contEspecial++;
						if (contEspecial > 5) {
							contEspecial = 5;
						}
					}
				}
			
			cont++;
		}
		
		return cont;
	}
	
	public static String nomeCPU() {
		Random generate = new Random();
		String[] vetNomes = {"Zubat", "Pikachu", "Paras", "Psyduck", "Machop", "Onix", "Hitmonlee", "Jynx", "Tauros", "Magikarp", "Ditto", "Bulbasaur", "Charmander", "Squirtle", "Blastoise", "Caterpie", "Butterfree"};
		
		int num = generate.nextInt(vetNomes.length);
		String cpu = " ";

		
		cpu = vetNomes[num];
		return cpu;
	}
	

}
