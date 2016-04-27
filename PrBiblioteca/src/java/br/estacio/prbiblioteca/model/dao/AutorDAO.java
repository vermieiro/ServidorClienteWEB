package br.estacio.prbiblioteca.model.dao;

import br.estacio.prbiblioteca.model.entity.Autor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO extends DAO{
        
    public void insert (Autor autor){
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "insert into autor (nome, email)values(?, ?)");
      pstmt.setString(1, autor.getNome());
      pstmt.setString(2, autor.getEmail());
      pstmt.executeUpdate();
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    
    public void update (Autor autor){
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "update autor set nome = ?, email = ? where id = ?");
      pstmt.setString(1, autor.getNome());
      pstmt.setString(2, autor.getEmail());
      pstmt.setInt(3, autor.getId());
      pstmt.executeUpdate();
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    
    public void delete (int id){
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "delete from  autor where id = ?");
      pstmt.setInt(1,id);
      pstmt.executeUpdate();
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    
    public Autor getById (int id){
        Autor autor = null;
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "select * from  autor where id = ?");
      pstmt.setInt(1,id);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()){
          autor = getAutor(rs);
      }
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return autor;
  }

   private Autor getAutor(ResultSet rs) {
    Autor autor = null;
    try {
      autor = new Autor();
      autor.setId(rs.getInt("id"));
      autor.setNome(rs.getString("nome"));
      autor.setEmail(rs.getString("email"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return autor;
  }

  public List<Autor> getByNome(String nome) {
    List<Autor> autores = new ArrayList<Autor>();
    Autor autor = null;
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "select * from autor where upper(nome) like upper(%?%) "
        + "order by nome");
      pstmt.setString(1, nome);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        autor = getAutor(rs);
        autores.add(autor);
      }
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return autores;
  }

  public List<Autor> list() {
    List<Autor> autores = new ArrayList<Autor>();
    Autor autor = null;
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "select * from autor order by nome");
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        autor = getAutor(rs);
        autores.add(autor);
      }
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return autores;
  }
}
