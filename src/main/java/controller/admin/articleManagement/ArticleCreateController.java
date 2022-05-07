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
 * 記事作成画面のController
 * @author 荒田龍甫
 *
 */

@WebServlet("/admin/articleManagement/articleCreate")
public class ArticleCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ArticleCreateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //記事作成画面に遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/createArticle.jsp");
        dispatcher.forward(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	       request.setCharacterEncoding("UTF-8");
        
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
        
        //バリデーション htmlインジェクション対策等もここで行う。
        ArticleValidator articleValidator = new ArticleValidator();
        List<String> errors = articleValidator.postValidate(article);
        
        //バリデーションが問題無い場合
        if (errors.isEmpty()) {
            //記事を登録する
            PostArticleLogic postArticleLogic = new PostArticleLogic();
            boolean isAdded = postArticleLogic.addArticle(article);
            
            if(isAdded) {
	            //記事管理画面に表示する用の記事をarticlesテーブルから取得する。
	            GetArticlesLogic getArticlesLogic = new GetArticlesLogic();
	             List<Article> articles = getArticlesLogic.getArticles();
	             
		        //「内容」の文字数を45文字以内に調整、「タイトル」を10文字に調整
		        ArticleProcessing articleProcessing = new ArticleProcessing();
		        articleProcessing.reduceTheWord(articles, 10, 45);
	             
	            //記事管理画面に表示する用の記事をリクエストスコープにセットする
	            request.setAttribute("articles", articles);
	            
	            //記事管理画面にフォワードする
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/articles.jsp");
	            dispatcher.forward(request, response);
            } else {
            	System.out.println("記事を作成できませんでした。");
            }
            
        } else {
            //入力値に問題がある場合
            //バリデーション結果をリクエストスコープにセットする
            request.setAttribute("errors", errors);
            
            //記事作成画面にフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/articleManagement/createArticle.jsp");
            dispatcher.forward(request, response);
        }        
	    
	}

}
