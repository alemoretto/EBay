package it.prova.ebay.web.servlet.utente;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.utente.UtenteService;

@WebServlet("/utente/ExecuteEliminaAnnuncioUtenteServlet")
public class ExecuteEliminaAnnuncioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnnuncioService annuncioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteEliminaAnnuncioUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long idAnnuncio = Long.parseLong(request.getParameter("idAnnuncio"));

		annuncioService.rimuovi(annuncioService.caricaEager(idAnnuncio));

		response.sendRedirect("/utente/SendRedirectUtenteServlet");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
