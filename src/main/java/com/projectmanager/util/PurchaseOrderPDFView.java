package com.projectmanager.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.pdf.*;
import com.projectmanager.dao.TaxesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.projectmanager.entity.PODetails;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;

@Component("purchaseOrderView")
public class PurchaseOrderPDFView extends AbstractView {

	@Autowired
	Principal principal;

	@Autowired
	NumberWordConverter numberWordConverter;

	@Autowired
	TaxesDao taxesDao;

	@Override
	public void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		PODetails poDetails = (PODetails) model.get("poDetails");
		String poLineDetails = (String) model.get("poLineDetails");

		String[] poLines = poLineDetails.split(";");
        System.out.println(poLines.length);
		String[] description = new String[poLines.length];
		System.out.println(description.length);
		String[] quantity = new String[poLines.length];
		String[] unitPrice = new String[poLines.length];

		String[] make = new String[poLines.length];
		String[] terms = poDetails.getTerm();

		int index = 0;
		for (String poLine : poLines) {
			System.out.println(poLine);
			String[] details = poLine.split(",");
			description[index] = details[1];
			quantity[index] = details[2];
			unitPrice[index] = details[3];
			index++;

		}

		// Save poDetails.getPoNumber() + ".pdf" in io.temp
		try {
			String userName = (String) model.get("userName");
			String destination = System.getProperty("java.io.tmpdir") + "/" + userName + "/"
                    + poDetails.getPoNumber().replace("/", "_")
					+ ".pdf";

			File fileToSave = new File(destination);
			fileToSave.getParentFile().mkdirs();

			FileOutputStream fOut = new FileOutputStream(fileToSave);

			generatePO("-", "27AEBPH1001B1ZM", poDetails.getPoNumber(), poDetails.getPoDate(),
					poDetails.getVendorName(), "", poDetails.getContactName(), poDetails.getContactNumber(),
					poDetails.getContactEmail(),
					poDetails.getVendorGst(), poDetails.getVendorPan(),make, description, quantity, unitPrice, terms, response, fOut);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void generatePO(String vatTin, String gstNo, String purhaseOrderNo, String purhaseOrderDate,
			String venderName, String venderLocation, String receiverName, String receiverNo, String receiverEmail, String venderGst, String venderPan,
			String[] make, String[] description, String[] quantity, String[] unitPrice, String[] term,
			HttpServletResponse response, FileOutputStream fOut) {

		try {

			Document document = new Document();

			PdfWriter writer = PdfWriter.getInstance(document, fOut);

            writer.setPageEvent(new BackgroundImageHelper());

			document.open();

			ArrayList<String[]> descriptionList = new ArrayList<>();

			int pages = Math.round(description.length / 10) + 1;

			try {
				for (int i = 0; i < pages; i++) {

					int end = 10 * i + 9;
					if (description.length < 10 * i + 10) {
						System.out.println(description.length < 10 * i + 10);
						end = description.length - 1;
					}
					String[] newArray = Arrays.copyOfRange(description, 1 * i, end);
					System.out.println(newArray);
					descriptionList.add(newArray);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			for (String[] desc : descriptionList) {
				generatePage(document, gstNo, purhaseOrderNo, purhaseOrderDate, venderName, venderLocation,
						receiverName, receiverNo, receiverEmail, venderGst, venderPan, desc, unitPrice, quantity, make, term, writer);
			}

			document.close();
			writer.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected PdfPTable createNewTable(int numberOfColumns) {
		PdfPTable table = new PdfPTable(numberOfColumns);
		table.setWidthPercentage(95);

		return table;
	}

	protected PdfPCell createNewCell(Paragraph ph) {
		PdfPCell cell = new PdfPCell(ph);
		cell.setFixedHeight(15);
		return cell;
	}

	protected PdfPCell createNewCell(Paragraph ph, int fixedHeight) {
		PdfPCell cell = new PdfPCell(ph);
		cell.setFixedHeight(fixedHeight);
		return cell;
	}

	protected PdfPCell createNewCell(int fixedHeight) {
		PdfPCell cell = new PdfPCell(new Paragraph());
		cell.setFixedHeight(fixedHeight);
		return cell;
	}

	protected void generatePage(Document document, String gstNo, String purhaseOrderNo, String purhaseOrderDate,
			String venderName, String venderLocation, String receiverName, String receiverNo, String receiverEmail, String vendorGst, String vendorPan,
			String[] description, String[] unitPrice, String[] quantity, String[] make, String[] term,
			PdfWriter writer) {
		try {

            //table1
            PdfPTable table = createNewTable(1);

            // Row1
            Paragraph ph = new Paragraph("PURCHASE ORDER", blackCalibri14);
            ph.setAlignment(Element.ALIGN_MIDDLE);

            PdfPCell c1 = createNewCell(ph);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            c1.setFixedHeight(20);

            table.addCell(c1);
                    
            document.add(table);

            // Table2
            PdfPTable table2 = createNewTable(3);

            float[] colWidts = {4f, 4f, 5f};

            table2.setWidths(colWidts);
            //Row2
            Paragraph ph2 = new Paragraph("Offer No.:-224/18-19", boldBlackCalibri10);
            ph2.setAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r2c1 = createNewCell(ph2);
            r2c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            r2c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            r2c1.setFixedHeight(20);
            
            Paragraph ph3 = new Paragraph("PO No.:- "+ purhaseOrderNo, boldBlackCalibri10);
            ph2.setAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r2c2 = createNewCell(ph3);
            r2c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            r2c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            r2c1.setFixedHeight(20);
            
            Paragraph ph4 = new Paragraph("Date:-"+ purhaseOrderDate, boldBlackCalibri10);
            ph2.setAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r2c3 = createNewCell(ph4);
            r2c3.setHorizontalAlignment(Element.ALIGN_CENTER);
            r2c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            r2c1.setFixedHeight(20);

            table2.addCell(r2c1);
            table2.addCell(r2c2);
            table2.addCell(r2c3);
            
            //Row3

            PdfPCell shipToCell = createNewCell(120);
            shipToCell.addElement(new Paragraph("Billing to", blackCalibri9));
            shipToCell.addElement(new Paragraph("PECO Projects Pvt Ltd", boldBlackCalibri10));
            shipToCell.addElement(new Paragraph("A-601, Silver Oaks,", blackCalibri9));
            shipToCell.addElement(new Paragraph("Gat No.275, Borhadewadi", blackCalibri9));
            shipToCell.addElement(new Paragraph("Moshi, Pune-412 105", blackCalibri9));
            shipToCell.addElement(new Paragraph("Phone:- +91 20 65300352", blackCalibri9));
            shipToCell.addElement(new Paragraph("email:- info@pecoprojects.com", blackCalibri9));
            shipToCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            shipToCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            shipToCell.setFixedHeight(120);
            
            PdfPCell shipToCell2 = createNewCell(120);
            shipToCell2.addElement(new Paragraph("Vendor", blackCalibri9));
            shipToCell2.addElement(new Paragraph(venderName, boldBlackCalibri10));
            shipToCell2.addElement(new Paragraph(venderLocation, blackCalibri9));
            shipToCell2.addElement(new Paragraph(venderLocation, blackCalibri9));
            shipToCell2.addElement(new Paragraph(venderLocation, blackCalibri9));
            shipToCell2.addElement(new Paragraph("", blackCalibri9));
            shipToCell2.addElement(new Paragraph(receiverEmail, blackCalibri9));
            shipToCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            shipToCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            shipToCell2.setFixedHeight(120);
            
            PdfPCell shipToCell3 = createNewCell(120);
            shipToCell3.addElement(new Paragraph("Ship to", blackCalibri9));
            shipToCell3.addElement(new Paragraph(venderName, boldBlackCalibri10));
            shipToCell3.addElement(new Paragraph("", blackCalibri11));
            shipToCell3.addElement(new Paragraph(venderLocation, blackCalibri9));
            shipToCell3.addElement(new Paragraph("", blackCalibri9));
            shipToCell3.addElement(new Paragraph("", blackCalibri9));
            shipToCell3.addElement(new Paragraph(".", blackCalibri9));
            shipToCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            shipToCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            shipToCell3.setFixedHeight(120);


            table2.addCell(shipToCell);
            table2.addCell(shipToCell2);
            table2.addCell(shipToCell3);
            
            document.add(table2);
            //table3
            PdfPTable table3 = createNewTable(1);
            // Row4
            Paragraph ph5 = new Paragraph("Dear Sir, With reference to your above quotation, we request you to supply the\r\n" + 
            		"following materials / services subject to terms and conditions mentioned.", blackCalibri9);
            ph.setAlignment(Element.ALIGN_MIDDLE);

            PdfPCell t3c1 = createNewCell(ph5);
            t3c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            t3c1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            t3c1.setFixedHeight(30);

            table3.addCell(t3c1);
                    
            document.add(table3);
            
            //table4
            PdfPTable table4 = createNewTable(5);
            
            float[] colWidts1 = {1f, 5f, 2f, 2f, 3f};

            table4.setWidths(colWidts1);
            //Row5
            
            PdfPCell r5c1 = createNewCell(new Paragraph("Sr. No.", blackCalibri10));
            r5c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            r5c1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r5c1.setFixedHeight(20);
           
            PdfPCell r5c2 = createNewCell(new Paragraph("Description", blackCalibri10));
            r5c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            r5c2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r5c2.setFixedHeight(20);
            
            PdfPCell r5c3 = createNewCell(new Paragraph("Qunatity ", blackCalibri10));
            r5c3.addElement(new Paragraph("(MTRS.)", blackCalibri10));
            r5c3.setHorizontalAlignment(Element.ALIGN_CENTER);
            r5c3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r5c3.setFixedHeight(20);
           
            PdfPCell r5c4 = createNewCell(new Paragraph("Inch-Mtr Rate", blackCalibri10));
            r5c4.addElement(new Paragraph("(INR)", blackCalibri10));
            r5c4.setHorizontalAlignment(Element.ALIGN_CENTER);
            r5c4.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r5c4.setFixedHeight(20);
           
            PdfPCell r5c5 = createNewCell(new Paragraph("Total Amount", blackCalibri10));
            r5c5.addElement(new Paragraph("(INR)", blackCalibri10));
            r5c5.setHorizontalAlignment(Element.ALIGN_CENTER);
            r5c5.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r5c5.setFixedHeight(20);
           

            table4.addCell(r5c1);
            table4.addCell(r5c2);
            table4.addCell(r5c3);
            table4.addCell(r5c4);
            table4.addCell(r5c5);
            
            
            double GstTotal = 0.0;

            double discountTotal = 0.0;
            
			double subTotal = 0.0;
			
			double allTotal = 0.0;

			String total = "";
			String Gst = "";
			String Discount= "";
            //Row6
            for (int i = 0; i < description.length; i++) {
            	
            	total = String.valueOf(Double.parseDouble(unitPrice[i]) * Double.parseDouble(quantity[i]));

				Gst = String.valueOf(Double.parseDouble(total) * 18 / 100);
				
				Discount = String.valueOf(Double.parseDouble(total) * 0 / 100);
				
            PdfPCell r6c1 = createNewCell(new Paragraph(String.valueOf(i + 1), blackCalibri9));
            r6c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            r6c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r6c1.setFixedHeight(30);
           
            PdfPCell r6c2 = createNewCell(new Paragraph(description[i].replace("~", ""), boldBlackCalibri10));
            r6c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            r6c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r6c2.setFixedHeight(30);
            
            PdfPCell r6c3 = createNewCell(new Paragraph(quantity[i], blackCalibri9));
            r6c3.setHorizontalAlignment(Element.ALIGN_CENTER);
            r6c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r6c3.setFixedHeight(30);
           
            PdfPCell r6c4 = createNewCell(new Paragraph(unitPrice[i], blackCalibri9));
            r6c4.setHorizontalAlignment(Element.ALIGN_CENTER);
            r6c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r6c4.setFixedHeight(30);
           
            PdfPCell r6c5 = createNewCell(new Paragraph(total, blackCalibri9));
            r6c5.setHorizontalAlignment(Element.ALIGN_CENTER);
            r6c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r6c5.setFixedHeight(30);
           

            table4.addCell(r6c1);
            table4.addCell(r6c2);
            table4.addCell(r6c3);
            table4.addCell(r6c4);
            table4.addCell(r6c5);
            
            GstTotal = Double.parseDouble(total)+ Double.parseDouble(Gst);

			subTotal += Double.parseDouble(total);
						
			discountTotal = Double.parseDouble(total)+Double.parseDouble(Discount);
			
			allTotal = Math.round(GstTotal + discountTotal);
			
			
            }

            //Row7
           for (int i = 0; i < 9 - description.length; i++) {
            PdfPCell r7c1 = createNewCell(new Paragraph("", blackCalibri9));
            r7c1.setFixedHeight(30);
           
            PdfPCell r7c2 = createNewCell(new Paragraph("", blackCalibri9));
             r7c2.setFixedHeight(30);
            
            PdfPCell r7c3 = createNewCell(new Paragraph("", blackCalibri9));
             r7c3.setFixedHeight(30);
           
            PdfPCell r7c4 = createNewCell(new Paragraph("", blackCalibri9));
            r7c4.setFixedHeight(30);
           
            PdfPCell r7c5 = createNewCell(new Paragraph("", blackCalibri9));
            r7c5.setFixedHeight(30);
           

            table4.addCell(r7c1);
            table4.addCell(r7c2);
            table4.addCell(r7c3);
            table4.addCell(r7c4);
            table4.addCell(r7c5);
            }
           document.add(table4);
            
            //table5
            PdfPTable table5 = createNewTable(5);
            
            float[] colWidts2 = {3f, 1f, 2f, 4f, 3f};

            table5.setWidths(colWidts2);
            
            //Row9
            PdfPCell r9c1 = createNewCell(new Paragraph("GST", blackCalibri10));
            r9c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            r9c1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r9c1.setFixedHeight(30);
           
            PdfPCell r9c2 = createNewCell(new Paragraph("18.0%", blackCalibri10));
            r9c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            r9c2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r9c2.setFixedHeight(30);
            
            PdfPCell r9c3 = createNewCell(new Paragraph(Gst, blackCalibri10));
            r9c3.setHorizontalAlignment(Element.ALIGN_CENTER);
            r9c3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r9c3.setFixedHeight(30);
           
            PdfPCell r9c4 = createNewCell(new Paragraph("Total", blackCalibri10));
            r9c4.setHorizontalAlignment(Element.ALIGN_CENTER);
            r9c4.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r9c4.setFixedHeight(30);
           
            PdfPCell r9c5 = createNewCell(new Paragraph(String.valueOf(GstTotal), blackCalibri10));
            r9c5.setHorizontalAlignment(Element.ALIGN_CENTER);
            r9c5.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r9c5.setFixedHeight(30);
           

            table5.addCell(r9c1);
            table5.addCell(r9c2);
            table5.addCell(r9c3);
            table5.addCell(r9c4);
            table5.addCell(r9c5);
            

            //Row10
            PdfPCell r10c1 = createNewCell(new Paragraph("Discount", blackCalibri10));
            r10c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            r10c1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r10c1.setFixedHeight(30);
           
            PdfPCell r10c2 = createNewCell(new Paragraph("0.0%", blackCalibri11));
            r10c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            r10c2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r10c2.setFixedHeight(30);
            
            PdfPCell r10c3 = createNewCell(new Paragraph(Discount, blackCalibri10));
            r10c3.setHorizontalAlignment(Element.ALIGN_CENTER);
            r10c3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r10c3.setFixedHeight(30);
           
            PdfPCell r10c4 = createNewCell(new Paragraph("Final Amount", blackCalibri10));
            r10c4.setHorizontalAlignment(Element.ALIGN_CENTER);
            r10c4.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r10c4.setFixedHeight(30);
           
            PdfPCell r10c5 = createNewCell(new Paragraph(String.valueOf(discountTotal), blackCalibri10));
            r10c5.setHorizontalAlignment(Element.ALIGN_CENTER);
            r10c5.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r10c5.setFixedHeight(30);
           

            table5.addCell(r10c1);
            table5.addCell(r10c2);
            table5.addCell(r10c3);
            table5.addCell(r10c4);
            table5.addCell(r10c5);
            

           
            document.add(table5);
            
            //table6
            
            PdfPTable table6 = createNewTable(2);

            float[] colWidts3 = {10f, 3f};

            table6.setWidths(colWidts3);
            //Row11
            Paragraph ph6 = new Paragraph("Total PO Value", boldBlackCalibri10);
            ph6.setAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r11c1 = createNewCell(ph6);
            r11c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            r11c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            r11c1.setFixedHeight(20);
            
            Paragraph ph7 = new Paragraph(String.valueOf(allTotal), blackCalibri10 );
            ph2.setAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r11c2 = createNewCell(ph7);
            r11c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            r11c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            r11c2.setFixedHeight(20);
            
            table6.addCell(r11c1);
            table6.addCell(r11c2);

            document.add(table6);
            
            //table7
            PdfPTable table7 = createNewTable(1);

            String amountInWords = "";

			if (gstNo.startsWith("27")) {
				amountInWords = numberWordConverter.convert((int) Math.round(subTotal + GstTotal + discountTotal));
			} else {
				amountInWords = numberWordConverter.convert((int) Math.round(subTotal + GstTotal + discountTotal));
			}
            // Row12
            Paragraph ph8 = new Paragraph("Total Amount (In Words) :-    "   + amountInWords, blackCalibri9);
           
            PdfPCell r12c1 = createNewCell(ph8);

            r12c1.setFixedHeight(20);

            table7.addCell(r12c1);

            //row13
            Paragraph ph9 = new Paragraph("A. Payment Terms:-", boldBlackCalibri10);
            PdfPCell r13c1 = createNewCell(ph9);
            r13c1.setFixedHeight(20);

            table7.addCell(r13c1);
                    
            document.add(table7);
            
            //table8
            PdfPTable table8 = createNewTable(2);

            float[] colWidts4 = {6f, 7f};

            table8.setWidths(colWidts4);

            //row14
            PdfPCell ship14ToCell1 = createNewCell(120);
            ship14ToCell1.addElement(new Paragraph("B. Vendor Tax reg. details:-", boldBlackCalibri10));
            ship14ToCell1.addElement(new Paragraph("VAT     ", blackCalibri9));
            ship14ToCell1.addElement(new Paragraph("CST     ", blackCalibri9));
            ship14ToCell1.addElement(new Paragraph("GST     " +vendorGst, blackCalibri9));
            ship14ToCell1.addElement(new Paragraph("PAN     " + vendorPan, blackCalibri9));
           
            ship14ToCell1.setFixedHeight(80);
            
            PdfPCell shipTo14Cell2 = createNewCell(120);
            shipTo14Cell2.addElement(new Paragraph("C. Our Tax reg. details:-", boldBlackCalibri10));
            shipTo14Cell2.addElement(new Paragraph("VAT        " +  		"   27251164635V", blackCalibri9));
            shipTo14Cell2.addElement(new Paragraph("CST        " +     		"   27251164635C", blackCalibri9));
            shipTo14Cell2.addElement(new Paragraph("SERVICE TAX" +  		"   AAICP1433DSD001", blackCalibri9));
            shipTo14Cell2.addElement(new Paragraph("PAN        " +          "   AAICP1433D", blackCalibri9));

            shipTo14Cell2.setFixedHeight(80);
            table8.addCell(ship14ToCell1);
            table8.addCell(shipTo14Cell2);
            
            //row15
            PdfPCell ship15ToCell1 = createNewCell(120);
            ship15ToCell1.addElement(new Paragraph("D. Buyer Details:-", boldBlackCalibri10));
            ship15ToCell1.addElement(new Paragraph("Buyer Name:- C Suresh", blackCalibri9));
            ship15ToCell1.addElement(new Paragraph("Contact No:- +91 9765895255/+91 2065300352", blackCalibri9));
            ship15ToCell1.addElement(new Paragraph("Email Id: csuresh@pecoprojects.com", blackCalibri9));
           
           
            ship15ToCell1.setFixedHeight(200);
            
            PdfPCell shipTo15Cell2 = createNewCell(120);
            Paragraph ph10 = new Paragraph("FOR PECO PROJECTS PVT LTD", blackCalibri10);
            ph10.setAlignment(Element.ALIGN_CENTER);
            shipTo15Cell2.addElement(ph10);
            
           try {

                //File file = ResourceUtils.getFile("stamp.png");
                Resource resource = new ClassPathResource("stamp.png");

                File file = resource.getFile();

                // init array with file length
                byte[] bytesArray = new byte[(int) file.length()];

                FileInputStream fis = new FileInputStream(file);
                fis.read(bytesArray); // read file into bytes[]
                fis.close();

                Image signImg = Image.getInstance(bytesArray);
                shipTo15Cell2.addElement(signImg);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
           
            Paragraph ph11 = new Paragraph("(Authorized Signatory & Stamp)", blackCalibri10);
            ph11.setAlignment(Element.ALIGN_CENTER);
            shipTo15Cell2.addElement(ph11);
            shipTo15Cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            shipTo15Cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            shipTo15Cell2.setFixedHeight(200);
            
            table8.addCell(ship15ToCell1);
            table8.addCell(shipTo15Cell2);
            document.add(table8);
            
            //table9
            PdfPTable table9 = createNewTable(1);

            // Row1
            Paragraph ph14 = new Paragraph("E. Terms & Conditions:-", boldBlackCalibri10);

            PdfPCell r17c1 = createNewCell(ph14);
            r17c1.setFixedHeight(20);

            table9.addCell(r17c1);
            
            PdfPCell shipTo18Cell2 = createNewCell(120);
            Paragraph ph15 = new Paragraph("General Scope:-", boldBlackCalibri10);
            //ph.setAlignment(Element.ALIGN_MIDDLE);
            shipTo18Cell2.addElement(ph15);
            shipTo18Cell2.addElement(new Paragraph("1. Manpower boarding & lodging in our scope, excluding food.", blackCalibri9));
            shipTo18Cell2.addElement(new Paragraph("2. Drinking Water & Toiltes facilities shall be arranged by end client.", blackCalibri9));
            shipTo18Cell2.addElement(new Paragraph("3. All required machinery, tools & tackles shall be provided by Client.", blackCalibri9));
            shipTo18Cell2.addElement(new Paragraph("4. All the workers shall be completed with Police Verification for site premises entry.", blackCalibri9));

            shipTo18Cell2.setFixedHeight(80);

            table9.addCell(shipTo18Cell2);
            
            
            PdfPCell shipTo19Cell2 = createNewCell(200);
            Paragraph ph16 = new Paragraph("Billing Instruction:-", boldBlackCalibri10);
           
            shipTo19Cell2.addElement(ph16);
            shipTo19Cell2.addElement(new Paragraph("1. Please raise your Bill/invoice in favour of PECO Projects Private Limited - Pune, in duplicate and submit it to official placing this  purchase order  with a  reference to the  purchase order and Section/Unit wherefrom the order is placed  enclosing  a copy of your delivery challan duly signed by the recipient of the goods/service.  ", blackCalibri9));
            shipTo19Cell2.addElement(new Paragraph("2. The price of any item mentioned in this order should not exceed the accepted price. The quantity/no. of item may vary in the order without any change in the accepted price. ", blackCalibri9));
            shipTo19Cell2.addElement(new Paragraph("3. Failure to  comply  with specifications,  terms and conditions of this order, or accepted  delivery schedule shall be sufficient grounds for cancellation of order by purchaser without  being liable  for paying any compensation to the supplier. ", blackCalibri9));
            shipTo19Cell2.addElement(new Paragraph("4. In case of delay in supply, liquidated damage at the rate of 0.5% on value of the purchase order per week, or part thereof, will be recovered. ", blackCalibri9));

            shipTo19Cell2.setFixedHeight(150);

            table9.addCell(shipTo19Cell2);

            Paragraph ph17 = new Paragraph("", boldBlackCalibri10);
            
            PdfPCell r20c1 = createNewCell(ph17);
            r20c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            r20c1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            r20c1.setFixedHeight(20);

            table9.addCell(r20c1);
            
            PdfPCell shipTo21Cell2 = createNewCell(60);
            Paragraph ph18 = new Paragraph("Mode of payment : ", boldBlackCalibri10);
           
            shipTo21Cell2.addElement(ph18);
            shipTo21Cell2.addElement(new Paragraph("1. Payments shall be  made in  A/c Payee Cheque drawn on  Nationalised  Bank after successful compliance  of this  purchase order.", blackCalibri9));
            shipTo21Cell2.addElement(new Paragraph("2. Deduction on account of Income Tax, Sales Tax/Vat will be made wherever applicable as per statute. ", blackCalibri9));
           
            shipTo21Cell2.setFixedHeight(80);

            table9.addCell(shipTo21Cell2);
            
            PdfPCell shipTo22Cell2 = createNewCell(120);
            Paragraph ph19 = new Paragraph("E. Quality:-", boldBlackCalibri10);
           
            shipTo22Cell2.addElement(ph19);
            shipTo22Cell2.addElement(new Paragraph("1. All supplies must confirm exactly to our drawings or specifications.", blackCalibri9));
            shipTo22Cell2.addElement(new Paragraph("2. The Supplies should be accompanied by suppliers own detailed inspection report in duplicate.", blackCalibri9));
            shipTo22Cell2.addElement(new Paragraph("3. All materials will be subjected to our final inspection and approval at our Works before acceptance.", blackCalibri9));
            shipTo22Cell2.addElement(new Paragraph("4. Samples where required must be submitted as per given schedule along with inspection report.", blackCalibri9));

            shipTo22Cell2.setFixedHeight(90);

            table9.addCell(shipTo22Cell2);
            
            PdfPCell shipTo23Cell2 = createNewCell(120);
            Paragraph ph20 = new Paragraph(70,"G. Delivery:-", boldBlackCalibri10);
           
            shipTo23Cell2.addElement(ph20);
            shipTo23Cell2.addElement(new Paragraph("1. Delivery is essence of this order and the supplies must be made as per the schedules given failing which the company reserve the right to cancel the order without notice and refuse all subsequent deliveries. ", blackCalibri9));
            shipTo23Cell2.addElement(new Paragraph("2. Delivery’s should be accompanied by your challan in triplicate clearly stating item description, purchase order no. along with invoice and excise documents which ever is applicable. ", blackCalibri9));
            shipTo23Cell2.addElement(new Paragraph("3. Deliveries should be effected with in the notified hours (9.00 am to 5.00 pm) on all working days.", blackCalibri9));
            shipTo23Cell2.addElement(new Paragraph("4. Supplies in excess of the given schedule must not be made without prior written consent failing which excess will not be accepted.", blackCalibri9));
            shipTo23Cell2.addElement(new Paragraph("5. Company reserve the right to amend/postpone delivery schedule as per the requirement without any liability arising in us therein.", blackCalibri9));

            shipTo23Cell2.setFixedHeight(150);

            table9.addCell(shipTo23Cell2);
            
            PdfPCell shipTo24Cell2 = createNewCell(60);
            Paragraph ph21 = new Paragraph("F. Jurisdiction:- ", boldBlackCalibri10);
           
            shipTo24Cell2.addElement(ph21);
            shipTo24Cell2.addElement(new Paragraph("All dispute whatsoever that may arise between outstation parties in connection with this Order shall always be deemed to have arisen in Pune and only Pune Courts will have jurisdiction to entertain them.", blackCalibri9));
           
            shipTo24Cell2.setFixedHeight(60);

            table9.addCell(shipTo24Cell2);
            Paragraph ph22 = new Paragraph("", boldBlackCalibri10);
            PdfPCell r25c1 = createNewCell(ph22);
           
            r25c1.setFixedHeight(20);

            table9.addCell(r25c1);

            document.add(table9);

            document.close();
            writer.close();
           // fOut.close();
        
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	protected PdfPCell createNewCell() {
		return createNewCell(new Paragraph());
	}

	public static final Font boldBlackCalibri12 = new Font(Font.getFamily("Calibri"), 12, Font.BOLD, BaseColor.BLACK);
	public static final Font boldBlackCalibri11 = new Font(Font.getFamily("Calibri"), 11, Font.BOLD, BaseColor.BLACK);
	public static final Font blackCalibri14 = new Font(Font.getFamily("Calibri"), 14, Font.BOLD, BaseColor.BLACK);
    public static final Font blackCalibri9 = new Font(Font.getFamily("Calibri"), 9, Font.NORMAL, BaseColor.BLACK);
	public static final Font blackCalibri10 = new Font(Font.getFamily("Calibri"), 10, Font.NORMAL, BaseColor.BLACK);
	public static final Font blackCalibri11 = new Font(Font.getFamily("Calibri"), 11, Font.NORMAL, BaseColor.BLACK);
	public static final Font boldBlackCalibri10 = new Font(Font.getFamily("Calibri"), 10, Font.BOLD, BaseColor.BLACK);
	public static final Font arial = new Font(Font.getFamily("arial"), 12, Font.BOLD, BaseColor.BLACK);
}

class BackgroundImageHelper extends PdfPageEventHelper
{
    @Override
    public void onStartPage(PdfWriter writer, Document document)
    {
        try {
            document.add(new Paragraph(70, "\u00a0"));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {

        try
        {
            Resource resource = new ClassPathResource("background.jpg");
            InputStream inputStream = resource.getInputStream();

            // init array with file length
            byte[] bytesArray = new byte[inputStream.available()];
            inputStream.read(bytesArray);

            Image background = Image.getInstance(bytesArray);

            float width = document.getPageSize().getWidth();
            float height = document.getPageSize().getHeight();

            writer.getDirectContentUnder().addImage(background, width, 0, 0, height, 0, 0);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }

}