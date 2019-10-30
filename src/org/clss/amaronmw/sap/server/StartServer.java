/*
 *
 * ---------------------------------------------------------------------

Program Name: StartServer.java

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
import com.sap.mw.jco.IRepository;
import com.sap.mw.jco.JCO;

import org.clss.amaronmw.bean.DBCommon;
import org.clss.amaronmw.log.ErrorLogger;
public class StartServer
{
    static ServerRequestHandler serverConnections[] = new ServerRequestHandler[3];

    /**
     *  Start the server
     */

    public static void startServers()  {
      //JCO.addClientPool("POOL",  3, "550", "test2" ,"welcome1" , "EN", "10.10.40.195" ,"01");
      //10.10.40.24
        try{
    ErrorLogger logger = new ErrorLogger("org.clss.amaronmw.SAP.server.ServerRequestHandler");
    	  DBCommon dbc=new DBCommon();
//        String[][] saplog=new String[1][9];
        String[] saplog = dbc.getSAPLoginDetails();
        System.out.println(saplog[0]);
//        saplog[0][1]="130";//800
//        saplog[0][2]="ARBLCLSS";//sapjava
//        saplog[0][3]="clss@123";//clssjava
//        saplog[0][4]="EN";//EN
//        saplog[0][5]="10.111.0.105";//192.168.1.100 /H/125.17.230.67/H/ARECCDV.ARGROUP.CO.IN
//        saplog[0][6]="00";//01
//        saplog[0][8]="ZAMARON_DELIVERY";
        JCO.addClientPool("POOL",  3, saplog[0], saplog[1] , saplog[2] , saplog[3], saplog[4] ,saplog[5]);
//       JCO.addClientPool("POOL",  3, "130", "ARBLCLSS" , "clss@123" , "EN", "10.111.0.105","00");
       IRepository repository = JCO.createRepository("REP", "POOL");
       String gateway = "sapgw"+saplog[5];
       for(int i = 0,ser_len=serverConnections.length; i < ser_len; i++) {
           // Server listens for incoming requests from system 1
           // (Change gateway host, service, and program ID according to your needs)
           serverConnections [i] = new ServerRequestHandler
                              (saplog[4],//"10.10.40.24", //10.10.40.195", "10.10.40.132" //gateway host, often the same as host
                              gateway,//"sapgw02", //sapgw01 //gateway service, generally sapgw+<SYSNR>
                              saplog[7],//"ZMWIS_550", //"ZCLSS201", // corresponds to program ID defined in SM59
                              true,
                              repository
                              ,logger);
           serverConnections [i].start();
    }
        }catch(Exception ee){}}
 /*
    public static void startServers()  {
      //JCO.addClientPool("POOL",  3, "550", "test2" ,"welcome1" , "EN", "10.10.40.195" ,"01");
      //10.10.40.24
        DBConnection db = new DBConnection();
        String[][] saplog = db.getSAPlogon("900","asrs");
        System.out.println( saplog[0][1]+"\t"+ saplog[0][2] +"\t"+ saplog[0][3]+"\t" +saplog[0][4]+"\t"+ saplog[0][5] +"\t"+saplog[0][6]);
        //JCO.addClientPool("POOL",  3, "550", "clss" , "welcome2" , "EN", "dbciMRP.mrf.in","02");
//        JCO.addClientPool("POOL",  3, "900", "comm_paints" , "clss1234$" , "EN", "10.10.40.132","03");/*"10.10.40.135""dbciMRF.mrf.in"*/
 /*       JCO.addClientPool("POOL",  3, saplog[0][1], saplog[0][2] , saplog[0][3] ,saplog[0][4], saplog[0][5] ,saplog[0][6]);
       IRepository repository = JCO.createRepository("REP", "POOL");
       String gateway= "sapgw"+saplog[0][6];
       for(int i = 0; i < serverConnections.length; i++) {
           // Server listens for incoming requests from system 1
           // (Change gateway host, service, and program ID according to your needs)
           serverConnections [i] = new ServerRequestHandler
                              (saplog[0][5],//"10.10.40.24", //10.10.40.195", "10.10.40.132",// //gateway host, often the same as host
                               gateway,// "sapgw02", //sapgw01 //gateway service, generally sapgw+<SYSNR>
                              saplog[0][8],//"ZMWIS_900",//"ZMWIS_550", //"ZCLSS201", // corresponds to program ID defined in SM59
                              true,
                              repository);
           serverConnections [i].start();
    }}
*/
    public static void stopServers()  {
       for(int i = 0,ser_len=serverConnections.length; i < ser_len; i++) {
           serverConnections [i].stop();
    }
    }
    public static void main(String[] args)    {
              startServers() ;
    }
}