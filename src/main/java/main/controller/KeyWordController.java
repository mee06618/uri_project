package main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import main.model.keyword.KeywordDAO;
import main.model.site.SiteDAO;


@WebServlet("/keyword")
public class KeyWordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KeyWordController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String tag = request.getParameter("tag");
		System.out.println(tag);
		SiteDAO dao = new SiteDAO();
		request.setAttribute("list", dao.getSiteList(tag));
		for(int i=0; i<dao.getSiteList(tag).size(); i++)
			System.out.println(dao.getSiteList(tag).get(i).getText());
		
		RequestDispatcher rd = request.getRequestDispatcher("searchKeyword.jsp");
		rd.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		KeywordDAO keydao = new KeywordDAO();
		
		SiteDAO dao = new SiteDAO();

	
		RequestDispatcher rd = request.getRequestDispatcher("searchKeyword.jsp");
		rd.forward(request, response);

	}

}
