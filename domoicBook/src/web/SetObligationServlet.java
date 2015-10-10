package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ObligationDAO;
import model.Obligation;

import static utils.EntityManagerProvider.getEntityManager;

public class SetObligationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SetObligationServlet() {
	super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.sendRedirect("CheckObligationServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String description = String.valueOf(request.getParameter("description"));
	String deadline = String.valueOf(request.getParameter("deadline"));
	double debt = Double.valueOf(request.getParameter("debt"));

	ObligationDAO oblDAO = new ObligationDAO(getEntityManager());

	Obligation obl = new Obligation();
	obl.setDescription(description);
	obl.setDeadline(deadline);
	obl.setDebt(debt);

	oblDAO.addObligation(obl);

	doGet(request, response);
    }

}
