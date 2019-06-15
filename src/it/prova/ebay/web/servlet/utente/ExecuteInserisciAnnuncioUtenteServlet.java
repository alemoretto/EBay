package it.prova.ebay.web.servlet.utente;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Categoria;
import it.prova.ebay.model.Utente;
import it.prova.ebay.model.dto.AnnuncioDTO;
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.categoria.CategoriaService;

@WebServlet("/utente/ExecuteInserisciAnnuncioUtenteServlet")
public class ExecuteInserisciAnnuncioUtenteServlet extends HttpServlet {
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
	
	public ExecuteInserisciAnnuncioUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AnnuncioDTO annuncioDTO = new AnnuncioDTO(request.getParameter("testoAnnuncioInput"),
				request.getParameter("prezzoInput"), 
				request.getParameterValues("categoriaInput"),
				categoriaService.listAll());
		
		if (!annuncioDTO.validate().isEmpty()) {
			request.setAttribute("annuncioDTOAttribute", annuncioDTO);
			request.setAttribute("listaCategorieAttribute", categoriaService.listAll());
			request.setAttribute("messaggiDiErrore", annuncioDTO.validate());

			request.getRequestDispatcher("/utente/inserisciAnnuncio.jsp").forward(request, response);

			return;
		}

		Annuncio annuncioDaInserire = AnnuncioDTO.buildAnnuncioInstance(annuncioDTO);
		annuncioDaInserire.setDataPubblicazione(new Date());
		annuncioDaInserire.setAperto(true);
		annuncioDaInserire.setUtente((Utente) request.getSession().getAttribute("userInfo"));

		annuncioService.inserisci(annuncioDaInserire);

		response.sendRedirect(request.getContextPath() + "/utente/SendRedirectUtenteServlet");

	}

}
