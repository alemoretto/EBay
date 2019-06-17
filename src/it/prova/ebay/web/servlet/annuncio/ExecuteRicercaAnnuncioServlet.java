package it.prova.ebay.web.servlet.annuncio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
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
import it.prova.ebay.model.Utente;
import it.prova.ebay.model.dto.AnnuncioDTO;
import it.prova.ebay.service.annuncio.AnnuncioService;
import it.prova.ebay.service.categoria.CategoriaService;

@WebServlet("/ExecuteRicercaAnnuncioServlet")
public class ExecuteRicercaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnnuncioService annuncioService;

	@Autowired
	private CategoriaService categoriaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteRicercaAnnuncioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AnnuncioDTO annuncioDTO = new AnnuncioDTO(request.getParameter("testoAnnuncioInput"),
				request.getParameter("prezzoInput"), request.getParameterValues("categoriaInput"),
				categoriaService.listAll());
		if (annuncioDTO.getCategorie().size() == 0)
			annuncioDTO.setCategorie(new LinkedHashSet<>(categoriaService.listAll()));

		Annuncio annuncioDaCercare = AnnuncioDTO.buildAnnuncioInstance(annuncioDTO);
		List<Annuncio> tuttiGliannunci = annuncioService.findByExampleEager(annuncioDaCercare);
		List<Annuncio> annunciDaMostrare = new ArrayList<Annuncio>(0);
		Utente utenteLoggato = (Utente) request.getSession().getAttribute("userInfo");
		if (utenteLoggato != null) {
			for (Annuncio annuncio : tuttiGliannunci) {
				if (!annuncio.getUtente().getUsername().equals(utenteLoggato.getUsername())) {
					annunciDaMostrare.add(annuncio);
				}
			}
		} else {
			annunciDaMostrare = tuttiGliannunci;
		}
		request.setAttribute("listaAnnunciAttribute", annunciDaMostrare);

		request.getRequestDispatcher("/risultatiAnnuncio.jsp").forward(request, response);

	}

}
