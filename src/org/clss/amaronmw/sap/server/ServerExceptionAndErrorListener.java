/*
 *
 * ---------------------------------------------------------------------

Program Name: ServerExceptionAndErrorListener.java

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
import com.sap.mw.jco.JCO;
public class ServerExceptionAndErrorListener
implements JCO.ServerExceptionListener, JCO.ServerErrorListener {
  public void serverExceptionOccurred(JCO.Server server, Exception ex)
  {
   // System.out.println("Exception in server " + server.getProgID() + ":\n" + ex.getMessage());
   // ex.printStackTrace();
  }
  public void serverErrorOccurred(JCO.Server server, Error er)
  {
    //System.out.println("Error in server " + server.getProgID() + ":\n" + er);
   // er.printStackTrace();
  }
}