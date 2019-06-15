package it.prova.ebay.web.servlet.admin.categoria;

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
import it.prova.ebay.model.Categoria;
import it.prova.ebay.model.dto.AnnuncioDTO;
import it.prova.ebay.service.categoria.CategoriaService;

@WebServlet("/admin/categoria/ExecuteRicercaCategoriaServlet")
public class ExecuteRicercaCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CategoriaService categoriaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteRicercaCategoriaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Annuncio annuncio = AnnuncioDTO.buildAnnuncioInstance(
				new AnnuncioDTO(request.getParameter("testoAnnuncioInput"),	request.getParameter("prezzoInput")));

		request.setAttribute("listaCategorieAttribute", categoriaService.findByExampleEager(new Categoria(annuncio)));

		request.getRequestDispatcher("/admin/categoria/risultatiCategoria.jsp").forward(request, response);
	}

}
