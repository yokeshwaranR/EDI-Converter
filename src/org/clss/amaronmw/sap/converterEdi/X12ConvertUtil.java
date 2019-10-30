/**
 *
 * @author yokeshwaran.r
 */
package org.clss.amaronmw.sap.converterEdi;

import inx12.InX12Exception;
import inx12.X12writer;


public class X12ConvertUtil {

	public static void ediWriter() {
		
		FileUploadUtil fileUploadUtil = new FileUploadUtil();
		FTPConnectionUtil ftpConnectionUtil = new FTPConnectionUtil();
		
		String docType = "856";
		
		X12writer ediWriter = new X12writer();
		
		try {

			System.out.println("***************************************************************************");
			System.out.println("* This demo shows how to use Ediwriter to create an EDI document.         *");
			System.out.println("* Several example X12 and EDIFACT documents can be created with this demo.*");
			System.out.println("* Please see the code for details.                                        *");
			System.out.println("***************************************************************************");

			//String docType = args[0];

//			while (!docType.equals("810") && !docType.equals("850") && !docType.equals("855")
//					&& !docType.equals("856")) {
//				docType = prompt("Document Type To Generate [810, 850, 855, 856]");
//				ediWriter.loadSchema(".\\RSSBus_00401_" + docType + ".json");
//			}

			ediWriter.config("Encoding=iso-8859-1");
			
			ediWriter.setSuffix(inx12.X12writer.suffixCRLF);

			// will print output to console
			//ediWriter.setOutputStream(System.out);

			// to save to a file, use
			// ediWriter.setOutputFile("filename.txt");

			// to save data to a string, make sure no OutputFile or OutputStream
			// has been set
			// ediWriter.setOutputFile("");
			// to get data after it has been written, use
			// ediWriter.getOutputData();

			System.out.println("\nGenerating EDI document and printing to console:\n");
			// print correct document
			if (docType.equals("856"))
				writeFile_X12_856(ediWriter, fileUploadUtil, ftpConnectionUtil);

		} catch (InX12Exception ex) {
			System.out.println("InX12 exception thrown: " + ex.getCode() + " [" + ex.getMessage() + "].");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static void writeFile_X12_856(X12writer ediWriter, FileUploadUtil fileUploadUtil, FTPConnectionUtil ftpConnectionUtil) {
		try {
			ediWriter.startInterchangeHeader("004010");
			ediWriter.writeElementString("00");
			ediWriter.skipElement();
			ediWriter.writeElementString("00");
			ediWriter.skipElement();
			ediWriter.writeElementString("ZZ");
			ediWriter.writeElementString("ACME");
			ediWriter.writeElementString("ZZ");
			ediWriter.writeElementString("WAYNE_TECH");
			ediWriter.writeElementString("160707");
			ediWriter.writeElementString("1544");
			ediWriter.writeElementString("U");
			ediWriter.writeElementString("00401");
			ediWriter.writeElementString("000000009");
			ediWriter.writeElementString("0");
			ediWriter.writeElementString("T");
			ediWriter.writeElementString(">");
			ediWriter.endElement();

			ediWriter.startFunctionalGroupHeader();
			ediWriter.writeElementString("SH");
			ediWriter.writeElementString("ACME");
			ediWriter.writeElementString("WAYNE_TECH");
			ediWriter.writeElementString("20160707");
			ediWriter.writeElementString("1544");
			ediWriter.writeElementString("9");
			ediWriter.writeElementString("T");
			ediWriter.writeElementString("004010");
			ediWriter.endElement();

			ediWriter.startTransactionHeader("856");
			ediWriter.writeElementString("856");
			ediWriter.writeElementString("0029");
			ediWriter.endElement();

			ediWriter.startSegment("BSN");
			ediWriter.writeElementString("00");
			ediWriter.writeElementString("0403734501");
			ediWriter.writeElementString("20150708");
			ediWriter.writeElementString("162859");
			ediWriter.endElement();

			ediWriter.startSegment("DTM");
			ediWriter.writeElementString("011");
			ediWriter.writeElementString("20150708");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/HL");
			ediWriter.writeElementString("1");
			ediWriter.skipElement();
			ediWriter.writeElementString("S");
			ediWriter.writeElementString("1");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/PRF");
			ediWriter.writeElementString("0476553696");
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.writeElementString("20150708");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/TD1");
			ediWriter.writeElementString("CNT90");
			ediWriter.writeElementString("0");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/TD5");
			ediWriter.writeElementString("O");
			ediWriter.writeElementString("2");
			ediWriter.writeElementString("FEDX");
			ediWriter.writeElementString("A");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/REF");
			ediWriter.writeElementString("BM");
			ediWriter.writeElementString("EDITEST403734501");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/REF");
			ediWriter.writeElementString("CR");
			ediWriter.writeElementString("4900043704");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/HL");
			ediWriter.writeElementString("2");
			ediWriter.writeElementString("1");
			ediWriter.writeElementString("O");
			ediWriter.writeElementString("1");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/N1Loop1/N1");
			ediWriter.writeElementString("ST");
			ediWriter.writeElementString("Name");
			ediWriter.writeElementString("92");
			ediWriter.writeElementString("0042001808");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/N1Loop1/N1");
			ediWriter.writeElementString("SF");
			ediWriter.writeElementString("NameT");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/N1Loop1/N3");
			ediWriter.writeElementString("Address");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/N1Loop1/N4");
			ediWriter.writeElementString("City");
			ediWriter.writeElementString("SG");
			ediWriter.writeElementString("339942");
			ediWriter.writeElementString("SG");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/HL");
			ediWriter.writeElementString("3");
			ediWriter.writeElementString("2");
			ediWriter.writeElementString("I");
			ediWriter.writeElementString("0");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/LIN");
			ediWriter.writeElementString("10");
			ediWriter.writeElementString("BP");
			ediWriter.writeElementString("335S0548");
			ediWriter.writeElementString("VP");
			ediWriter.writeElementString("Product");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/SN1");
			ediWriter.writeElementString("10");
			ediWriter.writeElementString("1100");
			ediWriter.writeElementString("EA");
			ediWriter.endElement();

			ediWriter.startSegment("HLLoop1/MAN");
			ediWriter.writeElementString("CP");
			ediWriter.writeElementString("Marks");
			ediWriter.endElement();

			ediWriter.startSegment("CTT");
			ediWriter.writeElementString("1");
			ediWriter.endElement();

			ediWriter.createTransactionFooter();

			ediWriter.createFunctionalGroupFooter();

			ediWriter.createInterchangeFooter();
			
			String path = fileUploadUtil.ediFileWrite(ediWriter);
			
			ftpConnectionUtil.ftpFileUpload(path);
			
		} catch (InX12Exception ex) {
			System.out.println("InX12 exception thrown: " + ex.getCode() + " [" + ex.getMessage() + "].");
		}
	}
}
