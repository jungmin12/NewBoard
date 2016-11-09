package org.zerock.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.anno.RequestMapping;

/**
 * Servlet implementation class HelloController
 */
@WebServlet("/board/*")
public class BoardController extends AbstractController {
	private static final long serialVersionUID = 1L;

	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse responsee) {
		
		request.setAttribute("page", 1);

	}

	@RequestMapping("/register")
	public void regGet(HttpServletRequest request, HttpServletResponse responsee) {

	}

	@RequestMapping(value = "/register", method = "POST")
	public String regPost(HttpServletRequest request, HttpServletResponse responsee) {

		return "success";
	}

}