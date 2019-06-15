package it.prova.ebay.web.servlet.admin;

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

import it.prova.ebay.model.dto.UtenteDTO;
import it.prova.ebay.service.ruolo.RuoloService;

@WebServlet("/admin/PrepareInserisciUtenteServlet")
public class PrepareInserisciUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private RuoloService ruoloService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public PrepareInserisciUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("utenteDTOAttribute", new UtenteDTO());
		request.setAttribute("listRuoliAttribute", ruoloService.listAll());
		RequestDispatcher rd = request.getRequestDispatcher("/admin/inserisciUtente.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
