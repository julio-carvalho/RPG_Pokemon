package br.com.rpgpokemon.beans;

public class Dados {
	String nomeUser;
	String nomePokemon;
	
	public Dados(String nomeUser, String nomePokemon) {
		super();
		this.nomeUser = nomeUser;
		this.nomePokemon = nomePokemon;
	}
	
	public String getNomeUser() {
		return nomeUser;
	}
	
	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}
	
	public String getNomePokemon() {
		return nomePokemon;
	}
	
	public void setNomePokemon(String nomePokemon) {
		this.nomePokemon = nomePokemon;
	}
	
	
}
