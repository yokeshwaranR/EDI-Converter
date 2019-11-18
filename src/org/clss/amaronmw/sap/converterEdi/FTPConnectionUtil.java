/**
 *
 * @author yokeshwaran.r
 */
package org.clss.amaronmw.sap.converterEdi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import java.util.*;

public class FTPConnectionUtil {
	
	public void ftpFileUpload(String filePath) {
		   
        FTPClient client = new FTPClient();
        FileInputStream fis = null;
  
        try {
			client.connect("192.168.1.228");
			client.login("devopssudo@outlook.com", "Samsung@123");
			
			boolean isConnected = client.sendNoOp();
			
			if(isConnected) {
				System.out.println("FTP Server connection is established");
				// Create an InputStream of the file to be uploaded
				String filename = "sample.edi";
				fis = new FileInputStream(filePath);
				
				// Store file on server and logout
				client.storeFile(filename, fis);
				client.logout();
			}else{
				System.out.println("FTP Server connection failed");
			}
	 
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
	
	public void sftpConnection() throws SftpException {
		System.out.println("Connection SFTP ");
		
		String hostname = "b2bqa.cat.com";
        String login = "ESS09D07";
        String password = "e$FeB5Wsbc";
 
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
 
        JSch ssh = new JSch();
        Session session;
		try {
			session = ssh.getSession(login, hostname, 22);
			session.setConfig(config);
	        session.setPassword(password);
	        session.connect();
	 
	        ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");
	        sftp.connect();
	        
	        System.out.printf("connect() - Connected to %s\n", sftp.isConnected());
	        
	        System.out.printf("directory() - Connected to %s\n", sftp.pwd());
	        
	        //sftp.cd("/sftpuser");
	        	        	 
	        System.err.println(sftp.pwd());
	        
//	        String localFile = "/home/clss/Documents/EDIFACT_0090020133.edi";
//	        String remoteDir = "/Outbox/";
//	      
//	        sftp.put(localFile, remoteDir + "shakti0090020133.edi");
	        
	        sftp.disconnect();
	        session.disconnect();
	        
	        System.out.printf("disconnet() - Disconnected to %s", sftp.isClosed());
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}
	
	
}
