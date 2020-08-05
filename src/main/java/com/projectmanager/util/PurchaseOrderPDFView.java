package com.projectmanager.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projectmanager.dao.TaxesDao;
import com.projectmanager.entity.TaxesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.projectmanager.entity.PODetails;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component("purchaseOrderView")
public class PurchaseOrderPDFView extends AbstractView {

    @Autowired
    Principal principal;

    @Autowired
    NumberWordConverter numberWordConverter;

    @Autowired
    TaxesDao taxesDao;

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {

        PODetails poDetails = (PODetails) model.get("poDetails");
        String poLineDetails = (String) model.get("poLineDetails");

        String[] poLines = poLineDetails.split(";");

        String[] description = new String[poLines.length];
        String[] quantity = new String[poLines.length];
        String[] unitPrice = new String[poLines.length];

        String[] make = new String[poLines.length];
        String[] terms = poDetails.getTerm();

        int index = 0;
        for (String poLine : poLines) {
            String[] details = poLine.split(",");
            description[index] = details[1];
            quantity[index] = details[2];
            unitPrice[index] = details[3];
            index++;

        }

        //Save poDetails.getPoNumber() + ".pdf" in io.temp
        try
        {
            String userName = (String)model.get("userName");
            String destination = System.getProperty("java.io.tmpdir") + "/"+userName+"/"+poDetails.getPoNumber() + ".pdf";

            File fileToSave = new File(destination);
            fileToSave.getParentFile().mkdirs();

            FileOutputStream fOut = new FileOutputStream(fileToSave);
        
              generatePO("27440913446-V", "27AEBPH1001B1ZM", poDetails.getPoNumber(), poDetails.getPoDate(),
                    poDetails.getVendorName(), "", poDetails.getContactName(), poDetails.getContactNumber(),
                    poDetails.getContactEmail(), make, description, quantity, unitPrice, terms, response, fOut);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void generatePO(String vatTin, String gstNo, String purhaseOrderNo, String purhaseOrderDate,
                           String venderName, String venderLocation, String receiverName, String receiverNo, String receiverEmail,
                           String[] make, String[] description, String[] quantity, String[] unitPrice, String[] term,
                           HttpServletResponse response, FileOutputStream fOut ) {

        try {

            Document document = new Document();

            PdfWriter writer = PdfWriter.getInstance(document, fOut);
            document.open();

            ArrayList<String[]> descriptionList = new ArrayList<>();

            int pages = Math.round(description.length / 10) + 1;

            try {
                for (int i = 0; i < pages; i++) {

                    int end = 10 * i + 9;
                    if (description.length < 10 * i + 10) {
                        end = description.length - 1;
                    }
                    String[] newArray = Arrays.copyOfRange(description, 10 * i, end);

                    descriptionList.add(newArray);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            for (String[] desc : descriptionList) {
                generatePage(document, gstNo, purhaseOrderNo, purhaseOrderDate, venderName, venderLocation, receiverName, receiverNo, receiverEmail, desc, unitPrice, quantity, make, term, writer);
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

    protected void generatePage(Document document, String gstNo, String purhaseOrderNo, String purhaseOrderDate, String venderName, String venderLocation, String receiverName, String receiverNo, String receiverEmail, String[] description, String[] unitPrice, String[] quantity, String[] make, String[] term, PdfWriter writer) {
        try {
            document.add(new Paragraph(70, "\u00a0"));

            PdfPTable table = createNewTable(2);

            float[] cloWidth = {2f, 2f};

            table.setWidths(cloWidth);

            // Row1
            Paragraph ph = new Paragraph("HAMDULE INDUSTRIES", redCalibri14);
            ph.setAlignment(Element.ALIGN_MIDDLE);

            PdfPCell c1 = createNewCell(ph);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            c1.setFixedHeight(30);

            Paragraph ph2 = new Paragraph("PURCHASE ORDER",
                    new Font(Font.FontFamily.COURIER, 14, Font.BOLD, BaseColor.BLACK));
            ph2.setAlignment(Element.ALIGN_MIDDLE);

            PdfPCell c2 = createNewCell(ph2);
            c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            c2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            c2.setFixedHeight(30);

            // Row2
            PdfPCell c3 = createNewCell();


            c3.addElement(new Paragraph("GST No.   " + gstNo, blackCalibri10));
            c3.addElement(new Paragraph("          ", blackCalibri10));

            c3.setBorderWidthBottom(0);
            c3.setBorderColorBottom(null);

            c3.setFixedHeight(40);

            PdfPCell c4 = createNewCell();
            c4.addElement(new Paragraph("PO No.   " + purhaseOrderNo, blackCalibri10));
            c4.addElement(new Paragraph("PO DATE.   " + purhaseOrderDate, blackCalibri10));
            c4.setBorderWidthBottom(0);

            c4.setFixedHeight(40);

            // Row3
            PdfPCell c5 = createNewCell();
            c5.addElement(new Paragraph("To:   " + venderName, blackCalibri11));
            c5.addElement(new Paragraph(venderLocation, blackCalibri10));
            c5.addElement(new Paragraph("Kind Attn.   " + receiverName, blackCalibri10));
            c5.addElement(new Paragraph("Cell#        " + receiverNo, blackCalibri10));
            c5.addElement(new Paragraph("E-Mail       " + receiverEmail, blackCalibri10));

            PdfPCell c6 = createNewCell();
            c6.addElement(new Paragraph("ADDRESS CORRESPONDENCE TO: ", blackCalibri11));
            c6.addElement(new Paragraph("Name   MEHMOOD D. HAMDULE", blackCalibri10));
            c6.addElement(new Paragraph("Cell#  9766669933", blackCalibri10));
            c6.addElement(new Paragraph("Email  business@hamduleindustries.com", blackCalibri10));
            c6.addElement(new Paragraph("Phone  020-27502200", blackCalibri10));

            c5.setFixedHeight(90);
            c6.setFixedHeight(90);

            table.addCell(c1);
            table.addCell(c2);

            table.addCell(c3);
            table.addCell(c4);
            table.addCell(c5);
            table.addCell(c6);

            document.add(table);

            // Table2
            PdfPTable table2 = createNewTable(9);

            float[] colWidts = {1f, 2f, 6f, 2f, 2f, 2f, 2f, 2f, 3f};

            table2.setWidths(colWidts);

            PdfPCell r2c1 = createNewCell(new Paragraph("SR#", blackCalibri9));
            PdfPCell r2c2 = createNewCell(new Paragraph("Make", blackCalibri9));
            PdfPCell r2c3 = createNewCell(new Paragraph("Description", blackCalibri9));
            PdfPCell r2c4 = createNewCell(new Paragraph("Qty", blackCalibri9));
            PdfPCell r2c5 = createNewCell(new Paragraph("Unit", blackCalibri9));
            PdfPCell r2c6 = createNewCell(new Paragraph("Price", blackCalibri9));
            PdfPCell r2c7 = createNewCell(new Paragraph("CGST", blackCalibri9));
            PdfPCell r2c8 = createNewCell(new Paragraph("SGST", blackCalibri9));
            PdfPCell r2c9 = createNewCell(new Paragraph("Amount (Rs)", blackCalibri9));

            table2.addCell(r2c1);
            table2.addCell(r2c2);
            table2.addCell(r2c3);
            table2.addCell(r2c4);
            table2.addCell(r2c5);
            table2.addCell(r2c6);
            table2.addCell(r2c7);
            table2.addCell(r2c8);
            table2.addCell(r2c9);

            double cGstTotal = 0.0;
            double sGstTotal = 0.0;
            double iGstTotal = 0.0;

            double subTotal = 0.0;

            String total = "";
            String cGst = "";
            String sGst = "";
            String iGst = "";

            TaxesEntity taxes =  taxesDao.getTaxesDetails().get(0);

            int cGstVal = taxes.getcGst();
            int sGstVal = taxes.getsGst();
            int iGstVal = taxes.getiGst();

            for (int i = 0; i < description.length; i++) {

                total = String.valueOf(Double.parseDouble(unitPrice[i]) * Double.parseDouble(quantity[i]));

                cGst = String.valueOf(Double.parseDouble(total) * cGstVal / 100);
                sGst = String.valueOf(Double.parseDouble(total) * sGstVal / 100);

                iGst = String.valueOf(Double.parseDouble(total) * iGstVal / 100);

                PdfPCell r3c1 = createNewCell(new Paragraph(String.valueOf(i + 1), blackCalibri9));
                PdfPCell r3c2 = createNewCell(new Paragraph(make[i], blackCalibri9));
                PdfPCell r3c3 = createNewCell(new Paragraph(description[i].replace("~", ""), blackCalibri9));
                PdfPCell r3c4 = createNewCell(new Paragraph(quantity[i], blackCalibri9));
                PdfPCell r3c5 = createNewCell(new Paragraph("NB", blackCalibri9));
                PdfPCell r3c6 = createNewCell(new Paragraph(unitPrice[i], blackCalibri9));

                PdfPCell r3c7 = null;
                PdfPCell r3c8 = null;

                if(gstNo.startsWith("27"))
                {
                    r3c7 = createNewCell(new Paragraph(cGst, blackCalibri9));
                    r3c8 = createNewCell(new Paragraph(sGst, blackCalibri9));
                }
                else
                {
                    r3c7 = createNewCell(new Paragraph("-", blackCalibri9));
                    r3c8 = createNewCell(new Paragraph(iGst, blackCalibri9));
                }


                PdfPCell r3c9 = createNewCell(new Paragraph(total, blackCalibri9));

                table2.addCell(r3c1);
                table2.addCell(r3c2);
                table2.addCell(r3c3);
                table2.addCell(r3c4);
                table2.addCell(r3c5);
                table2.addCell(r3c6);
                table2.addCell(r3c7);
                table2.addCell(r3c8);
                table2.addCell(r3c9);

                cGstTotal += Double.parseDouble(cGst);
                sGstTotal += Double.parseDouble(sGst);
                iGstTotal +=  Double.parseDouble(iGst);

                subTotal += Double.parseDouble(total);

            }

            for (int i = 0; i < 9 - description.length; i++) {

                PdfPCell r3c1 = createNewCell(new Paragraph("", blackCalibri9));
                PdfPCell r3c2 = createNewCell(new Paragraph("", blackCalibri9));
                PdfPCell r3c3 = createNewCell(new Paragraph("", blackCalibri9));
                PdfPCell r3c4 = createNewCell(new Paragraph("", blackCalibri9));
                PdfPCell r3c5 = createNewCell(new Paragraph("", blackCalibri9));
                PdfPCell r3c6 = createNewCell(new Paragraph("", blackCalibri9));
                PdfPCell r3c7 = createNewCell(new Paragraph("", blackCalibri9));
                PdfPCell r3c8 = createNewCell(new Paragraph("", blackCalibri9));
                PdfPCell r3c9 = createNewCell(new Paragraph("", blackCalibri9));

                table2.addCell(r3c1);
                table2.addCell(r3c2);
                table2.addCell(r3c3);
                table2.addCell(r3c4);
                table2.addCell(r3c5);
                table2.addCell(r3c6);
                table2.addCell(r3c7);
                table2.addCell(r3c8);
                table2.addCell(r3c9);
            }

            PdfPCell r4c1 = createNewCell(new Paragraph("", blackCalibri9));
            PdfPCell r4c2 = createNewCell(new Paragraph("", blackCalibri9));
            PdfPCell r4c3 = createNewCell(new Paragraph("", blackCalibri9));
            PdfPCell r4c4 = createNewCell(new Paragraph("", blackCalibri9));
            PdfPCell r4c5 = createNewCell(new Paragraph("", blackCalibri9));
            PdfPCell r4c6 = createNewCell(new Paragraph("Total", blackCalibri9));

            PdfPCell r4c7 = null;
            PdfPCell r4c8 = null;
            PdfPCell r4c9 = null;

            if(gstNo.startsWith("27")) {
                r4c7 = createNewCell(new Paragraph(String.valueOf(cGstTotal), blackCalibri9));
                r4c8 = createNewCell(new Paragraph(String.valueOf(sGstTotal), blackCalibri9));
                r4c9 = createNewCell(new Paragraph("", blackCalibri9));
            }
            else
            {
                r4c7 = createNewCell(new Paragraph("", blackCalibri9));
                r4c8 = createNewCell(new Paragraph("", blackCalibri9));
                r4c9 = createNewCell(new Paragraph(String.valueOf(iGstTotal), blackCalibri9));
            }

            table2.addCell(r4c1);
            table2.addCell(r4c2);
            table2.addCell(r4c3);
            table2.addCell(r4c4);
            table2.addCell(r4c5);
            table2.addCell(r4c6);
            table2.addCell(r4c7);
            table2.addCell(r4c8);
            table2.addCell(r4c9);

            document.add(table2);

            // Table3
            float[] colWidths = {2f, 5f, 1.5f, 1.5f};

            PdfPTable table3 = createNewTable(4);

            table3.setWidths(colWidths);

            PdfPCell t3r1c1 = createNewCell(new Paragraph("AMOUNT IN WORDS (Rs)", blackCalibri9), 70);
            t3r1c1.setRowspan(4);
            t3r1c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            t3r1c1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            String amountInWords = "";

            if(gstNo.startsWith("27"))
            {
                 amountInWords = numberWordConverter.convert((int) Math.round(subTotal + cGstTotal + sGstTotal));
            }
            else
            {
                amountInWords = numberWordConverter.convert((int) Math.round(subTotal + iGstTotal));
            }


            PdfPCell t3r1c2 = createNewCell(new Paragraph(amountInWords, blackCalibri9), 70);
            t3r1c2.setRowspan(4);
            t3r1c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            t3r1c2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell t3r1c3 = createNewCell(70);

            t3r1c3.addElement(new Paragraph("SUB TOTAL", blackCalibri9));
            t3r1c3.addElement(new Paragraph("GST TAXES", blackCalibri9));
            t3r1c3.addElement(new Paragraph("TOTAL", blackCalibri9));
            t3r1c3.setHorizontalAlignment(Element.ALIGN_CENTER);
            t3r1c3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell t3r1c4 = createNewCell(70);




            t3r1c4.addElement(new Paragraph("\u20B9    "+String.valueOf(subTotal), arial));
            t3r1c4.addElement(new Paragraph("\u20B9    "+String.valueOf(cGstTotal + sGstTotal), arial));
            t3r1c4.addElement(new Paragraph("\u20B9    "+String.valueOf(subTotal + cGstTotal + sGstTotal), arial));
            t3r1c4.setHorizontalAlignment(Element.ALIGN_CENTER);
            t3r1c4.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table3.addCell(t3r1c1);
            table3.addCell(t3r1c2);
            table3.addCell(t3r1c3);
            table3.addCell(t3r1c4);

            document.add(table3);

            // Table4
            PdfPTable table4 = createNewTable(1);

            PdfPCell termCell = createNewCell();
            termCell.addElement(new Paragraph("Terms :-    ", boldBlackCalibri10));
            termCell.addElement(new Paragraph("     " + (term.length > 0 ? term[0] : ""), blackCalibri10));
            termCell.addElement(new Paragraph("     " + (term.length > 1 ? term[1] : ""), blackCalibri10));
            termCell.addElement(new Paragraph("     " + (term.length > 2 ? term[2] : ""), blackCalibri10));
            termCell.addElement(new Paragraph("     " + (term.length > 3 ? term[3] : ""), blackCalibri10));
            termCell.addElement(new Paragraph("     " + (term.length > 4 ? term[4] : ""), blackCalibri10));
            termCell.setFixedHeight(150);

            table4.addCell(termCell);

            document.add(table4);

            // Table5
            PdfPTable table5 = createNewTable(3);

            float[] colWidthTable5 = {4f, 2f, 3f};

            table5.setWidths(colWidthTable5);

            PdfPCell shipToCell = createNewCell(120);
            shipToCell.addElement(new Paragraph("SHIP TO :  HAMDULE INDUSTRIES,", boldBlackCalibri10));
            shipToCell.addElement(new Paragraph("MANISH GARDEN SOCIETY, SWAPNA NAGARI, PIMPRI", blackCalibri10));
            shipToCell.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell stampCell = createNewCell(120);
            try {
                File file = ResourceUtils.getFile("classpath:stamp.png");
                // init array with file length
                byte[] bytesArray = new byte[(int) file.length()];

                FileInputStream fis = new FileInputStream(file);
                fis.read(bytesArray); // read file into bytes[]
                fis.close();

                Image img = Image.getInstance(bytesArray);
                stampCell.addElement(img);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            Paragraph ph4 = new Paragraph("VERIFIED BY", blackCalibri9);
            ph4.setAlignment(Element.ALIGN_CENTER);
            stampCell.addElement(ph4);
            stampCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            stampCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell signCell = createNewCell(120);
            Paragraph ph1 = new Paragraph("FOR HAMDULE INDUSTRIES", blackCalibri10);
            ph1.setAlignment(Element.ALIGN_CENTER);
            signCell.addElement(ph1);
            try {

                File file = ResourceUtils.getFile("classpath:sign.png");
                // init array with file length
                byte[] bytesArray = new byte[(int) file.length()];

                FileInputStream fis = new FileInputStream(file);
                fis.read(bytesArray); // read file into bytes[]
                fis.close();

                Image signImg = Image.getInstance(bytesArray);
                signCell.addElement(signImg);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            Paragraph ph3 = new Paragraph("Authorized Signatory", blackCalibri10);
            ph3.setAlignment(Element.ALIGN_CENTER);
            signCell.addElement(ph3);

            signCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            signCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

            table5.addCell(shipToCell);
            table5.addCell(stampCell);
            table5.addCell(signCell);

            document.add(table5);


            File file = ResourceUtils.getFile("classpath:background.jpg");
            // init array with file length
            byte[] bytesArray = new byte[(int) file.length()];

            FileInputStream fis = new FileInputStream(file);
            fis.read(bytesArray); // read file into bytes[]
            fis.close();

            Image background = Image.getInstance(bytesArray);

            float width = document.getPageSize().getWidth();
            float height = document.getPageSize().getHeight();
            writer.getDirectContentUnder().addImage(background, width, 0, 0, height, 0, 0);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected PdfPCell createNewCell() {
        return createNewCell(new Paragraph());
    }

    public static final Font redCalibri14 = new Font(Font.getFamily("Calibri"), 14, Font.BOLD, BaseColor.RED);
    public static final Font blackCalibri9 = new Font(Font.getFamily("Calibri"), 9, Font.NORMAL, BaseColor.BLACK);
    public static final Font blackCalibri10 = new Font(Font.getFamily("Calibri"), 10, Font.NORMAL, BaseColor.BLACK);
    public static final Font blackCalibri11 = new Font(Font.getFamily("Calibri"), 11, Font.NORMAL, BaseColor.BLACK);
    public static final Font boldBlackCalibri10 = new Font(Font.getFamily("Calibri"), 10, Font.BOLD, BaseColor.BLACK);
    public static final Font arial = new Font(Font.getFamily("arial"), 12, Font.BOLD, BaseColor.BLACK);
}
