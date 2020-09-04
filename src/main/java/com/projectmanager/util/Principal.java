package com.projectmanager.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.annotation.ManagedBean;

import com.itextpdf.text.*;
import com.projectmanager.dao.TaxesDao;
import com.projectmanager.entity.TaxesEntity;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import com.projectmanager.entity.TaxInvoiceDetails;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@ManagedBean
public class Principal {

    @Autowired
    NumberWordConverter numberWordConverter;

    @Autowired
    TaxesDao taxesDao;


    public boolean createInvoice(TaxInvoiceDetails taxInvoiceDetails, String userName) {

        try {
            Resource resource = new ClassPathResource("static/fonts/BankGothicRegular.ttf");
            InputStream inputStream = resource.getInputStream();

            File BankGothicRegular = new File(System.getProperty("java.io.tmpdir") + "/BankGothicRegular.ttf");
            FileUtils.copyInputStreamToFile(inputStream, BankGothicRegular);

            FontFactory.register(BankGothicRegular.getAbsolutePath(), "Bank_Gothic");
            /*Font bankGothicFamily = FontFactory.getFont("Bank_Gothic", "Cp1253", true);*/

            Font blackBGLBi14 = FontFactory.getFont("Bank_Gothic", 14, Font.BOLD, BaseColor.BLACK);
            Font blackBGLB9 = FontFactory.getFont("Bank_Gothic", 9, Font.NORMAL, BaseColor.BLACK);
            Font blackBGLB10 = FontFactory.getFont("Bank_Gothic", 10, Font.NORMAL, BaseColor.BLACK);
            Font blackBGLB11 = FontFactory.getFont("Bank_Gothic", 11, Font.NORMAL, BaseColor.BLACK);
            Font boldBlackBGLB11 = FontFactory.getFont("Bank_Gothic", 11, Font.BOLD, BaseColor.BLACK);
            Font boldBlackBGLB10 = FontFactory.getFont("Bank_Gothic", 10, Font.BOLD, BaseColor.BLACK);

            String taxInvoiceNo = taxInvoiceDetails.getInvoiceNo().replace("/", "_");

            String destination = System.getProperty("java.io.tmpdir") + "/" + userName + "/" + taxInvoiceNo + ".pdf";

            File fileToSave = new File(destination);
            fileToSave.getParentFile().mkdirs();

            FileOutputStream fOut = new FileOutputStream(fileToSave);
            Document document = new Document();

            PdfWriter writer = PdfWriter.getInstance(document, fOut);
            document.open();

            document.add(new Paragraph(70, "\u00a0"));

            // Table1
            PdfPTable table = createNewTable(1);
            PdfPCell firstCell = createNewCell(new Paragraph("TAX INVOICE", blackBGLBi14), 20);
            firstCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(firstCell);
            document.add(table);

            // Table2
            PdfPTable table2 = createNewTable(3);
            float[] tableWidths = {2f, 1f, 1f};

            table2.setWidths(tableWidths);

            PdfPCell addressedToCell = createNewCell();
            addressedToCell.setRowspan(6);

            addressedToCell.addElement(new Paragraph("To,", boldBlackBGLB11));
            addressedToCell.addElement(new Paragraph(taxInvoiceDetails.getAddressedto1(), boldBlackBGLB11));
            addressedToCell.addElement(new Paragraph(10, "\u00a0"));
            addressedToCell.addElement(new Paragraph("Gst No.-" + taxInvoiceDetails.getGstNo(), boldBlackBGLB11));

            table2.addCell(addressedToCell);

            table2.addCell(createNewCell(new Paragraph("Tax Invoice No.", boldBlackBGLB11)));
            table2.addCell(createNewCell(new Paragraph(taxInvoiceDetails.getTaxInvoiceNo(), blackBGLB11)));
            table2.addCell(createNewCell(new Paragraph("Date           ", boldBlackBGLB11)));
            table2.addCell(createNewCell(new Paragraph(taxInvoiceDetails.getTaxInvoiceDate(), blackBGLB11)));
            table2.addCell(createNewCell(new Paragraph("order no.      ", boldBlackBGLB11)));
            table2.addCell(createNewCell(new Paragraph(taxInvoiceDetails.getOrderNo(), blackBGLB11)));
            table2.addCell(createNewCell(new Paragraph("order date.    ", boldBlackBGLB11)));
            table2.addCell(createNewCell(new Paragraph(taxInvoiceDetails.getOrderDate(), blackBGLB11)));
            table2.addCell(createNewCell(new Paragraph("kind attn:     ", boldBlackBGLB11)));
            table2.addCell(createNewCell(new Paragraph(taxInvoiceDetails.getContactName(), blackBGLB11)));
            table2.addCell(createNewCell(new Paragraph("Mobile no.     ", boldBlackBGLB11)));
            table2.addCell(createNewCell(new Paragraph(taxInvoiceDetails.getMobileNo(), blackBGLB11)));

            document.add(table2);

            // Table3
            PdfPTable table3 = createNewTable(7);

            float[] table3Widths = {1f, 2f, 5f, 1f, 2f, 1f, 3f};
            table3.setWidths(table3Widths);

            table3.addCell(createNewCell(new Paragraph("Sr no      ", boldBlackBGLB11)));
            table3.addCell(createNewCell(new Paragraph("HSN/SAC    ", boldBlackBGLB11)));
            table3.addCell(createNewCell(new Paragraph("Description", boldBlackBGLB11)));
            table3.addCell(createNewCell(new Paragraph("Qty.       ", boldBlackBGLB11)));
            table3.addCell(createNewCell(new Paragraph("Rate       ", boldBlackBGLB11)));
            table3.addCell(createNewCell(new Paragraph("Unit       ", boldBlackBGLB11)));
            table3.addCell(createNewCell(new Paragraph("amount     ", boldBlackBGLB11)));

            PdfPCell srnoCell = createNewCell(new Paragraph("1	      ", blackBGLB11));
            srnoCell.setFixedHeight(250);
            table3.addCell(srnoCell);
            table3.addCell(createNewCell(new Paragraph(taxInvoiceDetails.getHsnOrSac(), blackBGLB11)));
            table3.addCell(createNewCell(new Paragraph("structural steel erection services as per attached annexture", blackBGLB11)));
            table3.addCell(createNewCell(new Paragraph("1       		", blackBGLB11)));
            table3.addCell(createNewCell(new Paragraph(taxInvoiceDetails.getRate(), blackBGLB11)));
            table3.addCell(createNewCell(new Paragraph("Nos			", blackBGLB11)));
            table3.addCell(createNewCell(new Paragraph(taxInvoiceDetails.getRate(), blackBGLB11)));

            document.add(table3);

            // Table4
            PdfPTable table4 = createNewTable(4);

            float[] table4Widths = {3f, 5f, 3f, 3f};
            table4.setWidths(table4Widths);

            Paragraph amtInWords = new Paragraph("Amt in Words:", blackBGLB11);
            amtInWords.setAlignment(Element.ALIGN_CENTER);

            PdfPCell amtInWordscell = createNewCell();
            amtInWordscell.addElement(amtInWords);
            amtInWordscell.setRowspan(5);
            table4.addCell(amtInWordscell);

            Paragraph amtInWordsVal = new Paragraph(taxInvoiceDetails.getAmtInwrd1() + taxInvoiceDetails.getAmtInwrd2(),
                    blackBGLB11);
            amtInWordsVal.setAlignment(Element.ALIGN_CENTER);

            PdfPCell amtInWordsValCell = createNewCell();
            amtInWordsValCell.addElement(amtInWordsVal);
            amtInWordsValCell.setRowspan(5);

            table4.addCell(amtInWordsValCell);

            table4.addCell(createNewCell(new Paragraph("sub total:", boldBlackBGLB11)));
            table4.addCell(createNewCell(new Paragraph(taxInvoiceDetails.getRate(), blackBGLB11)));

            TaxesEntity taxes = taxesDao.getTaxesDetails().get(0);

            int taxVal = 0;
            if (taxInvoiceDetails.getGstNo().startsWith("27")) {
                taxVal = taxes.getcGst();

                table4.addCell(createNewCell(new Paragraph("cgst 9%	 ", boldBlackBGLB11)));
                table4.addCell(createNewCell(new Paragraph(
                        String.valueOf(Double.parseDouble(taxInvoiceDetails.getRate()) * taxes.getcGst() / 100), blackBGLB11)));
                table4.addCell(createNewCell(new Paragraph("SGST 9%	 ", boldBlackBGLB11)));
                table4.addCell(createNewCell(new Paragraph(
                        String.valueOf(Double.parseDouble(taxInvoiceDetails.getRate()) * taxes.getsGst() / 100), blackBGLB11)));

                table4.addCell(createNewCell(new Paragraph("IGST 18%	 ", boldBlackBGLB11)));
                table4.addCell(createNewCell(new Paragraph("-", blackBGLB11)));
            } else {
                taxVal = taxes.getiGst() / 2;
                table4.addCell(createNewCell(new Paragraph("cgst 9%	 ", boldBlackBGLB11)));
                table4.addCell(createNewCell(new Paragraph("-", blackBGLB11)));
                table4.addCell(createNewCell(new Paragraph("SGST 9%	 ", boldBlackBGLB11)));
                table4.addCell(createNewCell(new Paragraph("-", blackBGLB11)));

                table4.addCell(createNewCell(new Paragraph("IGST 18%	 ", boldBlackBGLB11)));
                table4.addCell(createNewCell(new Paragraph(String.valueOf(Double.parseDouble(taxInvoiceDetails.getRate()) * taxes.getiGst() / 100), blackBGLB11)));
            }

            table4.addCell(createNewCell(new Paragraph("total	 ", boldBlackBGLB11)));
            table4.addCell(
                    createNewCell(new Paragraph(
                            String.valueOf(Double.parseDouble(taxInvoiceDetails.getRate())
                                    + 2 * (Double.parseDouble(taxInvoiceDetails.getRate()) * taxVal / 100)),
                            blackBGLB11)));

            document.add(table4);

            // Table5

            PdfPTable table5 = createNewTable(2);

            float[] table5Widths = {4f, 2f};
            table5.setWidths(table5Widths);

            table5.addCell(createNewCell(new Paragraph("Company's Bank Details ", blackBGLB11)));
            table5.addCell(createNewCell(new Paragraph("PECO Projects", boldBlackBGLB11)));
            table5.addCell(createNewCell(new Paragraph("Bank Name: HDFC Bank Ltd ", blackBGLB11)));

            PdfPCell signCell = createNewCell(70);
            signCell.setRowspan(3);
            try {

                Resource resourceSign = new ClassPathResource("sign.png");

                Image signImg = Image.getInstance(resourceSign.getURL());

                float width = signCell.getWidth();
                signImg.setWidthPercentage(width);
                signImg.setScaleToFitHeight(true);

                signCell.addElement(signImg);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            table5.addCell(signCell);

            table5.addCell(createNewCell(new Paragraph("A/c No.: 00000000000000 ", blackBGLB11)));
            table5.addCell(createNewCell(new Paragraph("IFSC Code: HDFC0000000 ", blackBGLB11)));

            table5.addCell(createNewCell(new Paragraph("Branch:  Pimpri, Pune ", blackBGLB11)));
            table5.addCell(createNewCell(new Paragraph("AUTHORIZED SIGNATORY ", boldBlackBGLB11)));
            table5.addCell(createNewCell(new Paragraph(
                    "*intrest rate at 24% per annum applicable for late payment after due date", blackBGLB11), 30));

            PdfPCell stampCell = createNewCell(80);

            stampCell.setRowspan(3);

            try {
                /*File file = new File(System.getProperty("java.io.tmpdir") + "/stamp.png");

                if(!(file.exists()))
                {
                    Resource resourceStamp = new ClassPathResource("stamp.png");
                    InputStream inputStreamStamp = resource.getInputStream();

                    FileUtils.copyInputStreamToFile(inputStreamStamp, file);
                }
                // init array with file length
                byte[] bytesArray = new byte[(int) file.length()];

                FileInputStream fis = new FileInputStream(file);
                fis.read(bytesArray); // read file into bytes[]
                fis.close();*/

                Resource resourceStamp = new ClassPathResource("stamp.png");

                Image img = Image.getInstance(resourceStamp.getURL());

                float width = stampCell.getWidth();
                img.setWidthPercentage(width);
                img.setScaleToFitHeight(true);

                stampCell.addElement(img);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            table5.addCell(stampCell);

            table5.addCell(createNewCell(new Paragraph("SUBJECT TO PUNE JURISDICTION ONLY. ", blackBGLB11)));
            table5.addCell(createNewCell(new Paragraph("GST NO.: 27AAICP1433D1ZQ ", blackBGLB11)));

            table5.addCell(createNewCell(new Paragraph("PAN NO.: AAICP1433D ", blackBGLB11)));
            table5.addCell(createNewCell(new Paragraph("STAMP ", boldBlackBGLB11)));

            try
            {
                Resource resourceBG = new ClassPathResource("background.jpg");

                Image background = Image.getInstance(resourceBG.getURL());

                float width = document.getPageSize().getWidth();
                float height = document.getPageSize().getHeight();
                writer.getDirectContentUnder().addImage(background, width, 0, 0, height, 0, 0);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            document.add(table5);

            document.close();
            writer.close();

            return true;
        } catch (Exception ex) {

            ex.printStackTrace();
            return false;
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

    protected PdfPCell createNewCell() {
        return createNewCell(new Paragraph());
    }

}