package web;

import static utils.EntityManagerProvider.getEntityManager;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NotificationDAO;
import model.Notification;

public class GetAllNotificationsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetAllNotificationsServlet() {
	super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	if (request.getSession().getAttribute("currentFlat") == null
		|| request.getSession().getAttribute("flatStatus") == null) {
	    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	    rd.forward(request, response);
	}

	NotificationDAO noteDAO = new NotificationDAO(getEntityManager());

	Vector<Notification> notifications = noteDAO.showInfoAboutAllNotifications();

	request.setAttribute("allNotifications", notifications);

	RequestDispatcher rd = request.getRequestDispatcher("Notifications.jsp");
	rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

}
