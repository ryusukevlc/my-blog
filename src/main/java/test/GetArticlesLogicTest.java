package test;

import java.util.ArrayList;

import model.article.Article;
import model.article.GetArticlesLogic;

public class GetArticlesLogicTest {
	
	public static void main(String[] args) {
		
		getArticlesTest();
		
	}
	
	public static void getArticlesTest() {
		GetArticlesLogic getArticlesLogic = new GetArticlesLogic();
		ArrayList<Article> articles = getArticlesLogic.getArticles();
		
		for (int i = 0 ; articles.size() > i ; i++) {
			System.out.println(articles.get(i).getTitle());
			System.out.println(articles.get(i).getContent());
			System.out.println(articles.get(i).getCreated_at());
			System.out.println(articles.get(i).getUpdated_at());
		}
		
	}

}
