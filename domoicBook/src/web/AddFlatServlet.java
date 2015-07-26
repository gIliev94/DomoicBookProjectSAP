package web;

import static utils.EntityManagerProvider.getEntityManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlatDAO;
import model.Flat;
import model.status;

public class AddFlatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddFlatServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.sendRedirect("index.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int flatNumber=Integer.valueOf(request.getParameter("flatNumber"));
		int roomCount=Integer.valueOf(request.getParameter("roomCount"));
		double flatSurface= Double.valueOf(request.getParameter("flatSurface"));
		String password= String.valueOf(request.getParameter("password"));
		String stat=String.valueOf(request.getParameter("status"));
		
		FlatDAO flDAO = new FlatDAO(getEntityManager());

		Flat fl=new Flat();
		fl.setNumber(flatNumber);
		fl.setRoomCount(roomCount);
		fl.setFlatSurface(flatSurface);
		fl.setPassword(password);
		
		if(stat.equals("NORMAL")){
		fl.setStatus(status.NORMAL);
		}else fl.setStatus(status.ADMIN);
		
		flDAO.addFlat(fl);
		
		doGet(request, response);
	}

}