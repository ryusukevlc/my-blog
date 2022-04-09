package dao;

import java.util.ArrayList;

import model.article.Article;

public class ArticlesDAOTest {
	
	public static void main(String[] args) {
		
		getAllTest();
//		addArticleTest();
		
	}
	
	private static void getAllTest() {
		ArticlesDAO articlesDAO = new ArticlesDAO();
		ArrayList<Article> articles = articlesDAO.getAll();
		
		for (Article article : articles) {
			System.out.println(article.getTitle());
			System.out.println(article.getContent());
			System.out.println(article.getCreated_at());
			System.out.println(article.getUpdated_at());
		}
	}
	
	private static void addArticleTest() {
		ArticlesDAO articlesDAO = new ArticlesDAO();
//		articlesDAO.addArticle(article);
	}

}
