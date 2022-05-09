package com.exam.servlets;

import java.io.IOException;
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


@WebServlet(name="Accueil",urlPatterns={"/Accueil"})
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServletContext context;
    @EJB private CinemaBean cinema;
    
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		Set<Film> films = cinema.list();
		context.setAttribute("listeFilms", films);
		context.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		
		String action=request.getParameter("action"); 
		 
		if(action.equals("Seances")) {
			Integer idFilm= Integer.parseInt(request.getParameter("id"));
			String nomFilm= request.getParameter("name");
			Film filmSelectionne = cinema.createFilm(nomFilm);
			context.setAttribute("filmSelectionne", filmSelectionne);
			
			context.getRequestDispatcher("/WEB-INF/seances.jsp").forward(request, response);
		}
	}

}
