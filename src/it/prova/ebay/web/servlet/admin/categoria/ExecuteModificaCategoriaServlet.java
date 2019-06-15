package it.prova.ebay.web.servlet.admin.categoria;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.ebay.model.Categoria;
import it.prova.ebay.model.dto.CategoriaDTO;
import it.prova.ebay.service.categoria.CategoriaService;

@WebServlet("/admin/categoria/ExecuteModificaCategoriaServlet")
public class ExecuteModificaCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CategoriaService categoriaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteModificaCategoriaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoriaDTO categoriaDTO = new CategoriaDTO(Long.parseLong(request.getParameter("idInput")),
				request.getParameter("descrizioneInput"), request.getParameter("codiceInput"));

		if (!categoriaDTO.validate().isEmpty()) {
			request.setAttribute("categoriaDTOAttribute", categoriaDTO);
			request.setAttribute("messaggiDiErrore", categoriaDTO.validate());
			request.getRequestDispatcher("/admin/categoria/inserisciCategoria.jsp").forward(request, response);

			return;
		}

		Categoria categoriaOLD = categoriaService.carica(categoriaDTO.getId());
		
//		if (!categoriaDaInserire.equals(categoriaService.carica(categoriaDTO.getId()))) {
			if (categoriaService.existDescrizione(categoriaDTO.getDescrizione())  &&  !categoriaOLD.getDescrizione().equals(categoriaDTO.getDescrizione())) {

				request.setAttribute("categoriaDTOAttribute", categoriaDTO);
				Map<String, String> validazione = new HashMap<String, String>();
				validazione.put("descrizioneInput",
						"Attenzione! Questa descrizione è già associata a un'altra categoria");
				request.setAttribute("messaggiDiErrore", validazione);

				request.getRequestDispatcher("/admin/categoria/inserisciCategoria.jsp").forward(request, response);

				return;
			}

//			if (categoriaService.existCodice(categoriaDTO.getCodice())) {
//
//				request.setAttribute("categoriaDTOAttribute", categoriaDTO);
//				Map<String, String> validazione = new HashMap<String, String>();
//				validazione.put("codiceInput", "Attenzione! Questo codice è già associato a un'altra categoria");
//				request.setAttribute("messaggiDiErrore", validazione);
//
//				request.getRequestDispatcher("/admin/categoria/inserisciCategoria.jsp").forward(request, response);
//
//				return;
//			}
//		}

		Categoria categoriaDaInserire = CategoriaDTO.buildCategoriaInstance(categoriaDTO);
		
		categoriaService.aggiorna(categoriaDaInserire);

		response.sendRedirect(request.getContextPath() + "/admin/categoria/SendRedirectCategoriaServlet");

	}

}
