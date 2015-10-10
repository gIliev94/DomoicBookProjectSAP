package web;

import static utils.EntityManagerProvider.getEntityManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PaymentDAO;

public class UpdatePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdatePaymentServlet() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.sendRedirect("CheckObligationServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	PaymentDAO payment = new PaymentDAO(getEntityManager());
	String[] values = request.getParameterValues("choose");
	for (int i = 0; i < values.length; i++) {
	    String[] elements = values[i].split("[-]");
	    payment.UpdatePayment(Integer.valueOf(elements[1]), Integer.valueOf(elements[0]));
	}
	doGet(request, response);
    }
}
