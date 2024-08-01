package org.demo.utilz;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] raedExcel(String filename){
		String fileLocation= "./test-data/"+filename+".xlsx";
		
		XSSFWorkbook wb=null;
		try {
			wb = new XSSFWorkbook(fileLocation);
		
		XSSFSheet st= wb.getSheetAt(0);
		int len=st.getLastRowNum();
		int lencell=st.getRow(0).getLastCellNum();
		String[][] data=new String[len][lencell];
		for (int i = 1; i <=len; i++) {
			XSSFRow rw = st.getRow(i);
			for (int j = 0; j < lencell; j++) {
				XSSFCell cl = rw.getCell(j);
				DataFormatter dft=new DataFormatter();
				String value =dft.formatCellValue(cl);
				data[i-1][j]=value;
			} 
		
		}
		return data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finally {
		try {
			if (wb != null) 
				wb.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("file Alread open");
			//e.printStackTrace();
		}
		}
		return null;
		
	}
}
