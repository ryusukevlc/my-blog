package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Article;
import model.GetArticlesLogic;
import model.PostArticleLogic;
import validator.ArticleValidator;


/**
 * 記事管理画面のController
 * @author ryusuke_arata
 *
 */
@WebServlet("/admin/articles")
public class ArticlesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ArticlesController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
	    
		if ("create".equals(type)) {
		    //記事管理画面から記事作成画面に遷移
		    
		    //フォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/createArticle.jsp");
		    dispatcher.forward(request, response);
		    
		    
		    
		    
		} else {
		    //ポータル画面から記事管理画面へ遷移
    	
    		//articleの取得
    		GetArticlesLogic getArticlesLogic = new GetArticlesLogic();
    		ArrayList<Article> articles = getArticlesLogic.getArticles();
    		
    		//値チェック
    		if (articles != null && articles.size() > 0) {
    			//リクエストスコープに登録
    			request.setAttribute("articles", articles);			
    		}
    		
    		//フォワード
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/articles.jsp");
    		dispatcher.forward(request, response);
    		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
		
	    String type = request.getParameter("type");
	    
	    //新規作成の場合
	    if ("create".equals(type)) {
	        
	        //文字化け対策
	        
	        //リクエストスコープから入力した記事を取得
	        String title = request.getParameter("title");	        
	        String content = request.getParameter("content");
	        
	        //確認用のコンソール出力
	        System.out.println(title);
	        System.out.println(content);
	        
	        //beanにセットする
	        Article article = new Article();
	        article.setTitle(title);
	        article.setContent(content);
	        
	        //バリデーション
	        ArticleValidator articleValidator = new ArticleValidator();
	        List<String> errors = articleValidator.postValidate(article);
	        
	        //バリデーションが問題無い場合
	        if (errors.isEmpty()) {
	            //記事を登録する
	            PostArticleLogic postArticleLogic = new PostArticleLogic();
	            postArticleLogic.addArticle(article);
	            
	            //記事管理画面に表示する用の記事をarticlesテーブルから取得する。
	            GetArticlesLogic getArticlesLogic = new GetArticlesLogic();
	             List<Article> articles = getArticlesLogic.getArticles();
	             
	            //記事管理画面に表示する用の記事をリクエストスコープにセットする
	            request.setAttribute("articles", articles);
	            
	            //記事管理画面にフォワードする
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/articles.jsp");
	            dispatcher.forward(request, response);
	            
	        } else {
	            //入力値に問題がある場合
	            //バリデーション結果をリクエストスコープにセットする
	            request.setAttribute("errors", errors);
	            
	            //記事作成画面にフォワード
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/createArticle.jsp");
	            dispatcher.forward(request, response);
	        }	       
	        
	        
	    } else if ("edit".equals(type)) {
	        //編集の場合
	        
	    } else {
	        
	    }
		
		
		
	}

}
