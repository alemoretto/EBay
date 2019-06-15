package it.prova.ebay.web.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebay.model.Utente;
import it.prova.ebay.model.dto.UtenteDTO;
import it.prova.ebay.service.utente.UtenteService;

@WebServlet("/admin/ExecuteRicercaUtenteServlet")
public class ExecuteRicercaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteRicercaUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteDTO utenteDTO = new UtenteDTO(request.getParameter("nomeInput"),
				request.getParameter("cognomeInput"), request.getParameter("usernameInput"),
				request.getParameter("passwordInput"));
		
		request.setAttribute("listaUtentiAttributeName",
				utenteService.findByExample(UtenteDTO.buildUtenteInstance(utenteDTO)));
		

		RequestDispatcher rd = request.getRequestDispatcher("/admin/risultatiUtente.jsp");
		rd.forward(request, response);
	}

}
