package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readXLSdata {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		 readXLSdata red = new readXLSdata();
		 red.getData("login");

	}
	public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException 
	{
	
	File f = new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\testdata\\testdata.xlsx" ); //------Read The FIle------------
	FileInputStream fis = new FileInputStream(f);  //---------Create a stream of the instance file----
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheetName = wb.getSheet(excelSheetName);//-----Access Excel workbook-------
	
	
	
	int totalRows = sheetName.getLastRowNum(); //---------Count rows in the table ---------
			System.out.println(totalRows);
			
    Row rowCells = sheetName.getRow(0);  //---------Count how many cells in a rows ---------
			
	int totalCols = rowCells.getLastCellNum();  //-----Last sell number that logical row selects
			System.out.println(totalCols);
			
			
			
	DataFormatter format = new DataFormatter(); // what ever we got from the sheet(int,boolen,string) neeed to be format and display
			System.out.println(format);
			
	
    String testData[][] = new String[totalRows][totalCols];
	for(int i=1; i<=totalRows;i++) {
		for(int j=0;j<totalCols;j++) {
			testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
			System.out.println(testData[i-1][j]);
		}
		}
	
	return testData;
	}
			
			
			
}
