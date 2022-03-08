package model;

import java.util.ArrayList;

import dao.ArticlesDAO;

public class GetArticlesLogic {

	public ArrayList<Article> getArticles() {
		
		//articlesの取得
		ArticlesDAO articlesDAO = new ArticlesDAO();
		ArrayList<Article> articles = articlesDAO.getAll();
		
		return articles;
	}
}
