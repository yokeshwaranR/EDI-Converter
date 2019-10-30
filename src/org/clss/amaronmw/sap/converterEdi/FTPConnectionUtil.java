/**
 *
 * @author yokeshwaran.r
 */
package org.clss.amaronmw.sap.converterEdi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class FTPConnectionUtil {
	
	public void ftpFileUpload(String filePath) {
		   
        FTPClient client = new FTPClient();
        FileInputStream fis = null;
  
        try {
			client.connect("192.168.1.228 ");
			client.login("devopssudo@outlook.com", "Samsung@123");
			
			boolean isConnected = client.sendNoOp();
			
			if(isConnected) {
				System.out.println("FTP Server connection is established");
			}else{
				System.out.println("FTP Server connection failed");
			}
	 
			// Create an InputStream of the file to be uploaded
			String filename = "sample.edi";
			fis = new FileInputStream(filePath);
			
			// Store file on server and logout
			client.storeFile(filename, fis);
			client.logout();
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
			  try {
				  if (fis != null) {
					  fis.close();
				  }
				  client.disconnect();
		 
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
        }
	    
	}
}
