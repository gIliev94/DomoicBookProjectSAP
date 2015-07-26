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


public class OutboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OutboxServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flatNumber=Integer.valueOf((request.getSession().getAttribute("currentFlat").toString()));
		
		PrivateMessageDAO pmDAO=new PrivateMessageDAO(getEntityManager());
		
		Vector<PrivateMessage>outbox=pmDAO.getInfoAboutOutbox(flatNumber);
		
		request.setAttribute("outboxMessages", outbox);
		
		 RequestDispatcher rd=request.getRequestDispatcher("Outbox.jsp");  
         rd.forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
