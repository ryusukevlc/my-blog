package model.article;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedConstruction;

import dao.ArticlesDAO;

//TODO 一応メモ：以下のようなエラーが出るが、Mockito-inlineの依存関係を含めたために発生している。（なぜかはわからない）
//            下記エラーにより何かしらの影響が出る場合は、Mockito-inlineの依存関係をコメントアウトし、Mockito-core
//            の依存関係を代わりに追加（コメントアウト解除）する。
//エラー内容：　Sharing is only supported for boot loader classes because bootstrap classpath has been appended
class PostArticleLogicTest {
	
	private static Date createDate;
	
	private static Date updateDate;
	
	@BeforeAll
	static void setUp() {

		
		//作成日付と更新日付の生成（parseがチェック例外を送出するため、try-catchを使用）
		try {
			String createDateString = "2022/04/01 00:00:00";
			String updateDateString = "2022/04/31 00:00:00";
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			createDate =  format.parse(createDateString);
			updateDate = format.parse(updateDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@ValueSource(booleans = {true, false})
	@DisplayName("想定した値がリターンされるかのみ確認する") 
	void onlyReturnValueConfirmForAddArticle(boolean bool) {
		
		Article article = new Article();
		
		//Mockitoだけではテスト対象メソッド内でnewしているメソッドはモックに出来ないので、PowerMockを使用する。
		//→PowerMockはJUnit5に対応していないらしいので、Mockitoですべて対応していく。
		//↓テスト対象メソッド内でnewしているメソッドをモック化する。
		try (MockedConstruction<ArticlesDAO> articlesDAOMock = mockConstruction(ArticlesDAO.class,
				(articlesDAO, ctx) -> doReturn(bool).when(articlesDAO).add(article))) {
			
			PostArticleLogic pal = new PostArticleLogic();
			
			//テスト対象メソッド呼び出し
			boolean result = pal.addArticle(article);
			
			assertEquals(bool, result);
		}
		

	}
	
	@Disabled
	@ParameterizedTest
	@MethodSource("articlesForParameter")
	@DisplayName("渡した引数を正しく受け取り、正しくリターンされるかまで確認する")
	void argumentsTestForAddArticle(Article article, boolean bool) { //TODO
		
//		//モック生成
//		when(mockArticlesDAO.add(article)).thenReturn(bool);
//		
//		//テスト対象メソッド呼び出し
//		boolean result = pal.addArticle(article);
//		
//		if (bool) {
//			assertTrue(result);
//		} else {
//			assertFalse(result);
//		}
		
	}
	
	static Stream<Arguments> articlesForParameter() {
		return Stream.of(
				Arguments.arguments(new Article(), true),
				Arguments.arguments(new Article(), false),
				Arguments.arguments(new Article("TestTitle2", 
						"TestContent2",
						createDate,
						updateDate), true),
				Arguments.arguments(new Article("TestTitle2", 
						"TestContent2",
						createDate,
						updateDate), false)
				);
	}
	
	
	
	@Disabled
	@Test
	@DisplayName("記事を削除する")
	void testDeleteArticle() {
		fail("まだ実装されていません"); // TODO
	}

	@Disabled
	@Test
	@DisplayName("記事を更新する")
	void testUpdateArticle() {
		fail("まだ実装されていません"); // TODO
	}

}
