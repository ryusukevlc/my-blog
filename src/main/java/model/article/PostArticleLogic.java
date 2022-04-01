package model.article;

import dao.ArticlesDAO;

public class PostArticleLogic {
    
    /**
     * addArticle
     * 記事をテーブルに登録する
     * @param article
     */
    public void addArticle(Article article) {
        ArticlesDAO articleDAO = new ArticlesDAO();
        articleDAO.add(article);
    }
    
    
    /**
     * deleteArticle
     * idをキーに記事を削除する
     * @param id
     * @return
     */
    public boolean deleteArticle(int id) {
        ArticlesDAO articlesDAO = new ArticlesDAO();
        boolean isDeleted = articlesDAO.deleteOne(id);
        
        return isDeleted;
    }
    
    
    /**
     * updateArticle
     * 記事を更新する
     * @param article
     * @param id
     */
    public boolean updateArticle(Article article, int id) {
        
        ArticlesDAO articlesDAO = new ArticlesDAO();
        boolean isUpdated = articlesDAO.update(article, id);
        
        return isUpdated;
        
    }

}
