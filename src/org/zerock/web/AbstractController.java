package org.zerock.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.anno.RequestMapping;

/**
 * Servlet implementation class AbstractController
 */
public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PRE = "/WEB-INF";
	private static final String APP = ".jsp";

	/**
	 * Default constructor.
	 */
	public AbstractController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getRequestURI();
		String contextName = request.getContextPath();

		String wantedPath = path.substring(contextName.length());

		String uri = request.getPathInfo();
		String callMethod = request.getMethod(); // get or post

		System.out.println("URI : " + uri);

		String jspPath = PRE;

		try {

			Class clz = this.getClass();
			Method[] methods = clz.getDeclaredMethods();

			for (Method method : methods) {
				RequestMapping mapping = method.getAnnotation(RequestMapping.class);

				if (mapping == null) {
					continue;
				}
				if (uri.equals(mapping.value()) && callMethod.equals(mapping.method())) {
					Object obj = method.invoke(this, request, response);
					if (obj == null) {
						System.out.println("void");
						jspPath += wantedPath + APP;

					} else {
						wantedPath = wantedPath.substring(0, wantedPath.lastIndexOf("/"));
						System.out.println("string");
						jspPath += wantedPath + "/" + (String) (obj) + APP;
					}
					request.getRequestDispatcher(jspPath).forward(request, response);

					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}