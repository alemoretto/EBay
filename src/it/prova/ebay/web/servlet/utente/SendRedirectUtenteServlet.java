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

import it.prova.ebay.model.Utente;
import it.prova.ebay.service.utente.UtenteService;

@WebServlet("/utente/SendRedirectUtenteServlet")
public class SendRedirectUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public SendRedirectUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utente utenteInSession = (Utente) request.getSession().getAttribute("userInfo");
		Utente utenteEager = utenteService.caricaEager(utenteInSession.getId());
		request.setAttribute("listaAnnunciAttribute", utenteEager.getAnnunci());

		request.getRequestDispatcher("/utente/risultatiAnnuncio.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
