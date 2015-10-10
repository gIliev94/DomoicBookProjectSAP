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

public class CheckObligationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CheckObligationServlet() {
	super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	if (request.getSession().getAttribute("currentFlat") == null
		|| request.getSession().getAttribute("flatStatus") == null) {
	    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	    rd.forward(request, response);
	}

	int flatNumber = Integer.valueOf((request.getSession().getAttribute("currentFlat").toString()));

	PaymentDAO payDAO = new PaymentDAO(getEntityManager());

	Vector<Payment> obligations = payDAO.getPaymentsByNumber(flatNumber);

	request.setAttribute("obligations", obligations);

	RequestDispatcher rd = request.getRequestDispatcher("Obligations.jsp");
	rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

}
