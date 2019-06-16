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
import it.prova.ebay.model.dto.UtenteDTO;
import it.prova.ebay.service.utente.UtenteService;

@WebServlet("/utente/ExecuteModificaDatiPersonaliServlet")
public class ExecuteModificaDatiPersonaliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaDatiPersonaliServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utente utenteOld = utenteService.caricaEager(Long.parseLong(request.getParameter("idInput")));
		UtenteDTO utenteDTO = UtenteDTO.buildUtenteDTOInstance(utenteOld);
		utenteDTO.setNome(request.getParameter("nomeInput"));
		utenteDTO.setCognome(request.getParameter("cognomeInput"));
		utenteDTO.setPassword(request.getParameter("passwordInput"));
		
		if (!utenteDTO.validate().isEmpty()) {
			request.setAttribute("utenteDTOAttribute", utenteDTO);
			request.setAttribute("messaggiDiErrore", utenteDTO.validate());

			request.getRequestDispatcher("/utente/modificaDatiPersonali.jsp").forward(request, response);

			return;
		}

		Utente utenteDaAggiornare = UtenteDTO.buildUtenteInstance(utenteDTO);

		utenteDaAggiornare.setDataRegistrazione(utenteOld.getDataRegistrazione());
		utenteDaAggiornare.setRuoli(utenteOld.getRuoli());
		utenteDaAggiornare.setCredito(utenteOld.getCredito());
		utenteDaAggiornare.setAnnunci(utenteOld.getAnnunci());
		utenteDaAggiornare.setAcquisti(utenteOld.getAcquisti());
		utenteService.aggiorna(utenteDaAggiornare);

		response.sendRedirect(request.getContextPath() + "/utente/SendRedirectDatiUtenteServlet");

	}

}
