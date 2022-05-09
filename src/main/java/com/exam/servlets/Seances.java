package com.exam.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.beans.CinemaBean;
import com.exam.entities.Film;
import com.exam.entities.SalleProg;
import com.exam.entities.Seance;

import java.util.Date;
import java.util.List;


@WebServlet(name="seances",urlPatterns={"/seances"})
public class Seances extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	@EJB private CinemaBean cinema;  
    
    public Seances() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		Set<SalleProg> salleProgs = cinema.getAllSalleProg();
		
		context.setAttribute("listeSalles", salleProgs);
		while(salleProgs.iterator().hasNext()) {
			List<Seance> seances = salleProgs.iterator().next().getSceances();
			context.setAttribute("listeSeances", seances);
		}
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/seances.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		String action=request.getParameter("action"); 
		 
		if(action.equals("Reserver")) {
			SimpleDateFormat date = new SimpleDateFormat();
			Integer idSeance= Integer.parseInt(request.getParameter("id"));
			Float tarif = Float.parseFloat(request.getParameter("tarif"));
			Integer places = Integer.parseInt(request.getParameter("places"));
			try {
				Date horaire = date.parse(request.getParameter("horaire"));
				Seance seanceSelectionnee = new Seance(idSeance,horaire,tarif,places);
				context.setAttribute("seanceSelectionnee", seanceSelectionnee);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			context.getRequestDispatcher("/WEB-INF/reservation.jsp").forward(request, response);
		}
	}

}
