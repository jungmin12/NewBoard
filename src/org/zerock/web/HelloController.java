package org.zerock.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.anno.RequestMapping;

/**
 * Servlet implementation class HelloController
 */
@WebServlet("/hello/*")
public class HelloController extends AbstractController {
	private static final long serialVersionUID = 1L;

	@RequestMapping("/hi")
	public void hi(HttpServletRequest request, HttpServletResponse responsee ) {
		System.out.println("HelloController");
	}

	@RequestMapping("/bye")
	public String bye(HttpServletRequest request, HttpServletResponse responsee ) {
		System.out.println("ByeController");
		return "bye";
	}
}