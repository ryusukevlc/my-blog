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
import validator.ArticleValidator;

/**
 * 記事編集画面のController
 * @author
 *
 */
@WebServlet("/admin/articleManagement/articleEdit")
public class ArticleEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ArticleEditController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    //文字化け対策
	    request.setCharacterEncoding("UTF-8");
	    
	    //パラメータからidを取得する
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    //記事を取得する
	    GetArticlesLogic getArticlesLogic = new GetArticlesLogic();
	    Article article = getArticlesLogic.getOneOfArticles(id);
	    
	    //リクエストスコープにセット
	    request.setAttribute("article", article);
	    request.setAttribute("id", id);
	    	    
	    //記事編集画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/editArticle.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    //文字化け対策
	    request.setCharacterEncoding("UTF-8");
	    
	    //パラメータの取得
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    //取得した値のセット
	    Article article = new Article();
	    article.setTitle(title);
	    article.setContent(content);
	    
	    //バリデーション
	    ArticleValidator validator = new ArticleValidator();
	    List<String> errors = validator.postValidate(article);
	    
	    ArticleProcessing articleProcessing = new ArticleProcessing();
	    
        //htmlインジェクション対策のため、タイトルと内容のタグを実体参照に変換する
        articleProcessing.convertTagTitle(article);
        articleProcessing.convertTagContent(article);
	    
	    //バリデーションの結果、問題がない場合
	    if (errors.isEmpty()) {
	    	
		    //記事のアップデート処理
		    PostArticleLogic postArticleLogic = new PostArticleLogic();
		    boolean isUpdated = postArticleLogic.updateArticle(article, id);
		    
		    if (isUpdated) {
		        
		        GetArticlesLogic getArticlesLogic = new GetArticlesLogic();
		        List<Article> articles = getArticlesLogic.getArticles();		
		        
		        //「内容」の文字数を45文字以内に調整、「タイトル」を10文字に調整
		        articleProcessing.reduceTheWord(articles, 10, 45);
		        
		        //記事管理画面表示用にリクエストスコープにセット
		        request.setAttribute("articles", articles);
		        
		        //記事管理画面にフォワード
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/articles.jsp");
		        dispatcher.forward(request, response);
		        
		    } else {
		        System.out.println("記事を更新できませんでした.");
		    }
	    } else {
            //入力値に問題がある場合
            //バリデーション結果をリクエストスコープにセットする
	    	request.setAttribute("errors", errors);
	    	
	    	//編集中の内容をリクエストスコープにセットする。
	    	request.setAttribute("article", article);
	    	request.setAttribute("id", id);
	    	
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/editArticle.jsp");
	    	dispatcher.forward(request, response);
	    	
	    }
	}

}
