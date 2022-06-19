package net.javaguides.springboot.security.jwt;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtEntryPoint.
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

	/** The Constant logger. */
	private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

	 /**
 	 * Commence.
 	 *
 	 * @param request the request
 	 * @param response the response
 	 * @param authException the auth exception
 	 * @throws IOException Signals that an I/O exception has occurred.
 	 * @throws ServletException the servlet exception
 	 */
 	@Override
	  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
	      throws IOException, ServletException {
	    logger.error("Unauthorized error: {}", authException.getMessage());

	    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

	    final Map<String, Object> body = new HashMap<>();
	    body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
	    body.put("error", "Unauthorized");
	    body.put("message", authException.getMessage());
	    body.put("path", request.getServletPath());

	    final ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(response.getOutputStream(), body);
	  }
}