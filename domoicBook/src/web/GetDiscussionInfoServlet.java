package web;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static utils.EntityManagerProvider.getEntityManager;
import dao.AnswerDAO;
import model.Answer;

public class GetDiscussionInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetDiscussionInfoServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.valueOf(request.getParameter("choose"));
		
		AnswerDAO ansDAO = new AnswerDAO(getEntityManager());
		
		Vector<Answer> answers = ansDAO.getInfoAboutDiscuss(id);
		
		request.setAttribute("discussionInfo", answers);
		request.getSession().setAttribute("chosen", id);
		
		RequestDispatcher rd=request.getRequestDispatcher("Topic info.jsp");  
        rd.forward(request, response);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
