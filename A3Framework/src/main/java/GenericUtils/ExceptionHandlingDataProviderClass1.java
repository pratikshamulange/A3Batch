package GenericUtils;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExceptionHandlingDataProviderClass1 {
	@DataProvider

	public String[][] dataProviderMethod() {
		File f= new File(".\\TestData\\DWS1.xlsx");
		Workbook workbook=null;

		try {
			FileInputStream fis= new FileInputStream(f);
			workbook= WorkbookFactory.create(fis);
		}
		catch(Exception e)
		{
		}
		
		 Sheet Sheet = workbook.getSheet("Sheet1");
		int rowCount = Sheet.getPhysicalNumberOfRows();
		int cellCount = Sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] result= new String[rowCount-1][cellCount];
		for(int i=1;i<rowCount;i++) {
			for(int j=0; j<cellCount;j++) {
				String data = Sheet.getRow(i).getCell(j).toString();
				result[i-1][j]=data;
		}
		}
		
			
		
		return result;
	}

}
