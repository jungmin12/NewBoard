package org.zerock.web;

import javax.servlet.annotation.WebServlet;

import org.zerock.anno.RequestMapping;

@WebServlet("/member/*")
public class MemberController extends AbstractController {

		@RequestMapping("/register")
		public void register(){
			
		}
}
