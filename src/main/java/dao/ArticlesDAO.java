package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	/**
	 * getAll()
	 * 記事をすべて取得するメソッド
	 * @return
	 */
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
			System.out.println("getAll()で例外が発生しました！");
			
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
	
	/**
	 * addArticle()
	 * 記事を投稿するメソッド
	 */
	public void addArticle(Article article) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO articles (title, content) VALUES ( ?, ? )";
		
		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, article.getTitle());
			stmt.setString(2, article.getContent());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("insert処理に失敗しました！");
		} finally {
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			
		}
	}
	
}
