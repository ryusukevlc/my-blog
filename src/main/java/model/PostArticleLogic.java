package model;

import dao.ArticlesDAO;

public class PostArticleLogic {
    
    public void addArticle(Article article) {
        ArticlesDAO articleDAO = new ArticlesDAO();
        articleDAO.addArticle(article);
        
    }

}
