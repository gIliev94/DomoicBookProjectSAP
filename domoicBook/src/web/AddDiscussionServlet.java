package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiscussionDAO;
import model.Discussion;

import static utils.EntityManagerProvider.getEntityManager;

public class AddDiscussionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddDiscussionServlet() {
	super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.sendRedirect("GetAllDiscussionsServlet");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String title = String.valueOf(request.getParameter("title"));

	String content = String.valueOf(request.getParameter("content"));

	DiscussionDAO disDAO = new DiscussionDAO(getEntityManager());

	Discussion dis = new Discussion();

	dis.setTitle(title);
	dis.setContent(content);

	disDAO.addDiscussion(dis);

	doGet(request, response);
    }

}
