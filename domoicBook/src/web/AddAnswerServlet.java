package web;

import static utils.EntityManagerProvider.getEntityManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnswerDAO;
import model.Answer;

public class AddAnswerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddAnswerServlet() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.sendRedirect("GetAllDiscussionsServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// int flatNumber=(int)request.getSession().getAttribute("currentFlat");
	int flatNumber = Integer.valueOf((request.getSession().getAttribute("currentFlat").toString()));

	String content = String.valueOf(request.getParameter("content"));

	int discussId = Integer.valueOf(request.getSession().getAttribute("chosen").toString());

	AnswerDAO ansDAO = new AnswerDAO(getEntityManager());

	Answer ans = new Answer();
	ans.setContent(content);

	ansDAO.addAnswer(ans, discussId, flatNumber);

	doGet(request, response);
    }

}
