package com.algaworks.estoque.filter;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/*")
public class HorarioFuncionamentoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		
		Calendar dataAtual = Calendar.getInstance();
		
		if (dataAtual.get(Calendar.HOUR_OF_DAY) >= 23 
				&& !req.getRequestURI().endsWith("/expediente-encerrado.html")) {
			res.sendRedirect("expediente-encerrado.html");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig config) throws ServletException {
	}
	
	public void destroy() {
	}
	
}