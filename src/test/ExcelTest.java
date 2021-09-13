package test;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-09-10-10
 */
public class ExcelTest {

    String PATH = "D:\\JAVA工程\\TestEE\\web";
    @Test
    public void excel01() throws IOException {
        //1.创建工作簿
        Workbook workbook = new HSSFWorkbook();
        //2.创建工作表
        Sheet sheet = workbook.createSheet("测试数据表");
        //3.创建行(1,1)
        Row row = sheet.createRow(0);
        //4.创建单元格
        Cell cell11 = row.createCell(0);
        cell11.setCellValue("查询受教育程度");
        //(1,2)
        Cell cell12 = row.createCell(1);
        cell12.setCellValue("本科");
        //第二行(2,1)
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("查询时间");
        //(2,2)
        Cell cell22 = row2.createCell(1);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(date);
        cell22.setCellValue(time);
        //生成一张表 03版本
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"测试数据表03.xls");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
        System.out.println("测试数据表03生成完毕");
    }
    @Test
    public void excel02() throws IOException {
        //1.创建工作簿
        Workbook workbook = new XSSFWorkbook();
        //2.创建工作表
        Sheet sheet = workbook.createSheet("测试数据表");
        //3.创建行(1,1)
        Row row = sheet.createRow(0);
        //4.创建单元格
        Cell cell11 = row.createCell(0);
        cell11.setCellValue("查询受教育程度");
        //(1,2)
        Cell cell12 = row.createCell(1);
        cell12.setCellValue("本科");
        //第二行(2,1)
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("查询时间");
        //(2,2)
        Cell cell22 = row2.createCell(1);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(date);
        cell22.setCellValue(time);
        //生成一张表 03版本
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"测试数据表03.xlsx");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
        System.out.println("测试数据表03生成完毕");
    }
    @Test
    public void testBigData03() throws IOException {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个薄
        Workbook workbook = new HSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for(int rowNum = 0;rowNum<65536;rowNum++){
            Row row = sheet.createRow(rowNum);
            for(int cellNum = 0;cellNum<10;cellNum++){
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("结束");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"测试大数据表03.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
    @Test
    public void testBigData07() throws IOException {
        //时间
        long begin = System.currentTimeMillis();
        //创建一个薄
        Workbook workbook = new XSSFWorkbook();
        //创建表
        Sheet sheet = workbook.createSheet();
        //写入数据
        for(int rowNum = 0;rowNum<65536;rowNum++){
            Row row = sheet.createRow(rowNum);
            for(int cellNum = 0;cellNum<10;cellNum++){
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("结束");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"测试大数据表07.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-begin)/1000);
    }
}
