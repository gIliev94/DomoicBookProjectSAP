package web;

import static utils.EntityManagerProvider.getEntityManager;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PaymentDAO;
import model.Payment;


public class PayObligationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PayObligationServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("currentFlat")==null||request.getSession().getAttribute("flatStatus")==null){
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
			rd.forward(request, response); 
		}
		
		PaymentDAO payDAO = new PaymentDAO(getEntityManager());
		
		Vector<Payment> obligations=payDAO.getAllObligations();
		
		request.setAttribute("allObligations", obligations);
		
		RequestDispatcher rd=request.getRequestDispatcher("ViewAllPayments.jsp");  
        rd.forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
