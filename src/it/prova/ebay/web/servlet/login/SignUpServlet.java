package it.prova.ebay.web.servlet.login;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebay.model.Ruolo;
import it.prova.ebay.model.Utente;
import it.prova.ebay.model.dto.UtenteDTO;
import it.prova.ebay.service.ruolo.RuoloService;
import it.prova.ebay.service.utente.UtenteService;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
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

	public SignUpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Ruolo classicUser = ruoloService.findByExample(new Ruolo(Ruolo.CLASSIC_USER_ROLE)).get(0);
		String[] ruoloUtenteClassico = { Long.toString(classicUser.getId()) };
		String creditoIniziale = "0";
		UtenteDTO utenteDTO = new UtenteDTO(request.getParameter("nomeInput"), request.getParameter("cognomeInput"),
				request.getParameter("usernameInput"), request.getParameter("passwordInput"), creditoIniziale,
				ruoloUtenteClassico, ruoloService.listAll());

		if (!utenteDTO.validate().isEmpty()) {
			request.setAttribute("utenteDTOAttribute", utenteDTO);
			request.setAttribute("listRuoliAttribute", ruoloService.listAll());
			request.setAttribute("messaggiDiErrore", utenteDTO.validate());
			RequestDispatcher rd = request.getRequestDispatcher("/signUp.jsp");
			rd.forward(request, response);

			return;
		}

		if (utenteService.findByUsername(request.getParameter("usernameInput")) != null) {
			request.setAttribute("utenteDTOAttribute", utenteDTO);
			request.setAttribute("listRuoliAttribute", ruoloService.listAll());
			Map<String, String> validazione = new HashMap<String, String>();
			validazione.put("usernameInput",
					"Attenzione! Lo username \"" + request.getParameter("usernameInput") + "\" è già stato preso");
			request.setAttribute("messaggiDiErrore", validazione);
			RequestDispatcher rd = request.getRequestDispatcher("/signUp.jsp");
			rd.forward(request, response);

			return;
		}

		Utente utenteDaInserire = UtenteDTO.buildUtenteInstance(utenteDTO);
		utenteDaInserire.setDataRegistrazione(new Date());
//		utenteDaInserire.getRuoli().add(ruoloService.carica(2L));
//		String[] ruoli = request.getParameterValues("ruoloItem");
//		if (ruoli != null && ruoli.length > 0) {
//			Set<Ruolo> ruoliSet = new HashSet<>();
//			for (String ruoloId : ruoli) {
//				ruoliSet.add(new Ruolo(Long.parseLong(ruoloId)));
//			}
//			utenteDaInserire.setRuoli(ruoliSet);
//		}
//		utenteDaInserire.setDataRegistrazione(new Date());
		utenteService.inserisci(utenteDaInserire);

		response.sendRedirect(request.getContextPath() + "/login.jsp");

	}

}
