package it.prova.ebay.web.servlet.acquisto;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebay.model.Utente;
import it.prova.ebay.service.utente.UtenteService;

@WebServlet("/acquisto/SendRedirectAcquistoServlet")
public class SendRedirectAcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public SendRedirectAcquistoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utente utenteInSession = (Utente) request.getSession().getAttribute("userInfo");
		Utente utenteCheAccede = utenteService.eseguiAccessoEager(utenteInSession.getUsername(),
				utenteInSession.getPassword());
		// metto utente in sessione
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", utenteCheAccede);
		request.getRequestDispatcher("/utente/ExecuteStoricoAcquistoServlet").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
