/*
 *
 * ---------------------------------------------------------------------

Program Name: MyServerChangedListener.java

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
import com.sap.mw.jco.JCO.ServerStateChangedListener;
public class MyServerStateChangedListener implements ServerStateChangedListener
{
  /**
   *  Simply prints server state changes
   */
  public void serverStateChangeOccurred(JCO.Server server, int old_state, int new_state)
  {
    System.out.print("Server " + server.getProgID() + " changed state from [");
    if ((old_state & JCO.STATE_STOPPED    ) != 0) System.out.print(" STOPPED ");
    if ((old_state & JCO.STATE_STARTED    ) != 0) System.out.print(" STARTED ");
    if ((old_state & JCO.STATE_LISTENING  ) != 0) System.out.print(" LISTENING ");
    if ((old_state & JCO.STATE_TRANSACTION) != 0) System.out.print(" TRANSACTION ");
    if ((old_state & JCO.STATE_BUSY       ) != 0) System.out.print(" BUSY ");
    System.out.print("] to [");
    if ((new_state & JCO.STATE_STOPPED    ) != 0) System.out.print(" STOPPED ");
    if ((new_state & JCO.STATE_STARTED    ) != 0) System.out.print(" STARTED ");
    if ((new_state & JCO.STATE_LISTENING  ) != 0) System.out.print(" LISTENING ");
    if ((new_state & JCO.STATE_TRANSACTION) != 0) System.out.print(" TRANSACTION ");
    if ((new_state & JCO.STATE_BUSY       ) != 0) System.out.print(" BUSY ");
    System.out.println("]");
  }
}