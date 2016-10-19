package cn.jsutils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IPServlet extends HttpServlet {
  private static final long serialVersionUID = -7821854929705795672L;

  private static final String[] HEADERS_TO_TRY = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP",
      "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP", "HTTP_FORWARDED_FOR",
      "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR" };

  public static String getClientIpAddress(HttpServletRequest request) {
    for (String header : HEADERS_TO_TRY) {
      String ip = request.getHeader(header);
      if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
        return ip;
      }
    }
    return request.getRemoteAddr();
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String result = getClientIpAddress(request);
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(result);
    response.getWriter().flush();
    response.getWriter().close();
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) {
    try {
      doGet(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
