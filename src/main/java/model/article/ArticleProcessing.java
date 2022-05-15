package model.article;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleProcessing {
	
	/**
	 * reduceTheWord
	 * タイトルと内容を指定した文字数に制限する。
	 * @param articles 記事リスト
	 * @param wordCountTitle 制限する文字数（タイトル）
	 * @param wordCountContent 制限する文字数（内容）
	 * @return　List<Article> 記事リスト
	 */
	public List<Article> reduceTheWord(List<Article> articles, int wordCountTitle, int wordCountContent) {
		return articles.stream().map(a -> reduceTheWordOfTitle(a, wordCountTitle)).map(a -> reduceTheWordOfContent(a, wordCountContent)).collect(Collectors.toList());
	}
	
	
	/**
	 * reduceTheWordOfTitle
	 * 記事一覧表示時に、「タイトル」を指定した文字数に制限する処理。
	 * @param article 記事
	 * @param wordCount 文字数
	 * @return Article 記事
	 */
	public Article reduceTheWordOfTitle(Article article, int wordCount) {
		String title = article.getTitle();
		if (title.length() > wordCount) {
			title = title.substring(0, wordCount) + "...";
			article.setTitle(title);
		}
		
		return article;
	}
	
	
	/**
	 * reduceTheWordOfContent　
	 * 記事一覧表示時に、「内容」を指定した文字数に制限する処理。
	 * @param article 記事
	 * @param wordCount 文字数
	 * @return Article　記事
	 */
	public Article reduceTheWordOfContent(Article article, int wordCount) {
		String content = article.getContent();
		if (content.length() > wordCount) {
			content = content.substring(0, wordCount) + "...";
			article.setContent(content);
		}
		
		return article;
		
	}
	
	
	/**
	 * convertTagForHtmlInjection
	 * htmlタグを実体参照に変換する。（htmlインジェクション対策のため）
	 * @param article 記事
	 */
	public void convertTagTitle(Article article) {
		
		String title = article.getTitle();
		
        //htmlインジェクション対策（title）
        String changedTitle = "";
        //htmlタグを無効化 "<" 実体参照に変換したうえでDBに登録する。
        if (title.matches(".*<.*")) {
        	changedTitle = title.replaceAll("(?<=.*)<(?=.*)", "&lt;");
        }
        
        //htmlタグを無効化 ">"　実体参照に変換したうえでDBに登録する。
        if (title.matches(".*>.*") && changedTitle.isEmpty()) {
        	changedTitle = title.replaceAll("(?<=.*)>(?=.*)", "&gt;");
        } else if (title.matches(".*>.*")) {
        	changedTitle = changedTitle.replaceAll("(?<=.*)>(?=.*)", "&gt;");
        }
        
        //実体参照に変換したテキストをarticleに格納する（title）
        if (!(changedTitle.isEmpty())) {
        	article.setTitle(changedTitle);
        }
	}
	
	public void convertTagContent(Article article) {
		
		String content = article.getContent();
		
        //htmlインジェクション対策（content）
        String changedContent = "";
        //htmlタグを無効か　"<" 実体参照に変換したうえでDBに登録する。
        if (content.matches(".*<.*")) {
        	changedContent = content.replaceAll("(?<=.*)<(?=.*)", "&lt;");
        }
        
        //htmlタグを無効化　">" 実体参照に変換したうえでDBに登録する。
        if (content.matches(".*>.*") && changedContent.isEmpty()) {
        	changedContent = content.replaceAll("(?<=.*)>(?=.*)", "&gt;");
        } else if (content.matches(".*>.*")) {
        	changedContent = changedContent.replaceAll("(?<=.*)>(?=.*)", "&gt;");
        }
        
        
        //実体参照に変換したテキストをarticleに格納する（content）
        if(!(changedContent.isEmpty())) {
        	article.setContent(changedContent);
        }
	}

}
