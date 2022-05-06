package validator;

import java.util.ArrayList;
import java.util.List;

import model.article.Article;

public class ArticleValidator {
    
    public List<String> postValidate(Article article) {
        
        //articleから各値を取り出す
        String title = article.getTitle();
        String content = article.getContent();
        
        //error格納用のリスト
        List<String> errors = new ArrayList<>();
        
        //バリデーション
        if ("".equals(title) || title == null || title.length() <= 0 ) {
            errors.add("タイトルが入力されていません。");
        }
        if ("".equals(content) || content == null || content.length() <= 0) {
            errors.add("内容が入力されていません。");
        }
        
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
        
        //実体参照に変換したテキストをarticleに格納する（title）
        if (!(changedTitle.isEmpty())) {
        	article.setTitle(changedTitle);
        }
        
      //実体参照に変換したテキストをarticleに格納する（content）
        if(!(changedContent.isEmpty())) {
        	article.setContent(changedContent);
        }
        
        return errors;
        
    }

}
