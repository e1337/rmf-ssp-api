package com.bhavya.rmf.ssp.configuration;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;


/**
 * Cross origin Request filter for response.
 */
@Component
public class CorsFilterConfiguration implements Filter {

  /**
   * This adds the response headers for Cross Origin Requests.
   *
   * @param req ServletRequest
   * @param res ServletResponse
   * @param chain FilterChain
   * @throws IOException IOException
   * @throws ServletException ServletException
   */
  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

    HttpServletResponse response = (HttpServletResponse) res;

    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers",
        "Content-Type, Accept, X-Requested-With, trans-id");

    chain.doFilter(req, res);
  }

  /**
   * Overrides config.
   *
   * @param filterConfig FilterConfig
   */
  @Override
  public void init(FilterConfig filterConfig) {
    //Filter Initialize
  }

  @Override
  public void destroy() {
    //Filter Destroy
  }

}
