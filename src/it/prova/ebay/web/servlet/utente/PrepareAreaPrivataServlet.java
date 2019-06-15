package it.prova.ebay.web.servlet.utente;

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

@WebServlet("/utente/PrepareAreaPrivataServlet")
public class PrepareAreaPrivataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public PrepareAreaPrivataServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Utente utenteInSession = (Utente)request.getSession().getAttribute("userInfo");
		Long idUtente = utenteInSession.getId();
		
		request.setAttribute("utenteDTOAttribute",
				UtenteDTO.buildUtenteDTOInstance(utenteService.caricaEager(idUtente)));

		RequestDispatcher rd = request.getRequestDispatcher("/utente/areaPrivata.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
