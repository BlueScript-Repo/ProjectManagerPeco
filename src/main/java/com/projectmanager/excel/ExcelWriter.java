package com.projectmanager.excel;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.ManagedBean;

import com.projectmanager.entity.BOQDetails;
import com.projectmanager.entity.DesignOffer;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.projectmanager.entity.BOQHeader;
import com.projectmanager.entity.BOQLineData;

@ManagedBean
public class ExcelWriter {

    public byte[] writeExcel(ArrayList<BOQLineData> boqLineDataDetails, String[] size, String[] quantity,
                             String[] supplyRate, String[] erectionRate, String[] supplyAmount, String[] erectionAmount,
                             String boqNameRevisionStr, BOQHeader header, boolean isOffer, boolean isInvoiceAnnexture, boolean isBOQ) throws IOException {

        Workbook workBook = null;
        InputStream inputStream = null;
        try
        {
            Resource resource = new ClassPathResource("BOQ_Template.xls");
            inputStream = resource.getInputStream();
            workBook = WorkbookFactory.create(inputStream);
        } catch (EncryptedDocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String sheetDetails = header.getSheetDetails();

        if (null == sheetDetails || "".equals(sheetDetails)) {
            sheetDetails = "sheetDetails," + boqLineDataDetails.size();

            // This is for Inquiry generation. While generating
            // Inquiry we are creating only
            // one sheet which will hold all the elements
            // elements.
        }

        String[] sheets = sheetDetails.split(",");

        Map<String, String> sheetDetailsMap = new LinkedHashMap<String, String>();

        for (int i = 0; i < sheets.length; i++) {
            sheetDetailsMap.put(sheets[i], sheets[++i]);
        }

        Set<String> sheetNames = sheetDetailsMap.keySet();

        Iterator<String> sheetIterator = sheetNames.iterator();

        ArrayList<String> sheetNameList = new ArrayList<String>();
        while (sheetIterator.hasNext()) {
            String sheetNameStr = sheetIterator.next();
            sheetNameList.add(sheetNameStr);
            Sheet newSheet = workBook.createSheet(sheetNameStr);

            // copy "sheet1" as is

            /*
             * Loop in the row data list, add each row data into the new sheet.
             */
            /* Get sheet by name. */
            Sheet copySheet = workBook.getSheet("sheet1");

            int fRowNum = copySheet.getFirstRowNum();
            int lRowNum = copySheet.getLastRowNum();

            /*
             * First row is excel file header, so read data from row next to it.
             */
            for (int i = fRowNum; i < lRowNum + 1; i++) {
                /* Only get desired row data. */
                if (i >= 0 && i <= 80) {
                    Row row = copySheet.getRow(i);
                    Row newRow = newSheet.createRow(i);

                    int fCellNum = row.getFirstCellNum();
                    int lCellNum = row.getLastCellNum();

                    /* Loop in cells, add each cell value to the list. */
                    for (int j = fCellNum; j < 8; j++) {
                        copyCell(row.getCell(j), newRow.createCell(j));
                    }

                }
            }

        }

        int startIndex = 0;
        int lastIndex = 0;

        int index = 0;

        CellStyle whiteBackGround = workBook.createCellStyle();

        whiteBackGround.setFillBackgroundColor(IndexedColors.WHITE.index);
        whiteBackGround.setFillForegroundColor(IndexedColors.WHITE.index);
        whiteBackGround.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        whiteBackGround.setBorderRight(BorderStyle.MEDIUM);
        whiteBackGround.setRightBorderColor(IndexedColors.BLACK.index);

        Font boldFont = workBook.createFont();
        boldFont.setBold(true);
        boldFont.setFontHeightInPoints(Short.valueOf("10"));
        boldFont.setFontName("Arial");

        CellStyle whiteBackGroundBolFont = workBook.createCellStyle();
        whiteBackGroundBolFont.cloneStyleFrom(whiteBackGround);
        whiteBackGroundBolFont.setFont(boldFont);

        CellStyle whiteBackGroundTextCenter = workBook.createCellStyle();

        whiteBackGroundTextCenter.setFillBackgroundColor(IndexedColors.WHITE.index);
        whiteBackGroundTextCenter.setFillForegroundColor(IndexedColors.WHITE.index);
        whiteBackGroundTextCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        whiteBackGroundTextCenter.setBorderRight(BorderStyle.MEDIUM);
        whiteBackGroundTextCenter.setRightBorderColor(IndexedColors.BLACK.index);
        whiteBackGroundTextCenter.setAlignment(HorizontalAlignment.CENTER);
        whiteBackGroundTextCenter.setVerticalAlignment(VerticalAlignment.CENTER);

        CellStyle whiteBackGroundBaseLineRight = workBook.createCellStyle();
        whiteBackGroundBaseLineRight.setFillBackgroundColor(IndexedColors.WHITE.index);
        whiteBackGroundBaseLineRight.setFillForegroundColor(IndexedColors.WHITE.index);
        whiteBackGroundBaseLineRight.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        whiteBackGroundBaseLineRight.setBorderBottom(BorderStyle.MEDIUM);
        whiteBackGroundBaseLineRight.setBottomBorderColor(IndexedColors.BLACK.index);

        whiteBackGroundBaseLineRight.setBorderRight(BorderStyle.MEDIUM);
        whiteBackGroundBaseLineRight.setRightBorderColor(IndexedColors.BLACK.index);


        for (int s = 1; s <= sheetNames.size(); s++) {
            int serialNumber = 1;
            ArrayList<BOQLineData> processedInventory = new ArrayList<BOQLineData>();
            Sheet sheet = workBook.getSheetAt(s + 2);
            int inventoryCount = Integer.parseInt(sheetDetailsMap.get(sheetNameList.get(s - 1)));

            sheet.getRow(0).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .setCellValue("PECO Projects Pvt Ltd");

            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 4));
            /*sheet.addMergedRegion(new CellRangeAddress(2,2,5,7));*/

            sheet.addMergedRegion(new CellRangeAddress(2, 3, 0, 0));
            sheet.addMergedRegion(new CellRangeAddress(2, 3, 2, 4));

            sheet.addMergedRegion(new CellRangeAddress(2, 2, 5, 7));
            sheet.addMergedRegion(new CellRangeAddress(3, 3, 5, 7));

            sheet.addMergedRegion(new CellRangeAddress(4, 4, 2, 3));
            sheet.addMergedRegion(new CellRangeAddress(4, 4, 4, 7));
            sheet.addMergedRegion(new CellRangeAddress(5, 5, 2, 3));
            sheet.addMergedRegion(new CellRangeAddress(5, 5, 4, 7));
            sheet.addMergedRegion(new CellRangeAddress(6, 6, 2, 3));

            lastIndex = lastIndex + inventoryCount;

            System.out.println("lastIndex is : " + lastIndex);

            // Sort the list
            if (header != null) {
                sheet.getRow(2).getCell(5).setCellValue(header.getClient());
                sheet.getRow(6).getCell(1).setCellValue(header.getUtility());

                sheet.getRow(3).getCell(5).setCellValue(header.getSite());
                sheet.getRow(6).getCell(4).setCellValue(header.getPressure());

                sheet.getRow(4).getCell(1).setCellValue(header.getProject());
                sheet.getRow(6).getCell(6).setCellValue(header.getTemp());

                sheet.getRow(5).getCell(1).setCellValue(header.getdName());
                sheet.getRow(5).getCell(4).setCellValue(header.getdNo());
                sheet.getRow(4).getCell(4).setCellValue(header.getClassVariable());
            }

            int nextRow = 10;
            int i = 1;
            int pushBy = 0;

            int invRepeateCount = 0;
            int rowB4Push = 0;

            double supplyAmountTotal = 0;
            double erectionAmountTotal = 0;
            double Total = 0;


//            boolean isAnnexure = false;
//
//            if(boqLineDataDetails!=null && boqLineDataDetails.size()>0)
//            {
//                isAnnexure = false;//true
//            }


            for (int invIndx = startIndex; invIndx < lastIndex; invIndx++) {

                BOQLineData inventory = boqLineDataDetails.get(invIndx);

                int presentIndex = processedInventory.indexOf(inventory);
                // Reset pushBy to 0
                pushBy = 0;
                boolean shouldEnd = true;
                System.out.println("presentIndex is : " + presentIndex);

                if (presentIndex != -1) {

                    shouldEnd = false;
                    int row = nextRow - 8 + invRepeateCount;

                    if (sheet.getRow(row) == null) {
                        sheet.createRow(row);
                    }

                    sheet.getRow(row).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                            .setCellStyle(whiteBackGround);
                    sheet.getRow(row).getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                            .setCellStyle(whiteBackGround);

                    Cell cellToUpdate0 = sheet.getRow(row).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cellToUpdate0.setCellValue(size[index]);
                    cellToUpdate0.setCellStyle(whiteBackGroundTextCenter);

                    Cell cellToUpdate5 = sheet.getRow(row).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);


                    cellToUpdate5.setCellValue(quantity[index]);

                    cellToUpdate5.setCellStyle(whiteBackGroundTextCenter);

                    Cell cellToUpdate6 = sheet.getRow(row).getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);


                    if (supplyRate.length > 0) {
                        cellToUpdate6.setCellValue(supplyRate[index]);

                    }
                    cellToUpdate6.setCellStyle(whiteBackGroundTextCenter);

                    Cell cellToUpdate9 = sheet.getRow(row).getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    if (supplyAmount.length > 0) {
                        cellToUpdate9.setCellValue(supplyAmount[index]);

                        if (!(supplyAmount[index].isEmpty())) {
                            supplyAmountTotal = supplyAmountTotal + Double.parseDouble(supplyAmount[index]);
                        }
                    }
                    cellToUpdate9.setCellStyle(whiteBackGroundTextCenter);

                    Cell cellToUpdate8 = sheet.getRow(row).getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (erectionRate.length > 0) {
                        cellToUpdate8.setCellValue(erectionRate[index]);

                    }
                    cellToUpdate8.setCellStyle(whiteBackGroundTextCenter);

                    Cell cellToUpdate10 = sheet.getRow(row).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    if (erectionAmount.length > 0) {
                        cellToUpdate10.setCellValue(erectionAmount[index]);
                        if (!(erectionAmount[index].isEmpty())) {
                            erectionAmountTotal = erectionAmountTotal + Double.parseDouble(erectionAmount[index]);
                        }

                    }
                    cellToUpdate10.setCellStyle(whiteBackGroundTextCenter);

                    invRepeateCount++;

                } else {

                    rowB4Push = 0;
                    processedInventory.add(inventory);

                    sheet.createRow(nextRow - 2);
                    sheet.createRow(nextRow - 1);
                    sheet.createRow(nextRow);

                    for (int n = 0; n < 8; n++) {
                        Cell cell0 = sheet.getRow(nextRow - 2).getCell(n, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        cell0.setCellStyle(whiteBackGround);
                    }

                    for (int n = 0; n < 8; n++) {
                        Cell cell0 = sheet.getRow(nextRow - 1).getCell(n, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        cell0.setCellStyle(whiteBackGround);
                    }

                    for (int n = 0; n < 8; n++) {
                        Cell cell0 = sheet.getRow(nextRow).getCell(n, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        cell0.setCellStyle(whiteBackGround);
                    }

                    Cell serialNumberCell = sheet.getRow(nextRow - 1).getCell(0,
                            Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    serialNumberCell.setCellValue(serialNumber++);

                    String invCategory = null != inventory.getCategory() ? inventory.getCategory() : "";
                    Cell cellToUpdateInv = sheet.getRow(nextRow - 1).getCell(1,
                            Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cellToUpdateInv.setCellValue(inventory.getInventoryName() + " " + invCategory);
                    cellToUpdateInv.setCellStyle(whiteBackGroundBolFont);

                    sheet.getRow(nextRow).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                            .setCellStyle(whiteBackGround);

                    Cell cellToUpdate = sheet.getRow(nextRow).getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cellToUpdate.setCellValue(inventory.getStdLine());
                    cellToUpdate.setCellStyle(whiteBackGround);

                    Cell cellToUpdate0 = sheet.getRow(nextRow).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cellToUpdate0.setCellValue(size[index]);
                    cellToUpdate0.setCellStyle(whiteBackGroundTextCenter);

                    Cell cellToUpdate5 = sheet.getRow(nextRow).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cellToUpdate5.setCellValue(quantity[index]);
                    cellToUpdate5.setCellStyle(whiteBackGroundTextCenter);

                    Cell cellToUpdate6 = sheet.getRow(nextRow).getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    if (supplyRate.length > 0) {
                        cellToUpdate6.setCellValue(supplyRate[index]);
                        if (!(supplyRate[index].isEmpty())) {
                            supplyAmountTotal = supplyAmountTotal + Double.parseDouble(supplyAmount[index]);
                        }

                    }
                    cellToUpdate6.setCellStyle(whiteBackGroundTextCenter);

                    Cell cellToUpdate9 = sheet.getRow(nextRow).getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    if (supplyAmount.length > 0)
                        cellToUpdate9.setCellValue(supplyAmount[index]);
                    cellToUpdate9.setCellStyle(whiteBackGroundTextCenter);

                    Cell cellToUpdate8 = sheet.getRow(nextRow).getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    if (erectionRate.length > 0) {
                        cellToUpdate8.setCellValue(erectionRate[index]);
                        if (!(erectionRate[index].isEmpty())) {
                            erectionAmountTotal = erectionAmountTotal + Double.parseDouble(erectionAmount[index]);
                        }
                    }
                    cellToUpdate8.setCellStyle(whiteBackGroundTextCenter);

                    Cell cellToUpdate10 = sheet.getRow(nextRow).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    if (erectionAmount.length > 0)
                        cellToUpdate10.setCellValue(erectionAmount[index]);
                    cellToUpdate10.setCellStyle(whiteBackGroundTextCenter);

                    if (null != inventory.getSpecLine() && !("".equals(inventory.getSpecLine()))) {
                        sheet.getRow(nextRow).getCell(0).setCellStyle(whiteBackGround);
                        sheet.createRow(++nextRow);
                        Cell cellToUpdate3 = sheet.getRow(nextRow).getCell(1,
                                Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        cellToUpdate3.setCellValue(inventory.getSpecLine());
                        cellToUpdate3.setCellStyle(whiteBackGround);

                        for (int l = 0; l < 8; l++) {
                            sheet.getRow(nextRow).getCell(l, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                                    .setCellStyle(whiteBackGround);
                        }
                    } else {
                        pushBy++;
                    }

                    if (null != inventory.getGrdLine() && !("".equals(inventory.getGrdLine()))) {
                        sheet.getRow(nextRow).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                                .setCellStyle(whiteBackGround);
                        sheet.createRow(++nextRow);
                        Cell cellToUpdate1 = sheet.getRow(nextRow).getCell(1,
                                Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        cellToUpdate1.setCellValue(inventory.getGrdLine());
                        cellToUpdate1.setCellStyle(whiteBackGround);

                        for (int l = 0; l < 8; l++) {
                            sheet.getRow(nextRow).getCell(l, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                                    .setCellStyle(whiteBackGround);
                        }
                    } else {
                        pushBy++;
                    }

                    if (null != inventory.getEndsLine() && !("".equals(inventory.getEndsLine()))) {
                        sheet.getRow(nextRow).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                                .setCellStyle(whiteBackGround);
                        sheet.createRow(++nextRow);
                        Cell cellToUpdate4 = sheet.getRow(nextRow).getCell(1,
                                Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        cellToUpdate4.setCellValue(inventory.getEndsLine());
                        cellToUpdate4.setCellStyle(whiteBackGround);

                        for (int l = 0; l < 8; l++) {
                            sheet.getRow(nextRow).getCell(l, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                                    .setCellStyle(whiteBackGround);
                        }
                    } else {
                        pushBy++;
                    }

                    if (null != inventory.getMakesLine() && !("".equals(inventory.getMakesLine()))) {
                        sheet.getRow(nextRow).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                                .setCellStyle(whiteBackGround);
                        sheet.createRow(++nextRow);
                        Cell cellToUpdate7 = sheet.getRow(nextRow).getCell(1,
                                Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        cellToUpdate7.setCellValue(inventory.getMakesLine());
                        cellToUpdate7.setCellStyle(whiteBackGround);

                        for (int l = 0; l < 8; l++) {
                            sheet.getRow(nextRow).getCell(l, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                                    .setCellStyle(whiteBackGround);
                        }
                    } else {
                        pushBy++;
                    }

                    rowB4Push = nextRow;
                    nextRow = nextRow + pushBy + 4 + i;
                }

                if (shouldEnd || (invIndx == (lastIndex - 1))) {
                    int count = rowB4Push + pushBy + 3;
                    int start = rowB4Push + 1;

                    if (invRepeateCount > 6) {
                        count = count + (invRepeateCount - 6);
                        start = start + (invRepeateCount - 6);
                    }

                    for (int p = start; p < count; p++) {
                        sheet.createRow(p);

                        if (p != (count - 1)) {
                            for (int k = 0; k < 8; k++) {

                                Cell lastButOneCell = sheet.getRow(p).getCell(k,
                                        Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                                lastButOneCell.setCellStyle(whiteBackGround);
                            }
                        } else {
                            for (int k = 0; k < 8; k++) {
                                Cell lastCell = sheet.getRow(p).getCell(k, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                                lastCell.setCellStyle(whiteBackGroundBaseLineRight);

                            }
                        }
                    }
                    invRepeateCount = 0;
                }

                index++;

                System.out.println("Next Row is : " + nextRow);
                System.out.println("Next start index is : " + startIndex);
            }

           sheet.createRow(nextRow - 2);

            sheet.getRow(nextRow - 2).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue("SubTotal");
            sheet.getRow(nextRow - 2).getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .setCellValue(supplyAmountTotal);
            sheet.getRow(nextRow - 2).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .setCellValue(erectionAmountTotal);
            
           sheet.createRow(nextRow - 1);
        //   sheet.addMergedRegion(new CellRangeAddress(1, 19, 3, 19));
          //Row lastRow = sheet.createRow(nextRow - 1);
//            Cell lastTotal =  sheet.getRow(nextRow - 1).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//            Cell lastTotal1 = sheet.getRow(nextRow - 1).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK); 
//            lastTotal.setCellValue("Total");
//            lastTotal1.setCellValue(erectionAmountTotal+supplyAmountTotal);
          // sheet.addMergedRegion(new CellRangeAddress(1, 2, 3, 0));
          
            sheet.getRow(nextRow - 1).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue("Total");
           sheet.getRow(nextRow - 1).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(erectionAmountTotal+supplyAmountTotal);
           //sheet.getRow(nextRow - 1).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellStyle(whiteBackGround);
            //sheet.getRow(nextRow - 1).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellStyle(whiteBackGround);
            sheet.getRow(nextRow - 1).getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellStyle(whiteBackGroundBaseLineRight);
         sheet.getRow(nextRow - 1).getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellStyle(whiteBackGroundBaseLineRight);
         sheet.getRow(nextRow - 1).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellStyle(whiteBackGroundBaseLineRight);
         sheet.getRow(nextRow - 1).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellStyle(whiteBackGroundBaseLineRight);
         sheet.getRow(nextRow - 1).getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellStyle(whiteBackGroundBaseLineRight);
         sheet.getRow(nextRow - 1).getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellStyle(whiteBackGroundBaseLineRight);
         sheet.getRow(nextRow - 1).getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellStyle(whiteBackGroundBaseLineRight);
         sheet.getRow(nextRow - 1).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellStyle(whiteBackGroundBaseLineRight);
           

            Sheet annexture = workBook.getSheetAt(0);

            annexture.getRow(4 + s).getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(s);
            annexture.getRow(4 + s).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .setCellValue(sheet.getSheetName());
            annexture.getRow(4 + s).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .setCellValue(supplyAmountTotal);
            annexture.getRow(4 + s).getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .setCellValue(erectionAmountTotal);

            Cell supplyTotalCell = annexture.getRow(15).getCell(3);
            Cell erectionTotalCell = annexture.getRow(15).getCell(4);

            FormulaEvaluator evaluator = workBook.getCreationHelper().createFormulaEvaluator();

            evaluator.evaluateFormulaCell(supplyTotalCell);
            evaluator.evaluateFormulaCell(erectionTotalCell);

            for (int k = 0; k < 8; k++) {
                Cell lastCell = sheet.getRow(nextRow - 2).getCell(k, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                lastCell.setCellStyle(whiteBackGroundBaseLineRight);
            }

            startIndex = startIndex + inventoryCount;

            for (int j = 0; j < 8; j++) {
                sheet.autoSizeColumn(j);
            }

            //If this an Inquiry, we are removing BOQHeader details
            if (isOffer) {
                System.out.println("sheet.getNumMergedRegions() is : " + sheet.getNumMergedRegions());

                while (sheet.getNumMergedRegions() > 0) {
                    for (int l = 0; l <= sheet.getNumMergedRegions(); l++) {
                        sheet.removeMergedRegion(l);
                    }
                }

                sheet.shiftRows(7, sheet.getLastRowNum(), -7, true, true);

            }
        }

        if (isInvoiceAnnexture)
        {
            workBook.removeSheetAt(0);
            workBook.removeSheetAt(1);
        }
        else if (isOffer || isBOQ)
        {
            workBook.removeSheetAt(0);
            workBook.removeSheetAt(0);
            workBook.removeSheetAt(0);
        }  
                
        else {

            Sheet cover = workBook.getSheetAt(0);

            cover.getRow(6).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .setCellValue(new SimpleDateFormat("dd-MMMM-yyyy").format(new Date()));
            cover.getRow(7).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue("");

            cover.getRow(7).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(header.getClient());
            cover.getRow(8).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(header.getSite());

            cover.getRow(10).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .setCellValue(cover.getRow(10).getCell(2).getStringCellValue() + "");

            cover.getRow(12).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .setCellValue(cover.getRow(12).getCell(2).getStringCellValue() + header.getClient());
            cover.getRow(22).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(header.getUtility());

            FormulaEvaluator evaluator1 = workBook.getCreationHelper().createFormulaEvaluator();

            evaluator1.evaluateFormulaCell(cover.getRow(23).getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
            evaluator1.evaluateFormulaCell(cover.getRow(23).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
            evaluator1.evaluateFormulaCell(cover.getRow(24).getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
            evaluator1.evaluateFormulaCell(cover.getRow(24).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
            evaluator1.evaluateFormulaCell(cover.getRow(25).getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
            evaluator1.evaluateFormulaCell(cover.getRow(26).getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
            evaluator1.evaluateFormulaCell(cover.getRow(27).getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));


            String[] termsSplited = (header.getPaymentTerms()).split("\r\n");

            StringBuilder forSupply = new StringBuilder();
            StringBuilder forLabor = new StringBuilder();

            int laborTermIndex = 0;
            int supplyTermIndex = 0;
            boolean islabor = false;
            for (int i = 0; i < termsSplited.length; i++) {
                if ("FOR LABOR:".equalsIgnoreCase(termsSplited[i].trim())) {
                    islabor = true;
                }

                if (islabor) {
                    forLabor.append(termsSplited[i] + "\r\n");
                    cover.getRow(42 + laborTermIndex).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(termsSplited[i]);
                    laborTermIndex++;
                } else {
                    forSupply.append(termsSplited[i] + "\r\n");
                    cover.getRow(38 + supplyTermIndex).getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellValue(termsSplited[i]);
                    supplyTermIndex++;
                }

            }

            workBook.removeSheetAt(2);
        }

        inputStream.close();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            workBook.write(bos);
        } finally {
            bos.close();
        }
        byte[] bytes = bos.toByteArray();

        // Closing the workbook
        workBook.close();

        return bytes;
    }

    public void generatePO() {

    }

    public byte[] createDesignOffer(DesignOffer designOffer) {

        try {
            Workbook workBook = null;

            Resource resource = new ClassPathResource("DesignOfferTemplate.xls");
            InputStream inputStream = resource.getInputStream();

            workBook = WorkbookFactory.create(inputStream);

            Sheet sheet = workBook.getSheetAt(0);

			//Doc number
            sheet.getRow(2).getCell(0).setCellValue("Doc No."+designOffer.getDocNumber());

            // Date
			SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yy");
			sheet.getRow(3).getCell(7).setCellValue(df.format(designOffer.getCreationDate()));

			//Name
			sheet.getRow(4).getCell(0).setCellValue(designOffer.getContactName());

			//Company
			sheet.getRow(5).getCell(0).setCellValue(designOffer.getClientCompany());

			//Address
			sheet.getRow(6).getCell(0).setCellValue(designOffer.getAddress());

			//City - PIN
			sheet.getRow(7).getCell(0).setCellValue(designOffer.getCity()+" - "+designOffer.getPinCode());

			//Subject
			sheet.getRow(10).getCell(1).setCellValue(designOffer.getSubject() + " : " + designOffer.getUtility());

			//Main Description
			sheet.getRow(15).getCell(1).setCellValue(designOffer.getLineItemMainDesc());

			String seperater = "\\&\\*\\&\\*";

			//Line Items
			String[] lineItemDesc = designOffer.getLineItemDesc().split(seperater);
			String[] lineItemQty = designOffer.getLineItemQty().split(seperater);
			String[] lineItemRate = designOffer.getLineItemRate().split(seperater);

			for(int i=0; i< lineItemDesc.length;i++)
			{
				sheet.getRow(16+i).getCell(1).setCellValue(lineItemDesc[i]);
				sheet.getRow(16+i).getCell(5).setCellValue(lineItemQty[i]);
				sheet.getRow(16+i).getCell(6).setCellValue(lineItemRate[i]);
			}

			//Scope
			String[] scope = designOffer.getScope().split(seperater);
			for(int i=0; i<scope.length; i++)
			{
				if(23+i>=29)
				{
					sheet.getRow(24+i).getCell(0).setCellValue(scope[i]);
				}
				else {
					sheet.getRow(23 + i).getCell(0).setCellValue(scope[i]);
				}
			}

			//Deliverables
			String[] deliverables = designOffer.getDeliverables().split(seperater);
			for(int i=0; i<deliverables.length; i++)
			{
				sheet.getRow(33 + i).getCell(0).setCellValue(deliverables[i]);
			}

			//Delivery
			String[] delivery = designOffer.getDelivery().split(seperater);
			for(int i=0; i<delivery.length; i++)
			{
				sheet.getRow(42 + i).getCell(1).setCellValue(delivery[i]);
			}

			//Payment Terms
			String[] payTerms = designOffer.getPayTerm().split(seperater);
			for(int i=0; i<payTerms.length; i++)
			{
				sheet.getRow(47 + i).getCell(1).setCellValue(payTerms[i]);
			}

			//General Terms
			String[] termsAndCondition = designOffer.getTermsAndCondition().split(seperater);
			for(int i=0; i<termsAndCondition.length; i++)
			{
				sheet.getRow(53 + i).getCell(1).setCellValue(termsAndCondition[i]);
			}

            //Validity
            String[] validity = designOffer.getValidity().split(seperater);
            for(int i=0; i<validity.length; i++)
            {
                sheet.getRow(61 + i).getCell(1).setCellValue(validity[i]);
            }

			FormulaEvaluator evaluator1 = workBook.getCreationHelper().createFormulaEvaluator();

			evaluator1.evaluateFormulaCell(sheet.getRow(16).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
			evaluator1.evaluateFormulaCell(sheet.getRow(17).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
			evaluator1.evaluateFormulaCell(sheet.getRow(18).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
			evaluator1.evaluateFormulaCell(sheet.getRow(19).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
			evaluator1.evaluateFormulaCell(sheet.getRow(20).getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));

			inputStream.close();

			ByteArrayOutputStream bOut = new ByteArrayOutputStream();

			workBook.write(bOut);

			bOut.close();
			byte[] designOfferBytes = bOut.toByteArray();

			workBook.close();

			return designOfferBytes;

        } catch (Exception ex) {
            ex.printStackTrace();
        	return null;
        }
    }


    /*
     * Get the data in excel file. Return: 2D String list contains specified row
     * data. excelFilePath : The exist file path need to copy. excelSheetName :
     * Which sheet to copy. startRow : Start row number. endRow : End row
     * number.
     */
    private List<List<String>> getExcelData(File excelFilePath, String excelSheetName, int startRow, int endRow) {
        List<List<String>> ret = new ArrayList();

        try {
            /* Open the file input stream. */
            FileInputStream fis = new FileInputStream(excelFilePath);

            /* Get workbook. */
            Workbook excelWookBook = new HSSFWorkbook(fis);

            /* Get sheet by name. */
            Sheet copySheet = excelWookBook.getSheet(excelSheetName);

            int fRowNum = copySheet.getFirstRowNum();
            int lRowNum = copySheet.getLastRowNum();

            /*
             * First row is excel file header, so read data from row next to it.
             */
            for (int i = fRowNum + 1; i < lRowNum + 1; i++) {
                /* Only get desired row data. */
                if (i >= startRow && i <= endRow) {
                    Row row = copySheet.getRow(i);

                    int fCellNum = row.getFirstCellNum();
                    int lCellNum = row.getLastCellNum();

                    /* Loop in cells, add each cell value to the list. */
                    List<String> rowDataList = new ArrayList<String>();
                    for (int j = fCellNum; j < lCellNum; j++) {
                        String cValue = row.getCell(j).getStringCellValue();
                        rowDataList.add(cValue);
                    }

                    ret.add(rowDataList);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ret;
    }

    private static void copyCell(Cell oldCell, Cell newCell) {

        newCell.setCellStyle(oldCell.getCellStyle());

        switch (oldCell.getCellType()) {
            case STRING:
                newCell.setCellValue(oldCell.getRichStringCellValue());
                break;
            case NUMERIC:
                newCell.setCellValue(oldCell.getNumericCellValue());
                break;
            case BLANK:
                newCell.setBlank();
                break;
            case FORMULA:
                newCell.setCellFormula(oldCell.getCellFormula());
                break;
            case BOOLEAN:
                newCell.setCellValue(oldCell.getBooleanCellValue());
                break;
            case ERROR:
                newCell.setCellErrorValue(oldCell.getErrorCellValue());
                break;
            default:
                break;
        }
    }
}
