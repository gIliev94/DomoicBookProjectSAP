package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrivateMessageDAO;
import model.PrivateMessage;

import static utils.EntityManagerProvider.getEntityManager;


public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SendMessageServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("OutboxServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = String.valueOf(request.getParameter("title"));
		 
		String content = String.valueOf(request.getParameter("content"));
		
		int senderNumber=Integer.valueOf((request.getSession().getAttribute("currentFlat").toString()));
		
		int receiverNumber = Integer.valueOf(request.getParameter("receiverNumber"));
		
		PrivateMessageDAO pmDAO=new PrivateMessageDAO(getEntityManager());
		
		PrivateMessage pm = new PrivateMessage();
		
		pm.setTitle(title);
		pm.setContent(content);
		
		pmDAO.addPrivateMessage(pm, senderNumber, receiverNumber);

		doGet(request, response);
	}

}
