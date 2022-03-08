package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Article;

public class ArticlesDAO {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/arata_blog";
	private static final String USER = "ryusuke_arata";
	private static final String PASSWORD = "ryusuke_arata";
	
	private static Connection getConnection() {
	
		try {
			
			//DBコネクションの取得
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			return con;
			
		} catch(Exception e) {
			
			System.out.println("DB接続時に例外が発生しました！");
			throw new IllegalStateException(e);
			
		}
	}
	
	
	public ArrayList<Article> getAll() {
		
		Connection con = null;
		Statement stmt = null;
		
		//返却値の初期化
		ArrayList<Article> articles = new ArrayList<>();
		
		String sql = "SELECT * FROM articles";
		
		try {
			
			//DB接続
			con = ArticlesDAO.getConnection();
			stmt = con.createStatement();
			
			//SQL文の発行
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Article article = new Article();
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setCreated_at(rs.getDate("created_at"));
				article.setUpdated_at(rs.getDate("updated_at"));
				articles.add(article);
			}
			
		} catch (Exception e) {
			
			System.out.println(e);
			System.out.println("selectAll()で例外が発生しました！");
			
		} finally {
			
			//リソースの開放
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("ステートメントのクローズに失敗しました！");
				}
			}
			if (con != null) {
				try {					
					con.close();
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("コネクションのクローズに失敗しました！");
				}
			}
			
		}
		
		return articles;
		
	}
	
}
