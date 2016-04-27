/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prbiblioteca.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Vermieiro
 */
public class DAO {
    
  private static final String driver = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://localhost/biblioteca";
  private static final String usuario = "postgres";
  private static final String senha = "estacio@123";
  protected static Connection conn = null;

  static {
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(URL, usuario, senha);
      System.out.println("******** conectando com o BD ********");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
