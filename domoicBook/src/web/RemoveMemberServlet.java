package web;

import static utils.EntityManagerProvider.getEntityManager;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PeopleDAO;
import model.Flat;
import model.People;

public class RemoveMemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RemoveMemberServlet() {
	super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String firstName = String.valueOf(request.getParameter("firstName"));

	String lastName = String.valueOf(request.getParameter("lastName"));

	int flatNumber = Integer.valueOf(request.getParameter("flatNumber"));

	PeopleDAO pplDAO = new PeopleDAO(getEntityManager());

	People person = new People();

	person.setFirstName(firstName);
	person.setLastName(lastName);

	EntityManager em = getEntityManager();

	Flat flat = em.find(Flat.class, flatNumber);
	person.setFlat(flat);

	pplDAO.removeMember(person);

	doGet(request, response);
    }

}
