package com.exam.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.beans.Utilisateur;
import com.exam.entities.Compte;
import com.exam.entities.Seance;
import com.exam.forms.ConnectionForms;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ServletContext context ;
	@EJB private Utilisateur user;
    
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		context.getRequestDispatcher("/WEB-INF/reservation.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SimpleDateFormat date = new SimpleDateFormat();
		Integer idSeance= Integer.parseInt(request.getParameter("id"));
		Float tarif = Float.parseFloat(request.getParameter("tarif"));
		Integer places = Integer.parseInt(request.getParameter("places"));
		try {
			Date horaire = date.parse(request.getParameter("horaire"));
			Seance seanceSelectionnee = new Seance(idSeance,horaire,tarif,places);
			session.setAttribute("seanceSelectionnee", seanceSelectionnee);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ConnectionForms form = new ConnectionForms();
		form.verif(request);
		request.setAttribute("form", form);
		context.getRequestDispatcher("/WEB-INF/reservation.jsp").forward(request, response);
	}

}
