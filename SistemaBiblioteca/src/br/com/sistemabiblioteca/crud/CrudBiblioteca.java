package br.com.sistemabiblioteca.crud;

import java.sql.Connection;

import javax.swing.JOptionPane;

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
			
			//send data to class library
			
			biblioteca.setTitulo (JOptionPane.showInputDialog("Insira o título do livro: "));
			biblioteca.setAutor(JOptionPane.showInputDialog("Insira o autor do livro: "));
			biblioteca.setAno_publicacao(Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de publicação do livro: ")));
			biblioteca.setIsbn(JOptionPane.showInputDialog("Insira o ISBN do livro: "));
			biblioteca.setEditora(JOptionPane.showInputDialog("Insira a editora do livro: "));
			biblioteca.setGenero(JOptionPane.showInputDialog("Insira o gênero do livro: "));
			
			String[] genero = {
					"Aventura",
					"Autoajuda",
					"Biografia",
					"Culinária",
					"Didático",
					"Drama",
					"Fantasia",
					"Ficção Científica",
					"História",
					"Infantil",
					"Literatura Clássica",
					"Mistério",
					"Não-Ficção",
					"Outros",
					"Poesia",
					"Romance",
					"Suspense",
					"Terror"
			}
			
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