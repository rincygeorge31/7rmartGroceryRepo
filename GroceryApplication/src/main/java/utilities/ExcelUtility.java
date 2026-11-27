package utilities;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	
	    static FileInputStream f; //help to open file 
	    static XSSFWorkbook w;  // help to read the file in xl format
	    static XSSFSheet sh;   // to get the sheet 

	    public static String readStringData(int row, int col, String sheet) throws IOException {

	        f = new FileInputStream(Constant.TESTDATA);
	        w = new XSSFWorkbook(f);
	        sh = w.getSheet(sheet);

	        XSSFRow r = sh.getRow(row);
	        XSSFCell c = r.getCell(col);

	        return c.getStringCellValue();
	    }

	    public static String readIntegerData(int row, int col,  String sheet) throws IOException {

	        f = new FileInputStream(Constant.TESTDATA);
	        w = new XSSFWorkbook(f);
	        sh = w.getSheet(sheet);

	        XSSFRow r = sh.getRow(row);
	        XSSFCell c = r.getCell(col);

	        int val = (int) c.getNumericCellValue();  // Convert double to int

	        return String.valueOf(val);  // Convert int to String using valueOf()
	    }

}

