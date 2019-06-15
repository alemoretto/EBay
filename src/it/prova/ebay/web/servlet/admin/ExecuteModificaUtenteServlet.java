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
import it.prova.ebay.service.ruolo.RuoloService;
import it.prova.ebay.service.utente.UtenteService;

@WebServlet("/admin/ExecuteModificaUtenteServlet")
public class ExecuteModificaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private RuoloService ruoloService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtenteDTO utenteDTO = new UtenteDTO(Long.parseLong(request.getParameter("idInput")),
				request.getParameter("nomeInput"), request.getParameter("cognomeInput"),
				request.getParameter("usernameInput"), request.getParameter("passwordInput"),
				request.getParameter("creditoInput"), request.getParameterValues("ruoloInput"), ruoloService.listAll());

		if (!utenteDTO.validate().isEmpty()) {
			request.setAttribute("utenteDTOAttribute", utenteDTO);
			request.setAttribute("listRuoliAttribute", ruoloService.listAll());
			request.setAttribute("messaggiDiErrore", utenteDTO.validate());
			RequestDispatcher rd = request.getRequestDispatcher("/admin/modificaUtente.jsp");
			rd.forward(request, response);

			return;
		}

		Utente utenteDaAggiornare = UtenteDTO.buildUtenteInstance(utenteDTO);
		Utente temp = utenteService.caricaEager(utenteDaAggiornare.getId());
		utenteDaAggiornare.setDataRegistrazione(temp.getDataRegistrazione());
		utenteDaAggiornare.setAnnunci(temp.getAnnunci());
		utenteDaAggiornare.setAcquisti(temp.getAcquisti());
		utenteService.aggiorna(utenteDaAggiornare);

		response.sendRedirect(request.getContextPath() + "/admin/SendRedirectAdminServlet");

	}

}
