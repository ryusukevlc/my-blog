package model.article;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dao.ArticlesDAO;

class PostArticleLogicTest {
	
	Article article;
	
	@Mock
	private ArticlesDAO articleDAO = new ArticlesDAO();
	
	@InjectMocks
	private PostArticleLogic postArticleLogic = new PostArticleLogic();
	
	@BeforeEach
	void setUp() {
		
		MockitoAnnotations.initMocks(this);
		
		article = new Article();
		article.setTitle("testTitle");
		article.setContent("testContent");
		
		
	}
		
	@Test
	@DisplayName("引数を渡す") 
	void testAddArticle1(Article article) {
		
	}
	
	@Test
	void testAddArticle2() {
		
	}
	

	@Test
	@DisplayName("記事を削除する")
	void testDeleteArticle() {
		fail("まだ実装されていません"); // TODO
	}

	@Test
	@DisplayName("記事を更新する")
	void testUpdateArticle() {
		fail("まだ実装されていません"); // TODO
	}

}
