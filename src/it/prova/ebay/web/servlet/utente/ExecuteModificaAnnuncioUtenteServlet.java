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

import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Utente;
import it.prova.ebay.model.dto.AnnuncioDTO;
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.categoria.CategoriaService;

@WebServlet("/utente/ExecuteModificaAnnuncioUtenteServlet")
public class ExecuteModificaAnnuncioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private AnnuncioService annuncioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaAnnuncioUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AnnuncioDTO annuncioDTO = new AnnuncioDTO(Long.parseLong(request.getParameter("idInput")),
				request.getParameter("testoAnnuncioInput"), request.getParameter("prezzoInput"),
				request.getParameterValues("categoriaInput"), categoriaService.listAll());

		if (!annuncioDTO.validate().isEmpty()) {
			request.setAttribute("annuncioDTOAttribute", annuncioDTO);
			request.setAttribute("listaCategorieAttribute", categoriaService.listAll());
			request.setAttribute("messaggiDiErrore", annuncioDTO.validate());

			request.getRequestDispatcher("/utente/modificaAnnuncio.jsp").forward(request, response);

			return;
		}

		Annuncio annuncioDaModificare = AnnuncioDTO.buildAnnuncioInstance(annuncioDTO);
		Annuncio temp = annuncioService.carica(Long.parseLong(request.getParameter("idInput")));
		annuncioDaModificare.setDataPubblicazione(temp.getDataPubblicazione());
		annuncioDaModificare.setUtente((Utente) request.getSession().getAttribute("userInfo"));

		annuncioService.aggiorna(annuncioDaModificare);

		response.sendRedirect(request.getContextPath() + "/utente/SendRedirectUtenteServlet");

	}

}
