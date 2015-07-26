package web;

import static utils.EntityManagerProvider.getEntityManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NotificationDAO;
import model.Notification;

public class AddNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddNotificationServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("GetAllNotificationsServlet");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flatNumber=Integer.valueOf((request.getSession().getAttribute("currentFlat").toString()));
		
		String title = String.valueOf(request.getParameter("title"));
		
		String content = String.valueOf(request.getParameter("content"));
				
	NotificationDAO noteDAO=new NotificationDAO(getEntityManager());
	
	
		Notification note = new Notification();
		note.setTitle(title);
		note.setContent(content);

		noteDAO.addNotification(note, flatNumber);
		
		doGet(request, response);
	}

}
