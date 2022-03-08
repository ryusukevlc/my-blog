package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Article;
import model.GetArticlesLogic;


@WebServlet("/Articles")
public class ArticlesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ArticlesController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//articleの取得
		GetArticlesLogic getArticlesLogic = new GetArticlesLogic();
		ArrayList<Article> articles = getArticlesLogic.getArticles();
		
		//値チェック
		if (articles != null && articles.size() > 0) {
			//リクエストスコープに登録
			request.setAttribute("articles", articles);			
		}
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/articles.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
