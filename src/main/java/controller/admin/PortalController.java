package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理者ポータル画面のController
 * @author ryusuke_arata
 */
@WebServlet("/admin/portal")
public class PortalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PortalController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin/portal.jsp");
	    dispatcher.forward(request, response);
	    
	    
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    
	}

}
