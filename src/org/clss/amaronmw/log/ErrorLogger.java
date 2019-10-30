/*
 *
---------------------------------------------------------------------

Program Name: ErrorLogger.java

Author      :  Vinoth.R                          Date : 13-Feb-2012

---------------------------------------------------------------------

Description







---------------------------------------------------------------------
Corrections
---------------------------------------------------------------------


Name            Date      Version                ECCO     Reason



---------------------------------------------------------------------
 */
package org.clss.amaronmw.log;
import org.apache.log4j.Logger;

public class ErrorLogger 
{
       private static Logger logger;
       
    public ErrorLogger(String className)
    {
        logger= Logger.getLogger(className);
    }
    public void writeLogInfo(String msg)
    {
        logger.info(msg);
    }
    public void writeLogWarn(String msg)
    {
        logger.warn(msg);
    }
    public void writeLogErr(String msg)
    {
        logger.error(msg);
    }
    public void writeLogErr(String msg,Exception ex)
    {
        logger.error(msg,ex);
    }
    public void println(String msg)
    {
        logger.info(msg);
    }
    public void print(String msg)
    {
        logger.info(msg);
    }
    public void println(Exception msg)
    {
        logger.info(msg);
    }
    public void print(Exception msg)
    {
        logger.info(msg);
    }
    public void println(int msg)
    {
        logger.info(msg);
    }
    public void print(int msg)
    {
        logger.info(msg);
    }
    public void println(char msg)
    {
        logger.info(msg);
    }
    public void print(char msg)
    {
        logger.info(msg);
    }
    public void println(long msg)
    {
        logger.info(msg);
    }
    public void print(long msg)
    {
        logger.info(msg);
    }
    public void println(double msg)
    {
        logger.info(msg);
    }
    public void print(double msg)
    {
        logger.info(msg);
    }    
    public void println(float msg)
    {
        logger.info(msg);
    }
    public void print(float msg)
    {
        logger.info(msg);
    }
    public void println(boolean msg)
    {
        logger.info(msg);
    }
    public void print(boolean msg)
    {
        logger.info(msg);
    }
    public void println(byte msg)
    {
        logger.info(msg);
    }
    public void print(byte msg)
    {
        logger.info(msg);
    }
    public void println()
    {
        logger.info("\n");
    }
    public void print()
    {
        logger.info("");
    }    
    public void println(Object msg)
    {
        logger.info(msg);
    }
    public void print(Object msg)
    {
        logger.info(msg);
    }
    public void println(short msg)
    {
        logger.info(msg);
    }
    public void print(short msg)
    {
        logger.info(msg);
    }
}
