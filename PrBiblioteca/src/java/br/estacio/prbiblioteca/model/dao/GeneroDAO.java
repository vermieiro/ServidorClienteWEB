package br.estacio.prbiblioteca.model.dao;

import br.estacio.prbiblioteca.model.entity.Genero;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO extends  DAO{
        
    public void insert (Genero genero){
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "insert into genero (descricao)values(?)");
      pstmt.setString(1, genero.getDescricao());
      pstmt.executeUpdate();
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    
    public void update (Genero genero){
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "update genero set descricao = ? where id = ?");
      pstmt.setString(1, genero.getDescricao());
      pstmt.setInt(2, genero.getId());
      pstmt.executeUpdate();
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    
    public void delete (int id){
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "delete from  genero where id = ?");
      pstmt.setInt(1,id);
      pstmt.executeUpdate();
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    
    public Genero getById (int id){
        Genero genero = null;
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "select * from  genero where id = ?");
      pstmt.setInt(1,id);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()){
          genero = getGenero(rs);
      }
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return genero;
  }

   private Genero getGenero(ResultSet rs) {
    Genero genero = null;
    try {
      genero = new Genero();
      genero.setId(rs.getInt("id"));
      genero.setDescricao(rs.getString("descricao"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return genero;
  }

  public List<Genero> getByDescricao(String descricao) {
    List<Genero> generos = new ArrayList<Genero>();
    Genero genero = null;
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "select * from genero where upper(descricao) like upper(%?%) "
        + "order by descricao");
      pstmt.setString(1, descricao);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        genero = getGenero(rs);
        generos.add(genero);
      }
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return generos;
  }

  public List<Genero> list() {
    List<Genero> generos = new ArrayList<Genero>();
    Genero genero = null;
    try {
      PreparedStatement pstmt = conn.prepareStatement(
        "select * from genero order by descricao");
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        genero = getGenero(rs);
        generos.add(genero);
      }
      pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return generos;
  }
}
