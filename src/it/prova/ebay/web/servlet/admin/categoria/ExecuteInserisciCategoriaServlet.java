package it.prova.ebay.web.servlet.admin.categoria;

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

import it.prova.ebay.model.Categoria;
import it.prova.ebay.model.Utente;
import it.prova.ebay.model.dto.CategoriaDTO;
import it.prova.ebay.model.dto.UtenteDTO;
import it.prova.ebay.service.categoria.CategoriaService;
import it.prova.ebay.service.ruolo.RuoloService;
import it.prova.ebay.service.utente.UtenteService;

@WebServlet("/admin/categoria/ExecuteInserisciCategoriaServlet")
public class ExecuteInserisciCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private RuoloService ruoloService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInserisciCategoriaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoriaDTO categoriaDTO = new CategoriaDTO(request.getParameter("descrizioneInput"), request.getParameter("codiceInput"));

		if (!categoriaDTO.validate().isEmpty()) {
			request.setAttribute("categoriaDTOAttribute", categoriaDTO);
			request.setAttribute("messaggiDiErrore", categoriaDTO.validate());
			request.getRequestDispatcher("/admin/categoria/inserisciCategoria.jsp").forward(request, response);

			return;
		}

		if (categoriaService.existDescrizione(categoriaDTO.getDescrizione())) {
			
			request.setAttribute("categoriaDTOAttribute", categoriaDTO);
			Map<String, String> validazione = new HashMap<String, String>();
			validazione.put("descrizioneInput", "Attenzione! Questa descrizione è già associata a un'altra categoria");
			request.setAttribute("messaggiDiErrore", validazione);
			
			request.getRequestDispatcher("/admin/categoria/inserisciCategoria.jsp").forward(request, response);

			return;
		}

		if (categoriaService.existCodice(categoriaDTO.getCodice())) {

			request.setAttribute("categoriaDTOAttribute", categoriaDTO);
			Map<String, String> validazione = new HashMap<String, String>();
			validazione.put("codiceInput", "Attenzione! Questo codice è già associato a un'altra categoria");
			request.setAttribute("messaggiDiErrore", validazione);
			
			request.getRequestDispatcher("/admin/categoria/inserisciCategoria.jsp").forward(request, response);

			return;
		}

		Categoria categoriaDaInserire = CategoriaDTO.buildCategoriaInstance(categoriaDTO);
		categoriaService.inserisci(categoriaDaInserire);

		response.sendRedirect(request.getContextPath() + "/admin/categoria/SendRedirectCategoriaServlet");

	}

}
