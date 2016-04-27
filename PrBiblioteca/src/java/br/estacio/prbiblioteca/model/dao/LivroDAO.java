/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prbiblioteca.model.dao;

import static br.estacio.prbiblioteca.model.dao.DAO.conn;
import br.estacio.prbiblioteca.model.entity.Livro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vermieiro
 */
public class LivroDAO extends DAO{
    private AutorDAO daoAutor = new AutorDAO ();
    private GeneroDAO daoGenero = new GeneroDAO ();
        
    public void insert (Livro livro){
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "insert into livro (titulo,descricao,anolancamento,idautor,idgenero)values(?, ?, ?, ?, ?)");
      pstmt.setString(1, livro.getTitulo());
      pstmt.setString(2, livro.getDescricao());
      pstmt.setInt(3, livro.getAnoLancamento());
      pstmt.setInt(4, livro.getAutor().getId());
      pstmt.setInt(5, livro.getGenero().getId());
      pstmt.executeUpdate();
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    
    public void update (Livro livro){
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "update livro set titulo = ?, descricao = ?, anolancamento = ?, idautor = ?, idgenero = ? where isbn = ?");
      pstmt.setString(1, livro.getTitulo());
      pstmt.setString(2, livro.getDescricao());
      pstmt.setInt(3, livro.getAnoLancamento());
      pstmt.setInt(4, livro.getAutor().getId());
      pstmt.setInt(5, livro.getGenero().getId());
      pstmt.setInt(6, livro.getIsbn());
      pstmt.executeUpdate();
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    
    public void delete (int isbn){
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "delete from  livro where isbn = ?");
      pstmt.setInt(1,isbn);
      pstmt.executeUpdate();
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    
    public Livro getByIsbn (int isbn){
        Livro livro = null;
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "select * from  livro where isbn = ?");
      pstmt.setInt(1,isbn);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()){
          livro = getLivro(rs);
      }
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return livro;
  }

   private Livro getLivro(ResultSet rs) {
    Livro livro = null;
    try {
      livro = new Livro();
      livro.setIsbn(rs.getInt("isbn"));
      livro.setTitulo(rs.getString("titulo"));
      livro.setDescricao(rs.getString("descricao"));
      livro.setAnoLancamento(rs.getInt("anoLancamento"));
      livro.setAutor(daoAutor.getById(rs.getInt("idAutor")));
      livro.setGenero(daoGenero.getById(rs.getInt("idGenero")));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return livro;
  }

  public List<Livro> getByTitulo(String titulo) {
    List<Livro> livros = new ArrayList<Livro>();
    Livro livro = null;
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "select * from livro where upper(titulo) like upper(%?%) "
        + "order by titulo");
      pstmt.setString(1, titulo);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        livro = getLivro(rs);
        livros.add(livro);
      }
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return livros;
  }

  public List<Livro> list() {
    List<Livro> livros = new ArrayList<Livro>();
    Livro livro = null;
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "select * from livro order by livro");
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        livro = getLivro(rs);
        livros.add(livro);
      }
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return livros;
  }
    
}
