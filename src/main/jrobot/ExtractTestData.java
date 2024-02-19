package jrobot;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtractTestData {
    public static HashMap<String,String> result;
    public static XSSFWorkbook workbook;
    
    public static String getTestData(String key)
    {
        return result.get(key);
    }


    
    public static String getCellValue(Cell cell)
    {
        DataFormatter dataFormatter = new DataFormatter();
        return dataFormatter.formatCellValue(cell);
    }
    public static void setTestData(String sheetName,String testCaseName)
    {
        result=new HashMap<>();
        ArrayList<String> keys=new ArrayList<>();
        ArrayList<String> values=new ArrayList<>();
        try {


            InputStream file = new FileInputStream(System.getProperty("user.dir") + "/TestData/"+sheetName+".xlsx");
            workbook = new XSSFWorkbook(file);
            Sheet sheet=workbook.getSheet(sheetName);

            Row firstRow=sheet.getRow(0);
            //creating keys of hashmaps
            for(Cell cell:firstRow)
            {
                keys.add(getCellValue(cell));
            }



            //intializing data for selected testcase
            for(Row row:sheet)
            {
                Cell firstCell=row.getCell(0);
                String tcname=getCellValue(firstCell);

                if(tcname.equalsIgnoreCase(testCaseName))
                {
                    for(Cell cell:row)
                    {

                        values.add(getCellValue(cell));
                    }

                }

            }

            //joining both keys and values into hashmap
            for(int i=0;i<keys.size();i++)
            {
                result.put(keys.get(i),values.get(i));
            }
            workbook.close();
            file.close();
        }
        catch(Exception e)
        {
            System.out.println("error while retrieving data from excel/n more detail"+e.getMessage());
        }


    }
}
