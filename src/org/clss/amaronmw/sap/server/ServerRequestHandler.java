/*
 *
 * ---------------------------------------------------------------------

Program Name: ServerRequestHandler.java
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
import com.sap.mw.jco.JCO.Table;


import org.clss.amaronmw.log.ErrorLogger;
import org.clss.amaronmw.sap.converterEdi.XMLMappingUtil;
public class ServerRequestHandler extends JCO.Server
{
    ErrorLogger logger;
    XMLMappingUtil xmlMappingUtil;
   /**
     *  Create an instance of my own server
     *  @param gwhost (gateway host)
     *  @param gwserv (gateway service number)
     *  @param progid (program id)
     *  @param repository (repository used by the server to lookup the definitions of an inc)
     **/
    public ServerRequestHandler(String gwhost, String gwserv, String progid, IRepository repository,ErrorLogger logger)
    {
        //logger.writeLogInfo("");
               super(gwhost,gwserv,progid,repository);
               this.logger = logger;
    }
   /**
     *  Overrides the default method.
   **/
     //jco.server.unicode=1;
     public ServerRequestHandler(String gwhost, String gwserv, String progid, boolean isUnicode, IRepository repository,ErrorLogger logger)
     {
               super(gwhost,gwserv,progid,repository);
               this.logger = logger;
               this.setProperty("jco.server.unicode", isUnicode?"1":"0");
    }
   //request handler
    protected void handleRequest(JCO.Function function)
    {
    	System.out.println(function.getName());
        try
        {
//            IdocManager ins_idoc = new IdocManager();
            JCO.ParameterList input  = function.getImportParameterList();        
            JCO.ParameterList output = function.getExportParameterList();
            JCO.ParameterList tables = function.getTableParameterList();
            logger.writeLogInfo("handleRequest(" + function.getName() + ")");
            if (function.getName().equals("STFC_CONNECTION"))
            {
                logger.writeLogInfo("STFC_CONNECTION: request " + input.getString("REQUTEXT"));
                output.setValue(input.getString("REQUTEXT"),"ECHOTEXT");
                output.setValue("This is a response from Server :yokesh server ","RESPTEXT");
                logger.writeLogInfo("output : "+output.getString(1));
            }
            else if (function.getName().equals("STFC_STRUCTURE"))
            {
                JCO.Structure sin  = input.getStructure("IMPORTSTRUCT");
                JCO.Structure sout = (JCO.Structure)sin.clone();
                logger.writeLogInfo(tables.getTabName("RFCTABLE"));
                JCO.Table disco=tables.getTable("RFCTABLE");
                logger.writeLogInfo("row count "+disco.getNumRows());
                //output.setValue(firstRecord,"RFCFLOAT");
                output.setValue(sout,"ECHOSTRUCT");
                output.setValue("structure","RESPTEXT");
            }else if (function.getName().equals("IDOC_INBOUND_ASYNCHRONOUS"))
            {
                
            	JCO.Table disco = tables.getTable("IDOC_CONTROL_REC_40");
                logger.writeLogInfo("row count "+disco.getNumRows());
                disco.writeHTML("/home/clss/Documents/idoc_table.html");
                function.writeHTML("/home/clss/Documents/idoc.html");
                disco.writeXML("/home/clss/Documents/idoc_table.xml");
                //output.setValue(firstRecord,"RFCFLOAT");
                System.out.println(disco.getString("DOCNUM"));
                JCO.Table data40 = tables.getTable("IDOC_DATA_REC_40");
                data40.writeHTML("/home/clss/Documents/idoc_table_data40.html");
                System.out.println(data40.getString("SDATA"));
                
            }else if (function.getName().equals("ZBAPI_IDOC_RFC"))
            {
                System.out.print("Calling ZBAPI\n");
                JCO.Table disco = tables.getTable("LT_DATA");
                //JCO.Table disco = tables.getTable("DATA_TABLE");
                //JCO.Table disco0 = tables.getTable("DATA_STRING");
                logger.writeLogInfo("row count "+disco.getNumRows());
                logger.writeLogInfo("data -" +disco.getString("STR"));
                
                //function.writeHTML("/home/clss/Documents/idoc.html");
                //output.setValue(firstRecord,"RFCFLOAT");
                //System.out.println(disco.getString("DOCNUM"));
                //JCO.Table data40 = tables.getTable("IDOC_DATA_REC_40");
//                System.out.println(disco.getString("SDATA"));
                String xmlData = "";
                for(int i=0; i<disco.getNumRows(); i++) {
                	System.out.print(disco.getString("STR"));
                	xmlData += disco.getString("STR");
                	//disco.setValue("JVAL", "STR");
                	disco.nextRow();
                }
                disco.writeHTML("/home/clss/Documents/idoc_table.html");
                xmlMappingUtil.XMLMappingToObject(xmlData);
//              disco.writeXML("/home/clss/Documents/idoc_table.xml");         
                //System.out.print(output.getString("DATA_STRING"));
            }
//            else if (function.getName().equals("ZRFC_TEST"))
//            {
//                
//                //JCO.Table disco = tables.getTable("IDOC_CONTROL_REC_40");
//                JCO.Table disco = tables.getTable("LT_VBRK");
//                logger.writeLogInfo("row count "+disco.getNumRows());
//                disco.writeHTML("/home/clss/Documents/idoc_table.html");
//                function.writeHTML("/home/clss/Documents/idoc.html");
//                //output.setValue(firstRecord,"RFCFLOAT");
//                //System.out.println(disco.getString("DOCNUM"));
//                //JCO.Table data40 = tables.getTable("IDOC_DATA_REC_40");
//                //System.out.println(disco.getString("SDATA"));
//                System.out.println(disco.getString("FKART"));
//            }
                else
          {
//              System.out.println(function.getName());
                String tab = tables.getTabName("RFCTABLE");
                JCO.Table ret_table=tables.getTable(tab);
                //ret_table.writeHTML("D:\\\\un_table.html");
          }
        }
        catch(Exception excep)
        {
//            excep.printStackTrace();
            logger.writeLogErr("ServerRequestHandler", excep);
        }
    }
//    public static void main(String[] args) {
//        String s = "00001 0017 150.000        EA 150.000        EA                       1                                                              374.4             KGM                      D1110                    1     1                                                  385.35                                                8153                                                                    0100";
//        String qty=s.substring(29, (29+15));
//        System.out.println(qty.trim());
//       // logger.writeLogInfo(s.substring(11,26).trim());
//       // ServerRequestHandler obj=new ServerRequestHandler();
//    }
}