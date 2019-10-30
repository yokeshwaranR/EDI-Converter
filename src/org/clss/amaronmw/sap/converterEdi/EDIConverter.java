/**
 *
 * @author yokeshwaran.r
 */
package org.clss.amaronmw.sap.converterEdi;

import org.clss.amaronmw.log.ErrorLogger;

import com.sap.mw.jco.JCO;


public class EDIConverter {
	
	ErrorLogger errorLogger;
	
	public EDIConverter(ErrorLogger errorLogger) {
		this.errorLogger = errorLogger;
	}
	
	public static void convertToEDI(JCO.Table table) {
		
	}

}
