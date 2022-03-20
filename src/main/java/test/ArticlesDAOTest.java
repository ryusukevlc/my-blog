package test;

import java.util.ArrayList;

import dao.ArticlesDAO;
import model.Article;

public class ArticlesDAOTest {
	
	public static void main(String[] args) {
		
//		getAllTest();
		addArticleTest();
		
	}
	
	public static void getAllTest() {
		ArticlesDAO articlesDAO = new ArticlesDAO();
		ArrayList<Article> articles = articlesDAO.getAll();
		
		for (Article article : articles) {
			System.out.println(article.getTitle());
			System.out.println(article.getContent());
			System.out.println(article.getCreated_at());
			System.out.println(article.getUpdated_at());
		}
	}
	
	public static void addArticleTest() {
		ArticlesDAO articlesDAO = new ArticlesDAO();
//		articlesDAO.addArticle(article);
	}

}
