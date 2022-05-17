package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.article.Article;
import model.article.GetArticlesLogic;
import model.webAPI.WebAPIProcessing;


@WebServlet("/home")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public IndexController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//articlesの取得
		GetArticlesLogic getArticlesLogic = new GetArticlesLogic();
		ArrayList<Article> articles = getArticlesLogic.getArticles();
		
		//nullチェック
		if (articles != null && articles.size() > 0) {
			
		     //タイトルを指定文字数以内に加工する（js書きたくないからここに書いちゃいます）
	        List<String> titles = new ArrayList<>();
	        int charNum = 30;
	        for (Article article : articles) {
	            String title = article.getTitle();
	            if (title.length() > charNum) {
	                String shortTitle = title.substring(0, charNum);
	                titles.add(shortTitle + "...");
	            } else {
	                titles.add(title);
	            }
	        }
	        
	        //現在時間の東京の天気を取得する
	        WebAPIProcessing webAPIProcessing = new WebAPIProcessing(); 
	        String weather = webAPIProcessing.getWeatherInTokyo();
	        
	        //リクエストスコープに登録
            request.setAttribute("articles", articles);
            request.setAttribute("titles", titles);
            request.setAttribute("weather", weather);
	        
		}
		

		
		//トップ画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
