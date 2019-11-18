/**
 *
 * @author yokeshwaran.r
 */
package org.clss.amaronmw.sap.converterEdi;

import inedi.Ediwriter;
import inedi.InEDIException;
import inx12.InX12Exception;
import inx12.X12writer;


public class X12ConvertUtil {

	public static void ediWriter() {
		
		FileUploadUtil fileUploadUtil = new FileUploadUtil();
		FTPConnectionUtil ftpConnectionUtil = new FTPConnectionUtil();
		
		String docType = "INVOIC";
		
		//X12writer ediWriter = new X12writer();
		
		Ediwriter ediWriter = new Ediwriter();
		
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
			
			ediWriter.setSuffix(inedi.Ediwriter.suffixCRLF);
			
			ediWriter.setEDIStandard(1);

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
//			if (docType.equals("856"))
//				writeFile_X12_856(ediWriter, fileUploadUtil, ftpConnectionUtil);
			if (docType.equals("INVOIC"))
				writeFile_EDIFACT_INVOIC(ediWriter, fileUploadUtil, ftpConnectionUtil);
				

		} catch (InX12Exception ex) {
			System.out.println("InX12 exception thrown: " + ex.getCode() + " [" + ex.getMessage() + "].");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static void writeFile_EDIFACT_INVOIC(Ediwriter ediWriter, FileUploadUtil fileUploadUtil, FTPConnectionUtil ftpCn) throws InX12Exception, InEDIException {
		System.out.println("Calling Edifact");
		try {
			ediWriter.startInterchangeHeader("D97A");
			ediWriter.startElement();
			ediWriter.writeComponentString("UNOB");
			ediWriter.writeComponentString("1");
			ediWriter.endElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("WAYNE_TECH");
			ediWriter.endElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("ACME");
			ediWriter.endElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("160707");
			ediWriter.writeComponentString("1547");
			ediWriter.endElement();
			ediWriter.writeElementString("000000002");
			ediWriter.startElement();
			ediWriter.writeComponentString("");
			ediWriter.endElement();
			ediWriter.writeElementString("1234");
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.writeElementString("1");
			ediWriter.endElement();

			ediWriter.startTransactionHeader("INVOIC");
			ediWriter.writeElementString("509010117");
			ediWriter.startElement();
			ediWriter.writeComponentString("INVOIC");
			ediWriter.writeComponentString("D");
			ediWriter.writeComponentString("97A");
			ediWriter.writeComponentString("UN");
			ediWriter.endElement();

			ediWriter.startSegment("BGM");
			ediWriter.startElement();
			ediWriter.writeComponentString("380");
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.writeComponentString("TAX INVOICE");
			ediWriter.endElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("0013550417");
			ediWriter.endElement();
			ediWriter.writeElementString("9");
			ediWriter.endElement();

			ediWriter.startSegment("DTM");
			ediWriter.startElement();
			ediWriter.writeComponentString("3");
			ediWriter.writeComponentString("20070926");
			ediWriter.writeComponentString("102");
			ediWriter.endElement();

			ediWriter.startSegment("DTM");
			ediWriter.startElement();
			ediWriter.writeComponentString("4");
			ediWriter.writeComponentString("20061123");
			ediWriter.writeComponentString("102");
			ediWriter.endElement();

			ediWriter.startSegment("FTX");
			ediWriter.writeElementString("AAI");
			ediWriter.writeElementString("1");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/TAX");
			ediWriter.writeElementString("7");
			ediWriter.startElement();
			ediWriter.writeComponentString("VAT");
			ediWriter.endElement();
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.writeComponentString("10072.14");
			ediWriter.writeElementString("S");
			ediWriter.endElement();

			ediWriter.startSegment("CUXLoop1/CUX");
			ediWriter.startElement();
			ediWriter.writeComponentString("2");
			ediWriter.writeComponentString("EUR");
			ediWriter.writeComponentString("4");
			ediWriter.endElement();
			ediWriter.skipElement();
			ediWriter.writeElementString("0.67529");
			ediWriter.endElement();

			ediWriter.startSegment("PATLoop1/PAT");
			ediWriter.writeElementString("1");
			ediWriter.endElement();

			ediWriter.startSegment("PATLoop1/DTM");
			ediWriter.startElement();
			ediWriter.writeComponentString("10");
			ediWriter.writeComponentString("20070926");
			ediWriter.writeComponentString("102");
			ediWriter.endElement();

			ediWriter.startSegment("PATLoop1/PCD");
			ediWriter.startElement();
			ediWriter.writeComponentString("2");
			ediWriter.writeComponentString("0");
			ediWriter.writeComponentString("13");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/LIN");
			ediWriter.writeElementString("000030");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("2265S13");
			ediWriter.writeComponentString("BP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("5029766832002");
			ediWriter.writeComponentString("UP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/IMD");
			ediWriter.writeElementString("F");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/QTY");
			ediWriter.startElement();
			ediWriter.writeComponentString("47");
			ediWriter.writeComponentString("50.000");
			ediWriter.writeComponentString("EA");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/DTM");
			ediWriter.startElement();
			ediWriter.writeComponentString("11");
			ediWriter.writeComponentString("20070926");
			ediWriter.writeComponentString("102");
			ediWriter.endElement();

			ediWriter.startSegment("MOALoop4/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("203");
			ediWriter.writeComponentString("19150.00");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PRILoop1/PRI");
			ediWriter.startElement();
			ediWriter.writeComponentString("INV");
			ediWriter.writeComponentString("383.00");
			ediWriter.writeComponentString("TU");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/TAX");
			ediWriter.writeElementString("7");
			ediWriter.startElement();
			ediWriter.writeComponentString("VAT");
			ediWriter.endElement();
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.writeComponentString("17.500");
			ediWriter.writeElementString("S");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("125");
			ediWriter.writeComponentString("19150.45");
			ediWriter.endElement();

			ediWriter.startSegment("ALCLoop1/ALC");
			ediWriter.writeElementString("C");
			ediWriter.startElement();
			ediWriter.writeComponentString("0.45");
			ediWriter.endElement();
			ediWriter.writeElementString("");
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("FC");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("8");
			ediWriter.writeComponentString("0.45");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/LIN");
			ediWriter.writeElementString("000040");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("2269F22");
			ediWriter.writeComponentString("BP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("5051254078241");
			ediWriter.writeComponentString("UP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/IMD");
			ediWriter.writeElementString("F");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/QTY");
			ediWriter.startElement();
			ediWriter.writeComponentString("47");
			ediWriter.writeComponentString("20.000");
			ediWriter.writeComponentString("EA");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/DTM");
			ediWriter.startElement();
			ediWriter.writeComponentString("11");
			ediWriter.writeComponentString("20070926");
			ediWriter.writeComponentString("102");
			ediWriter.endElement();

			ediWriter.startSegment("MOALoop4/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("203");
			ediWriter.writeComponentString("21060.00");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PRILoop1/PRI");
			ediWriter.startElement();
			ediWriter.writeComponentString("INV");
			ediWriter.writeComponentString("1053.00");
			ediWriter.writeComponentString("TU");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/TAX");
			ediWriter.writeElementString("7");
			ediWriter.startElement();
			ediWriter.writeComponentString("VAT");
			ediWriter.endElement();
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.writeComponentString("17.500");
			ediWriter.writeElementString("S");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("125");
			ediWriter.writeComponentString("21060.50");
			ediWriter.endElement();

			ediWriter.startSegment("ALCLoop1/ALC");
			ediWriter.writeElementString("C");
			ediWriter.startElement();
			ediWriter.writeComponentString("0.50");
			ediWriter.endElement();
			ediWriter.writeElementString("");
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("FC");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("8");
			ediWriter.writeComponentString("0.50");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/LIN");
			ediWriter.writeElementString("000170");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("2269F10");
			ediWriter.writeComponentString("BP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("5051254078326");
			ediWriter.writeComponentString("UP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/IMD");
			ediWriter.writeElementString("F");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/QTY");
			ediWriter.startElement();
			ediWriter.writeComponentString("47");
			ediWriter.writeComponentString("10.000");
			ediWriter.writeComponentString("EA");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/DTM");
			ediWriter.startElement();
			ediWriter.writeComponentString("11");
			ediWriter.writeComponentString("20070926");
			ediWriter.writeComponentString("102");
			ediWriter.endElement();

			ediWriter.startSegment("MOALoop4/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("203");
			ediWriter.writeComponentString("6950.00");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PRILoop1/PRI");
			ediWriter.startElement();
			ediWriter.writeComponentString("INV");
			ediWriter.writeComponentString("695.00");
			ediWriter.writeComponentString("TU");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/TAX");
			ediWriter.writeElementString("7");
			ediWriter.startElement();
			ediWriter.writeComponentString("VAT");
			ediWriter.endElement();
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.writeComponentString("17.500");
			ediWriter.writeElementString("S");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("125");
			ediWriter.writeComponentString("6950.16");
			ediWriter.endElement();

			ediWriter.startSegment("ALCLoop1/ALC");
			ediWriter.writeElementString("C");
			ediWriter.startElement();
			ediWriter.writeComponentString("0.16");
			ediWriter.endElement();
			ediWriter.writeElementString("");
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("FC");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("8");
			ediWriter.writeComponentString("0.16");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/LIN");
			ediWriter.writeElementString("000190");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("2269F26");
			ediWriter.writeComponentString("BP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("5051254051190");
			ediWriter.writeComponentString("UP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/IMD");
			ediWriter.writeElementString("F");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/QTY");
			ediWriter.startElement();
			ediWriter.writeComponentString("47");
			ediWriter.writeComponentString("5.000");
			ediWriter.writeComponentString("EA");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/DTM");
			ediWriter.startElement();
			ediWriter.writeComponentString("11");
			ediWriter.writeComponentString("20070926");
			ediWriter.writeComponentString("102");
			ediWriter.endElement();

			ediWriter.startSegment("MOALoop4/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("203");
			ediWriter.writeComponentString("2375.00");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PRILoop1/PRI");
			ediWriter.startElement();
			ediWriter.writeComponentString("INV");
			ediWriter.writeComponentString("475.00");
			ediWriter.writeComponentString("TU");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/TAX");
			ediWriter.writeElementString("7");
			ediWriter.startElement();
			ediWriter.writeComponentString("VAT");
			ediWriter.endElement();
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.writeComponentString("17.500");
			ediWriter.writeElementString("S");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("125");
			ediWriter.writeComponentString("2375.06");
			ediWriter.endElement();

			ediWriter.startSegment("ALCLoop1/ALC");
			ediWriter.writeElementString("C");
			ediWriter.startElement();
			ediWriter.writeComponentString("0.06");
			ediWriter.endElement();
			ediWriter.writeElementString("");
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("FC");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("8");
			ediWriter.writeComponentString("0.06");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/LIN");
			ediWriter.writeElementString("000200");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("2265S24");
			ediWriter.writeComponentString("BP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("5029766000685");
			ediWriter.writeComponentString("UP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/IMD");
			ediWriter.writeElementString("F");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/QTY");
			ediWriter.startElement();
			ediWriter.writeComponentString("47");
			ediWriter.writeComponentString("3.000");
			ediWriter.writeComponentString("EA");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/DTM");
			ediWriter.startElement();
			ediWriter.writeComponentString("11");
			ediWriter.writeComponentString("20070926");
			ediWriter.writeComponentString("102");
			ediWriter.endElement();

			ediWriter.startSegment("MOALoop4/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("203");
			ediWriter.writeComponentString("957.00");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PRILoop1/PRI");
			ediWriter.startElement();
			ediWriter.writeComponentString("INV");
			ediWriter.writeComponentString("319.00");
			ediWriter.writeComponentString("TU");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/TAX");
			ediWriter.writeElementString("7");
			ediWriter.startElement();
			ediWriter.writeComponentString("VAT");
			ediWriter.endElement();
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.writeComponentString("17.500");
			ediWriter.writeElementString("S");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("125");
			ediWriter.writeComponentString("957.02");
			ediWriter.endElement();

			ediWriter.startSegment("ALCLoop1/ALC");
			ediWriter.writeElementString("C");
			ediWriter.startElement();
			ediWriter.writeComponentString("0.02");
			ediWriter.endElement();
			ediWriter.writeElementString("");
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("FC");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("8");
			ediWriter.writeComponentString("0.02");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/LIN");
			ediWriter.writeElementString("000210");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("2263T95");
			ediWriter.writeComponentString("BP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("5029766699575");
			ediWriter.writeComponentString("UP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/IMD");
			ediWriter.writeElementString("F");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/QTY");
			ediWriter.startElement();
			ediWriter.writeComponentString("47");
			ediWriter.writeComponentString("3.000");
			ediWriter.writeComponentString("EA");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/DTM");
			ediWriter.startElement();
			ediWriter.writeComponentString("11");
			ediWriter.writeComponentString("20070926");
			ediWriter.writeComponentString("102");
			ediWriter.endElement();

			ediWriter.startSegment("MOALoop4/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("203");
			ediWriter.writeComponentString("2085.00");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PRILoop1/PRI");
			ediWriter.startElement();
			ediWriter.writeComponentString("INV");
			ediWriter.writeComponentString("695.00");
			ediWriter.writeComponentString("TU");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/TAX");
			ediWriter.writeElementString("7");
			ediWriter.startElement();
			ediWriter.writeComponentString("VAT");
			ediWriter.endElement();
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.writeComponentString("17.500");
			ediWriter.writeElementString("S");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("125");
			ediWriter.writeComponentString("2085.05");
			ediWriter.endElement();

			ediWriter.startSegment("ALCLoop1/ALC");
			ediWriter.writeElementString("C");
			ediWriter.startElement();
			ediWriter.writeComponentString("0.05");
			ediWriter.endElement();
			ediWriter.writeElementString("");
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("FC");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("8");
			ediWriter.writeComponentString("0.05");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/LIN");
			ediWriter.writeElementString("000250");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("2269F15");
			ediWriter.writeComponentString("BP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PIA");
			ediWriter.writeElementString("1");
			ediWriter.startElement();
			ediWriter.writeComponentString("5051254080091");
			ediWriter.writeComponentString("UP");
			ediWriter.skipComponent();
			ediWriter.writeComponentString("92");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/IMD");
			ediWriter.writeElementString("F");
			ediWriter.writeElementString("");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/QTY");
			ediWriter.startElement();
			ediWriter.writeComponentString("47");
			ediWriter.writeComponentString("3.000");
			ediWriter.writeComponentString("EA");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/DTM");
			ediWriter.startElement();
			ediWriter.writeComponentString("11");
			ediWriter.writeComponentString("20070926");
			ediWriter.writeComponentString("102");
			ediWriter.endElement();

			ediWriter.startSegment("MOALoop4/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("203");
			ediWriter.writeComponentString("4977.00");
			ediWriter.endElement();

			ediWriter.startSegment("LINLoop1/PRILoop1/PRI");
			ediWriter.startElement();
			ediWriter.writeComponentString("INV");
			ediWriter.writeComponentString("1659.00");
			ediWriter.writeComponentString("TU");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/TAX");
			ediWriter.writeElementString("7");
			ediWriter.startElement();
			ediWriter.writeComponentString("VAT");
			ediWriter.endElement();
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.writeComponentString("17.500");
			ediWriter.writeElementString("S");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("125");
			ediWriter.writeComponentString("4977.12");
			ediWriter.endElement();

			ediWriter.startSegment("ALCLoop1/ALC");
			ediWriter.writeElementString("C");
			ediWriter.startElement();
			ediWriter.writeComponentString("0.12");
			ediWriter.endElement();
			ediWriter.writeElementString("");
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("FC");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("8");
			ediWriter.writeComponentString("0.12");
			ediWriter.endElement();

			ediWriter.startSegment("UNS");
			ediWriter.writeElementString("S");
			ediWriter.endElement();

			ediWriter.startSegment("CNT");
			ediWriter.startElement();
			ediWriter.writeComponentString("4");
			ediWriter.writeComponentString("7");
			ediWriter.endElement();

			ediWriter.startSegment("MOALoop4/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("9");
			ediWriter.writeComponentString("67627.50");
			ediWriter.endElement();

			ediWriter.startSegment("MOALoop4/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("79");
			ediWriter.writeComponentString("57554.00");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/TAX");
			ediWriter.writeElementString("7");
			ediWriter.startElement();
			ediWriter.writeComponentString("VAT");
			ediWriter.endElement();
			ediWriter.skipElement();
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.skipComponent();
			ediWriter.writeComponentString("17.500");
			ediWriter.writeElementString("S");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("125");
			ediWriter.writeComponentString("57555.36");
			ediWriter.writeComponentString("EUR");
			ediWriter.writeComponentString("3");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("124");
			ediWriter.writeComponentString("10072.14");
			ediWriter.writeComponentString("EUR");
			ediWriter.writeComponentString("3");
			ediWriter.endElement();

			ediWriter.startSegment("ALCLoop1/ALC");
			ediWriter.writeElementString("C");
			ediWriter.startElement();
			ediWriter.writeComponentString("1.36");
			ediWriter.endElement();
			ediWriter.writeElementString("");
			ediWriter.skipElement();
			ediWriter.startElement();
			ediWriter.writeComponentString("FC");
			ediWriter.endElement();

			ediWriter.startSegment("TAXLoop1/MOA");
			ediWriter.startElement();
			ediWriter.writeComponentString("8");
			ediWriter.writeComponentString("1.36");
			ediWriter.endElement();

			ediWriter.createTransactionFooter();

			ediWriter.createInterchangeFooter();
			
			String path = fileUploadUtil.ediFileWrite(ediWriter);
			
			ftpCn.ftpFileUpload(path);
			
			
		} catch (InEDIException ex) {
			System.out.println("InEDIException thrown: " + ex.getCode() + " [" + ex.getMessage() + "].");
		}
	}

	
}
