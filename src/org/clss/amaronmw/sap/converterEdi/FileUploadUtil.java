/**
 *
 * @author yokeshwaran.r
 */
package org.clss.amaronmw.sap.converterEdi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import inx12.X12writer;

public class FileUploadUtil {
	
	public String ediFileWrite(X12writer ediWriter) {
		
		FileOutputStream fos = null;
	    File file;
	    
	    String filePath = "/home/clss/Documents/sample.edi";

	    try {
			  //Specify the file path here
			  file = new File(filePath);
			  fos = new FileOutputStream(file);
			
			  /* This logic will check whether the file
			   * exists or not. If the file is not found
			   * at the specified location it would create
			   * a new file*/
			  if (!file.exists()) {
			     file.createNewFile();
			  }
			
			  /*String content cannot be directly written into
			   * a file. It needs to be converted into bytes
			   */
			  byte[] bytesArray = ediWriter.getOutputData();
			  System.out.println(bytesArray.length);
			
			  fos.write(bytesArray);
			  fos.flush();
			  System.out.println("File Written Successfully");
			  
	     } catch (IOException ioe) {
	    	 ioe.printStackTrace();
	     } finally {
			  try {
			     if (fos != null) 
			     {
			    	 fos.close();
			     }
		      } catch (IOException ioe) {
			     System.out.println("Error in closing the Stream");
			  }
	     }
	    
	    return filePath;
	
	}

}
