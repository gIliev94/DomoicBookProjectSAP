package web;

import static utils.EntityManagerProvider.getEntityManager;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrivateMessageDAO;
import model.PrivateMessage;

public class InboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InboxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("currentFlat")==null||request.getSession().getAttribute("flatStatus")==null){
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
			rd.forward(request, response); 
		}
		
		int flatNumber=Integer.valueOf((request.getSession().getAttribute("currentFlat").toString()));
		
		PrivateMessageDAO pmDAO=new PrivateMessageDAO(getEntityManager());
		
		Vector<PrivateMessage>inbox=pmDAO.getInfoAboutInbox(flatNumber);
		
		request.setAttribute("inboxMessages", inbox);
		
		 RequestDispatcher rd=request.getRequestDispatcher("Inbox.jsp");  
         rd.forward(request, response);  
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
