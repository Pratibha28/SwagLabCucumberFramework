package dataProvider;

import java.util.HashMap;
import java.util.Map;

import utils.ExcelLibrary;

public class DataProviders extends ExcelLibrary {

    /**
     * Valid credential login details
     */
    @org.testng.annotations.DataProvider(name = "validLoginData")
    public Object[][] getCredential() {
        return loadSheetData("Credentials");
    }

    /**
     * Invalid credential login details
     */
    @org.testng.annotations.DataProvider(name = "invalidLoginData")
    public Object[][] getInValidCredential() {
        return loadSheetData("InvalidCredentials");
    }
    
    //
    
    /**
     * get product details
     */
    @org.testng.annotations.DataProvider(name = "ProductDetails")
    public Object[][] getProductDetails() {
        return loadSheetData("ProductDetails");
    }
    /**
     * Generic entry point: returns the map for the given scenarioName
     * from the sheet identified by sheetName.
     */
    public Map<String, String> getDataByScenarioName(String scenarioName, String sheetName) {
        // Choose which raw data to use
        Object[][] raw = null;
        switch (sheetName.toLowerCase()) {
            case "credentials":
            case "validlogin":
                raw = getCredential();
                break;
            case "invalidcredentials":
            case "invalidlogin":
                raw = getInValidCredential();
                break;
                
            case "productdetails":
            case "productdetail":
                raw = getProductDetails();
                break;
                
                
			/*
			 * default: throw new IllegalArgumentException("Unknown sheet name: " +
			 * sheetName);
			 */
        }

        // Find the row whose map has ScenarioName == scenarioName
        for (Object[] row : raw) {
            @SuppressWarnings("unchecked")
            Map<String, String> rowMap = (Map<String, String>) row[0];
            System.out.println("Row keys: " + rowMap.keySet());   
            String nameKey = rowMap.get("ScenarioName");
            if (nameKey != null && scenarioName.equalsIgnoreCase(nameKey.trim())) {
                return rowMap;
            }
        }
        return null;  // no match found
    }

    /**
     * Internal helper to read any sheet into an Object[][] of Map<String,String>
     */
    public Object[][] loadSheetData(String sheetName) {
        int rowCount    = getRowCount(sheetName);
        int colCount    = getColumnCount(sheetName);
        int dataRows    = Math.max(0, rowCount - 1);  // first row is header

        Object[][] data = new Object[dataRows][1];
        for (int i = 0; i < dataRows; i++) {
            Map<String, String> map = new HashMap<>();
            for (int j = 0; j < colCount; j++) {
                String key   = getCellData(sheetName, j, 1);     // headers in row 1
                String value = getCellData(sheetName, j, i + 2); // data starts in row 2
                map.put(key.trim(), value.trim());
            }
            data[i][0] = map;
        }
        return data;
    }
}
