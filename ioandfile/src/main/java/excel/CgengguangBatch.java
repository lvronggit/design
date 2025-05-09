package excel;/*
 * Copyright (C), 2002-2024, 汇付天下
 * FileName: KuaiDi.java
 * Author:   rong.lv
 * Date:     2024/4/15 10:55
 * Description: //模块目的、功能描述
 */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class CgengguangBatch {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\橙光跑批\\南京浦发.xlsx";
        String newfilePath = "D:\\橙光跑批\\南京浦发.txt";
        File file =new File(filePath);
        File newFile  = new File(newfilePath);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // 获取第一个Sheet
        // 获取行数和列数
        int rowCount = sheet.getLastRowNum() + 1;
        /**
         * INSERT INTO `unsign_merchant_push_bank` (`huifu_id`,`batch_date`,`push_stat`, `push_bank_type`, `mode_type`,`begin_date`,`end_date`,`product_id`) VALUES
         * ( '6666000146805134', '20250305', 'S', '03100000', 'CUSTOMIZE','20250101','20250308','SPIN_EDUSTD'),
         */
        String startstr = "INSERT INTO `unsign_merchant_push_bank` (`huifu_id`,`batch_date`,`push_stat`, `push_bank_type`, `mode_type`,`begin_date`,`end_date`,`product_id`,`allowance_sys_id`) VALUES ";

        bufferedWriter.append(startstr);
        bufferedWriter.newLine();
        for (int i = 0; i < rowCount; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("('");
            Row row = sheet.getRow(i);
            // 遍历每一列
            Cell huifuId = row.getCell(1);
            stringBuffer.append(huifuId.getStringCellValue());
            stringBuffer.append("', '20250317', 'S', '03100000', 'CUSTOMIZE','20250101','20250318'");
            Cell product = row.getCell(2);
            stringBuffer.append(",");
            stringBuffer.append("'");
            stringBuffer.append(product.getStringCellValue());
            stringBuffer.append("'");
            stringBuffer.append(",");
            stringBuffer.append("'9300'");
            stringBuffer.append("),");
            bufferedWriter.append(stringBuffer.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        inputStream.close();
        // 将更新后的工作簿写入文件
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }


}
