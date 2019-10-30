/*
 *
---------------------------------------------------------------------

Program Name: ServerListener.java

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
//import java.net.*;
import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.ServerStateChangedListener;
public  class ServerListener extends StartServer 
{
    public void ServerRunner()
    {
        ServerExceptionAndErrorListener el = new ServerExceptionAndErrorListener();
        JCO.addServerErrorListener(el);
        JCO.addServerExceptionListener(el);
        MyServerStateChangedListener sl = new MyServerStateChangedListener();
        JCO.addServerStateChangedListener((ServerStateChangedListener)sl);
        StartServer.startServers() ;
    }
    public static void main(String[] args) 
    {
        try
        {
//            InetAddress ownIP=InetAddress.getLocalHost();
//            System.out.println(ownIP);
//            if(ownIP.toString().contains("10.20.235.28"))
//            {
                ServerExceptionAndErrorListener el = new ServerExceptionAndErrorListener();
                JCO.addServerErrorListener(el);
                JCO.addServerExceptionListener(el);
                MyServerStateChangedListener sl = new MyServerStateChangedListener();
                JCO.addServerStateChangedListener((ServerStateChangedListener)sl);
                StartServer.startServers();
//            }
        }
        catch(Exception e)
        {
//            e.printStackTrace();
        }
    }
}