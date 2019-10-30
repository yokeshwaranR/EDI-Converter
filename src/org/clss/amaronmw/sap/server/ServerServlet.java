/*
 *
 * ---------------------------------------------------------------------

Program Name: ServerServlet.java

Author      : Vinoth.R        Date : 22 Aug 2011.

---------------------------------------------------------------------

Description







---------------------------------------------------------------------
Corrections
---------------------------------------------------------------------


Name            Date      Version                ECCO     Reason



---------------------------------------------------------------------
 */

package org.clss.amaronmw.sap.server;
import java.io.IOException;
import javax.servlet.*;
/**
 *
 * @author clss8
 */
public class ServerServlet implements Servlet {
   public void init(ServletConfig config) throws ServletException
    {
            ServerListener server = new ServerListener();
            server.ServerRunner();
    }

    public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException
    { }

    public void destroy()
    {
    }

    public String getServletInfo() {
        return null;
    }
    public ServletConfig getServletConfig() {
        return null;
    }
}
