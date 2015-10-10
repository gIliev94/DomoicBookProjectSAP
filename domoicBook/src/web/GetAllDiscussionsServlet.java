package web;

import static utils.EntityManagerProvider.getEntityManager;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiscussionDAO;
import model.Discussion;

public class GetAllDiscussionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetAllDiscussionsServlet() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	if (request.getSession().getAttribute("currentFlat") == null
		|| request.getSession().getAttribute("flatStatus") == null) {
	    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	    rd.forward(request, response);
	}

	DiscussionDAO disDAO = new DiscussionDAO(getEntityManager());

	Vector<Discussion> discussions = disDAO.showInfoAboutAllDiscussions();

	request.setAttribute("allDiscussions", discussions);

	RequestDispatcher rd = request.getRequestDispatcher("Discussions.jsp");
	rd.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

}
