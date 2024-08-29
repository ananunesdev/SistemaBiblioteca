package br.com.sistemabiblioteca.crud;

import java.sql.Connection;

import br.com.sistemabiblioteca.jdbc.ConnectionFactory;
import br.com.sistemabiblioteca.model.Biblioteca;

public class CrudBiblioteca {
	//method to create a new book
	public static void create() {
		try {
			//Import connection class with database
			Connection conexao = ConnectionFactory.createConnection();
			
			//Import transition data class database
			Biblioteca biblioteca = new Biblioteca();
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			
		}
		
	}
	
	//method to read all the books
	public static void read() {
		System.out.println("READ");
	}
	
	//method to read one book
	public static void readone() {
		System.out.println("READ ONE");
	}
	
	//method to update the book
		public static void update() {
			System.out.println("UPDATE");
		}
	
	//method to delete the book
	public static void delete() {
		System.out.println("DELETE");
	}
	
	
}