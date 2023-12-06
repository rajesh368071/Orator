package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

	private static String sheetName;
	
	public ExcelReader(String sheetName) {
		this.sheetName = sheetName;
	}
	
	private  static XSSFSheet getSheet() throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			return sheet;
		}
	}	
	
	public static java.util.List<Map<String,String>> getdata() throws IOException {
		XSSFSheet sheet = getSheet();
		java.util.List<Map<String,String>> completedata = null;

		Map<String,String> testdata=null;


		int lastRowNum = sheet.getPhysicalNumberOfRows();
		int lastCellNum = sheet.getRow(0).getLastCellNum();

		//Getting Keys from excel(column header values)
		java.util.List list = new ArrayList();
		for(int c=0;c<lastCellNum;c++) {
			XSSFRow row = sheet.getRow(0);
			XSSFCell cell = row.getCell(c);
			String Keys = cell.getStringCellValue();
			list.add(Keys);
			//System.out.println(Keys);
		}


		completedata= new ArrayList<Map<String,String>>();

		//Getting values from excel(neglecting the column header)
		for(int i=1;i<lastRowNum;i++) {
			XSSFRow row = sheet.getRow(i);
			testdata = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
			for(int j=0;j<lastCellNum;j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String Values = formatter.formatCellValue(cell);
				//System.out.println(Values);
				String put = testdata.put((String) list.get(j), Values);
				//System.out.println(put);
			}
			completedata.add(testdata);

		}
		return completedata;	

	}
	
	/*public void updateExcelSheet() throws IOException {
		File xlsxFile = new File(".\\src\\test\\resources\\TestData.xlsx");
		FileInputStream inputStream = new FileInputStream(xlsxFile);
		Workbook workbook = WorkbookFactory.create(inputStream);
	
		
		Sheet sheet = workbook.getSheet("userdata");
		int rowCount = sheet.getLastRowNum()+1;
		Row row = sheet.createRow(rowCount);
		row.createCell(0).setCellValue("Rajesh");
		row.createCell(1).setCellValue("Raj");
		inputStream.close();
		FileOutputStream os = new FileOutputStream(xlsxFile);
		workbook.write(os);
		workbook.close();
		os.close();
		System.out.println("Updated Successfully");
	}*/
	
	public void writeRecord() {
		
	}
	
	/*public static void main(String args[]) throws IOException {
		ExcelReader sheet = new ExcelReader("userdata");
		sheet.updateExcelSheet();
	}
	
	
	public static Map<String, String> readData() throws IOException {
		sheetName = ".\\src\\test\\resources\\TestData.xlsx";
		Map<String, String> tcs = new TreeMap<String, String>();
		FileInputStream inputStream = new FileInputStream(new File(sheetName));
		
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		
		for(int row=0; row<=sheet.getLastRowNum(); row++) {
			String value = sheet.getRow(row).getCell(2).getStringCellValue();
			if(value.equals("Yes")) {
				String k = sheet.getRow(row).getCell(0).getStringCellValue();
				tcs.put(k, value);
			}
		}
		System.out.print(tcs);
		return tcs;
	}*/


}
