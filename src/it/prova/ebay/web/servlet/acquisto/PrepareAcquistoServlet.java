package it.prova.ebay.web.servlet.acquisto;

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
import it.prova.ebay.model.dto.AnnuncioDTO;
import it.prova.ebay.service.annuncio.AnnuncioService;

@WebServlet("/PrepareAcquistoServlet")
public class PrepareAcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnnuncioService annuncioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public PrepareAcquistoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		Utente utenteInSession = (Utente) httpRequest.getSession().getAttribute("userInfo");
		if (utenteInSession == null) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
			return;
		}

		String idAnnuncio = request.getParameter("idAnnuncio");

		request.setAttribute("annuncioAttribute",
				AnnuncioDTO.buildAnnuncioDTOInstance(annuncioService.caricaEager(Long.parseLong(idAnnuncio))));

		request.setAttribute("idAnnuncio", request.getAttribute("idAnnuncio"));
		RequestDispatcher rd = request.getRequestDispatcher("/acquisto/confermaAcquisto.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
