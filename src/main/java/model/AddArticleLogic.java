package model;

import dao.ArticlesDAO;

public class AddArticleLogic {
	
	public void addArticle(Article article) {
		ArticlesDAO articleDAO = new ArticlesDAO();
		articleDAO.addArticle(article);
		
	}

}
