package model.article;

import java.util.ArrayList;

import dao.ArticlesDAO;

public class GetArticlesLogic {

    
    /**
     * getArticles
     * テーブルに登録されている記事を全て取得する
     * @return
     */
	public ArrayList<Article> getArticles() {
		
		//articlesの取得
		ArticlesDAO articlesDAO = new ArticlesDAO();
		ArrayList<Article> articles = articlesDAO.getAll();
		
		return articles;
	}
	
	/**
	 * getOneOfArticles
	 * idをキーに記事を取得する
	 * @param id
	 * @return
	 */
	public Article getOneOfArticles(int id) {
	    
	    //articleを取得する
	    ArticlesDAO articlesDAO = new ArticlesDAO();
	    Article article = articlesDAO.getOne(id);
	    
	    return article;
	}
}
