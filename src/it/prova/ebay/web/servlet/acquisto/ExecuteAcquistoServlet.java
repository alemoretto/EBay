package it.prova.ebay.web.servlet.acquisto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebay.model.Acquisto;
import it.prova.ebay.model.Utente;
import it.prova.ebay.model.dto.AcquistoDTO;
import it.prova.ebay.model.dto.AnnuncioDTO;
import it.prova.ebay.service.acquisto.AcquistoService;
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.utente.UtenteService;

@WebServlet("/acquisto/ExecuteAcquistoServlet")
public class ExecuteAcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AcquistoService acquistoService;

	@Autowired
	private AnnuncioService annuncioService;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteAcquistoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idAnnuncio = Long.parseLong(request.getParameter("idAnnuncio"));
		Utente utenteInSession = (Utente) request.getSession().getAttribute("userInfo");
		Long idUtente = utenteInSession.getId();

		request.setAttribute("idAnnuncio", request.getParameter("idAnnuncio"));

		if (!acquistoService.acquista(idAnnuncio, idUtente)) {
			request.setAttribute("esitoAcquistoBool", false);
			request.setAttribute("esitoAcquisto", "Non è stato possibile completare l'acquisto  :(  ");
			request.setAttribute("annuncioAttribute",
					AnnuncioDTO.buildAnnuncioDTOInstance(annuncioService.caricaEager(idAnnuncio)));
			request.getRequestDispatcher("/acquisto/confermaAcquisto.jsp").forward(request, response);
			return;
		}
		Utente utenteInPagina = utenteService.caricaEager(utenteInSession.getId());

		Set<Acquisto> storicoAcquisti = utenteInPagina.getAcquisti();

		List<AcquistoDTO> storicoAcquistiDTO = new ArrayList<>(0);
		if (storicoAcquisti.size() > 0) {
			for (Acquisto acq : storicoAcquisti) {
				storicoAcquistiDTO.add(new AcquistoDTO(acq.getDescrizione(), Double.toString(acq.getPrezzo()),
						Integer.toString(acq.getAnno())));
			}
		}
		request.setAttribute("esitoAcquistoBool", true);
		request.setAttribute("storicoDTOAttribute", storicoAcquistiDTO);
		request.setAttribute("esitoAcquisto", "Acquisto completato  :)  ");

		utenteInSession = utenteService.eseguiAccessoEager(utenteInSession.getUsername(),
				utenteInSession.getPassword());
		// metto utente in sessione
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", utenteInSession);

		request.getRequestDispatcher("/utente/risultatiStorico.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
