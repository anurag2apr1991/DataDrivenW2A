package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase{

	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alertText) {
		driver.findElement(By.xpath(OR.getProperty("addCustBtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postCode);
		driver.findElement(By.xpath(OR.getProperty("addbtn"))).click();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;
		
	}
}
