package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.article.Article;
import model.article.ArticleProcessing;
import model.article.GetArticlesLogic;
import model.webAPI.WebAPIProcessing;



@WebServlet("/articleDetail")
public class ArticleDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ArticleDetailController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    //取得したidをキーに記事を取得
	    GetArticlesLogic getArticlesLogic = new GetArticlesLogic();
	    Article article = getArticlesLogic.getOneOfArticles(id);
	    
        //現在時間の東京の天気を取得する
        WebAPIProcessing webAPIProcessing = new WebAPIProcessing(); 
        int weather = webAPIProcessing.getWeatherInTokyo();
        
        ArticleProcessing articleProcessing = new ArticleProcessing();
        articleProcessing.parseMarkDown(article);
        
	    
	    //記事が取得できた場合
	    if (article != null) {
	        request.setAttribute("article", article);
            request.setAttribute("weather", weather);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/articleDetail.jsp");
	        dispatcher.forward(request, response);
	    } else {
	        //記事が取得できなかった場合
	        
	    }
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	}

}
