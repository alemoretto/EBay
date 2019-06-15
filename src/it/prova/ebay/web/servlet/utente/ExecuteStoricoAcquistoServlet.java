package it.prova.ebay.web.servlet.utente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebay.model.Acquisto;
import it.prova.ebay.model.Utente;
import it.prova.ebay.model.dto.AcquistoDTO;
import it.prova.ebay.service.utente.UtenteService;

@WebServlet("/utente/ExecuteStoricoAcquistoServlet")
public class ExecuteStoricoAcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteStoricoAcquistoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Long id = Long.parseLong(request.getParameter("idUtente"));
		Utente utenteInSession = (Utente) request.getSession().getAttribute("userInfo");

		Utente utenteInPagina = utenteService.caricaEager(utenteInSession.getId());

		Set<Acquisto> storicoAcquisti = utenteInPagina.getAcquisti();

		List<AcquistoDTO> storicoAcquistiDTO = new ArrayList<>(0);
		if (storicoAcquisti.size() > 0) {
			for (Acquisto acq : storicoAcquisti) {
				storicoAcquistiDTO.add(new AcquistoDTO(acq.getDescrizione(), Double.toString(acq.getPrezzo()),
						Integer.toString(acq.getAnno())));
			}
		}

		request.setAttribute("storicoDTOAttribute", storicoAcquistiDTO);

		RequestDispatcher rd = request.getRequestDispatcher("/utente/risultatiStorico.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
