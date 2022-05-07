package controller.admin.articleManagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.article.Article;
import model.article.ArticleProcessing;
import model.article.GetArticlesLogic;
import model.article.PostArticleLogic;


/**
 * 記事管理画面のController
 * @author ryusuke_arata
 *
 */
@WebServlet("/admin/articleManagement/articles")
public class ArticlesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ArticlesController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    		//articleの取得
    		GetArticlesLogic getArticlesLogic = new GetArticlesLogic();
    		List<Article> articles = getArticlesLogic.getArticles();
    		
    		//値チェック
    		if (articles != null && articles.size() > 0) {
    			
		        //「内容」の文字数を45文字以内に調整、「タイトル」を10文字に調整
		        ArticleProcessing articleProcessing = new ArticleProcessing();
		        articleProcessing.reduceTheWord(articles, 10, 45);
    			
    			//リクエストスコープに登録
    			request.setAttribute("articles", articles);
    		}
    		
    		//記事管理画面に遷移
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/articles.jsp");
    		dispatcher.forward(request, response);
    	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    request.setCharacterEncoding("UTF-8");
		
	    String type = request.getParameter("type");
	    
	    if ("delete".equals(type)) {
	        //削除の場合
	        
	        //idの取得
	        int id = Integer.parseInt(request.getParameter("id"));
	        
	        //削除処理
	        PostArticleLogic postArticleLogic = new PostArticleLogic();
	        boolean isDeleted = postArticleLogic.deleteArticle(id);
	        
	        if (isDeleted) {
	            //削除できた場合
	            
	            //記事管理画面表示用に全記事を取得する
	            GetArticlesLogic getArticlesLogic = new GetArticlesLogic();
	            List<Article> articles = getArticlesLogic.getArticles();
	            
		        //「内容」の文字数を45文字以内に調整、「タイトル」を10文字に調整
		        ArticleProcessing articleProcessing = new ArticleProcessing();
		        articleProcessing.reduceTheWord(articles, 10, 45);
		        
	            
	            //全記事をリクエストスコープにセットする
	            request.setAttribute("articles", articles);
	            
	            //記事管理画面を再描画
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/articles.jsp");
	            requestDispatcher.forward(request, response);
	            
	        } else {
	            //削除出来なかった場合
	            System.out.println("記事を削除できませんでした。");
	        }
	        

	        
	    } else {
	        
	    }
		
		
		
	}

}
