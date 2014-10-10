package com.algaworks.estoque.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*.html")
public class LogAcessoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		System.out.println("Acessando " + req.getRequestURI());
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}

}