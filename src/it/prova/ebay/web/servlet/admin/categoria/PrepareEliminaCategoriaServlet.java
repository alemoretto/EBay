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

import it.prova.ebay.model.dto.CategoriaDTO;
import it.prova.ebay.service.categoria.CategoriaService;

@WebServlet("/admin/categoria/PrepareEliminaCategoriaServlet")
public class PrepareEliminaCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CategoriaService categoriaService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public PrepareEliminaCategoriaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long idCategoria = Long.parseLong(request.getParameter("idCategoria"));

		CategoriaDTO categoriaDTO = CategoriaDTO.buildCategoriaDTOInstance(categoriaService.caricaEager(idCategoria));

		request.setAttribute("categoriaDTOAttribute", categoriaDTO);

		request.getRequestDispatcher("/admin/categoria/rimuoviCategoria.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
