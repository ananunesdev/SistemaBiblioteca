package br.com.sistemabiblioteca.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			String[] generos = {
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
			};
			
			String generoSelecionado = (String)JOptionPane.showInputDialog(null, "Selecione o gênero do livro: ", "Escolha de Gênero: ", JOptionPane.QUESTION_MESSAGE, null, generos, generos[0]);
			//library.setGenre
			
			biblioteca.setGenero(generoSelecionado);
			
			String sql = "INSERT INTO livros(titulo, autor, ano_publicacao, isbn, editora, genero) VALUES (?,?,?,?,?,?);";
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, biblioteca.getTitulo());
			cmd.setString(2, biblioteca.getAutor());
			cmd.setInt(3, biblioteca.getAno_publicacao());
			cmd.setString(4, biblioteca.getIsbn());
			cmd.setString(5, biblioteca.getEditora());
			cmd.setString(6, biblioteca.getGenero());
			
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Livro inserido com sucesso!");
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	//method to read all the books
	public static void read() {
		try {
		
			Connection conexao = ConnectionFactory.createConnection();
			
			Biblioteca biblioteca = new Biblioteca();
			
			String sql = "select * from livros;";
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			ResultSet resultado = cmd.executeQuery();
			
			String livros;
			
			livros = "<< Livros encontrados >>\n\n";
			
			while(resultado.next()) {
				livros += "ID: " + resultado.getInt("id") 
						+ "- ISBN: " + resultado.getString("isbn") 
						+ "- Título: " + resultado.getString("titulo") 
						+ "- Autor: " + resultado.getString("autor") 
						+ "\n ----------------------------------------\n"; 
			}
			JOptionPane.showMessageDialog(null, livros);
			cmd.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//method to read one book
	public static void readone() {
		try {
			
			Connection conexao = ConnectionFactory.createConnection();
			
			Biblioteca biblioteca = new Biblioteca();
			
			biblioteca.setIsbn(JOptionPane.showInputDialog("Entre com o ISBN"));
			
			
			String sql = "select * from livros where isbn = ?;";
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, biblioteca.getIsbn());
			ResultSet resultado = cmd.executeQuery();
			
			String livros;
			
			livros = ".:: Livros encontrados ::.\n\n";
			
			while(resultado.next()) {
				livros += "ID: " + resultado.getInt("id") + "\n"
						+ " ISBN: " + resultado.getString("isbn") + "\n"
						+ "\n"
						+ " Título: " + resultado.getString("titulo") + "\n"
						+ " Autor: " + resultado.getString("autor") + "\n"
						+ " Ano de publicação: " + resultado.getInt("ano_publicacao") + "\n"
						+ " ----------------------------------------\n"
						+ " Editora: " + resultado.getString("editora") + "\n"
						+ " Gênero: " + resultado.getString("genero") + "\n"
						+ " ----------------------------------------\n"; 
			}
			JOptionPane.showMessageDialog(null, livros);
			cmd.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method to update the book
	public static void update() {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			Biblioteca biblioteca = new Biblioteca();
			
			biblioteca.setTitulo (JOptionPane.showInputDialog("Insira o título do livro: "));
			biblioteca.setAutor(JOptionPane.showInputDialog("Insira o autor do livro: "));
			biblioteca.setAno_publicacao(Integer.parseInt(JOptionPane.showInputDialog("Insira o ano de publicação do livro: ")));
			biblioteca.setIsbn(JOptionPane.showInputDialog("Insira o ISBN do livro: "));
			biblioteca.setEditora(JOptionPane.showInputDialog("Insira a editora do livro: "));
			String[] generos = {
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
			};
			
			String generoSelecionado = (String)JOptionPane.showInputDialog(null, "Selecione o gênero do livro: ", "Escolha de Gênero: ", JOptionPane.QUESTION_MESSAGE, null, generos, generos[0]);
			//library.setGenre
			
			biblioteca.setGenero(generoSelecionado);
			
			String sql = "UPDATE livros SET titulo=?, autor=?, ano_publicacao=?, editora=?, genero=? WHERE isbn=?;";
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			cmd.setString(1, biblioteca.getTitulo());
			cmd.setString(2, biblioteca.getAutor());
			cmd.setInt(3, biblioteca.getAno_publicacao());
			cmd.setString(5, biblioteca.getEditora());
			cmd.setString(6, biblioteca.getGenero());
			cmd.setString(4, biblioteca.getIsbn());
			
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Livro inserido com sucesso!");
			cmd.close();
			
			
		} catch (Exception e) {
			
			
		}


	}
	
	//method to delete the book
	public static void delete() {
		try {
			//open connection
			Connection conexao = ConnectionFactory.createConnection();
			Biblioteca biblioteca = new Biblioteca();
			
			biblioteca.setIsbn(JOptionPane.showInputDialog(
					"Insira o ISBN do livro: "));
			
			String sql = "delete from livros where isbn = ?;";
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, biblioteca.getIsbn());
			cmd.execute();
			
			JOptionPane.showMessageDialog(null, "Registro deletado com sucesso!");
			cmd.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}