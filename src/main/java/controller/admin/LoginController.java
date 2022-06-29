package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		
		//ログイン画面に遷移する
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/login.jsp");
	    dispatcher.forward(request, response);
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//認証してDBに格納されているユーザー名とパスワードが一致する場合、
		//セッションを生成する
	    //一致しない場合はログイン画面に再遷移する
		
		//TODO:ユーザーテーブルを作成する
		//TODO:ハッシュ化されたパスワードの認証を実装する
		//TODO:ユーザー登録にてパスワードをハッシュ化してDBに格納するように実装する
		//TODO:ユーザー登録機能、パスワード変更機能を実装する
		
	}

}
