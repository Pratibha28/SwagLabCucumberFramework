package dataProvider;

import java.util.HashMap;
import java.util.Map;

import utils.ExcelLibrary;

public class DataProvider extends ExcelLibrary {
	// valid credential login details
				@org.testng.annotations.DataProvider(name = "loginTestData")
				public Object[][] getCredential() {

					// Total row count
					int row = getRowCount("Credentials");

					// Total column count
					int column = getColumnCount("Credentials");

					int actRow = row - 1;

					Object[][] data = new Object[actRow][1];

					for (int i = 0; i < actRow; i++) {
						Map<String, String> hashMap = new HashMap<>();

						for (int j = 0; j < column; j++) {

							hashMap.put(getCellData("Credentials", j, 1), getCellData("Credentials", j, i + 2));
						}
						data[i][0] = hashMap;
					}

					return data;
				}
				
				
				@org.testng.annotations.DataProvider(name = "loginTestData")
				public Object[][] getInValidCredential() {

					// Total row count
					int row = getRowCount("InvalidCredentials");

					// Total column count
					int column = getColumnCount("InvalidCredentials");

					int actRow = row - 1;

					Object[][] data = new Object[actRow][1];

					for (int i = 0; i < actRow; i++) {
						Map<String, String> hashMap = new HashMap<>();

						for (int j = 0; j < column; j++) {

							hashMap.put(getCellData("InvalidCredentials", j, 1), getCellData("InvalidCredentials", j, i + 2));
						}
						data[i][0] = hashMap;
					}

					return data;
				}
}
