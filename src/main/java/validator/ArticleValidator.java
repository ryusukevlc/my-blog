package validator;

import java.util.ArrayList;
import java.util.List;

import model.Article;

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
        
        return errors;
        
    }

}
