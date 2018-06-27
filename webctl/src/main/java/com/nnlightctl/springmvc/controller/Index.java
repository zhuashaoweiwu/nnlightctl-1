package com.nnlightctl.springmvc.controller;

import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.IndexServer;
import com.nnlightctl.util.DownloadUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class Index extends BaseController {

    @Autowired
    private IndexServer indexServer;

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return indexServer.indexServer();
    }

    @RequestMapping("/")
    public String indexPage() {
        return "redirect:/html/pages/index.html";
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(MultipartFile file) {
        if (file != null) {
            String filePath = "d:/";
            filePath += file.getOriginalFilename();
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }

            return toJson(JsonResult.getSUCCESS());
        }

        return toJson(JsonResult.getFAILURE());
    }

    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) {
        // 获取workbook对象
        HSSFWorkbook workbook = exportSheetByTemplate();

        // 设置excel的文件名称
        String excelName = "测试excel";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = "[" + excelName + "-" + sdf.format(new Date()) + "]";

        DownloadUtil.downloadExcel(response, dateStr, workbook);
    }

    @RequestMapping("/importExcel")
    @ResponseBody
    public String importExcel(MultipartFile excelFile) {
        try {
            readExcel(excelFile.getInputStream(), excelFile.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    private void readExcel(InputStream is, String fileName) throws IOException {
        Workbook hssfWorkbook = null;
        if (fileName.endsWith("xlsx")){
            hssfWorkbook = new XSSFWorkbook(is);//Excel 2007
        }else if (fileName.endsWith("xls")){
            hssfWorkbook = new HSSFWorkbook(is);//Excel 2003

        }

        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                Row hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    //循环列
                    for (int colNum = 0; colNum <= hssfRow.getLastCellNum(); ++colNum) {
                        Cell value = hssfRow.getCell(colNum);
                        System.out.print(value);
                        System.out.print("  ");
                    }
                    System.out.println();
                }
            }
        }

        is.close();
    }

    private HSSFWorkbook exportSheetByTemplate() {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("成绩表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("学员考试成绩一览表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
        //在sheet里创建第二行
        HSSFRow row2 = sheet.createRow(1);
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("姓名");
        row2.createCell(1).setCellValue("班级");
        row2.createCell(2).setCellValue("笔试成绩");
        row2.createCell(3).setCellValue("机试成绩");
        //在sheet里创建第三行
        HSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("李明");
        row3.createCell(1).setCellValue("As178");
        row3.createCell(2).setCellValue(87);
        row3.createCell(3).setCellValue(78);

        return wb;
    }

}
