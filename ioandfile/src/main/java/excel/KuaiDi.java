package excel;/*
 * Copyright (C), 2002-2024, 汇付天下
 * FileName: KuaiDi.java
 * Author:   rong.lv
 * Date:     2024/4/15 10:55
 * Description: //模块目的、功能描述
 */

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class KuaiDi {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\rong.lv\\Desktop\\快递\\";
        File[] list = new File(filePath).listFiles();
        for (int s = 0; s < list.length; s++) {
            File file = list[s];
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // 获取第一个Sheet
   /*     Row row = sheet.getRow(0); // 获取第一行
        if (row == null) {
            row = sheet.createRow(0); // 如果不存在则创建
        }
        Cell cell = row.getCell(0); // 获取第一个单元格
        if (cell == null) {
            cell = row.createCell(0); // 如果不存在则创建
        }
        cell.setCellValue("新的内容"); // 设置新的内容
*/
            // 获取行数和列数
            int rowCount = sheet.getLastRowNum() + 1;
            int columnCount = sheet.getRow(0).getLastCellNum();
            Row titleRow = sheet.getRow(0);
            int receiveAddReadressIndex = 9;
            int weightIndex = 19;
            for (int i = 0; i < columnCount; i++) {
                Cell cell = titleRow.getCell(i);
                // 获取单元格的值
                String cellValue = "";
                if (cell != null) {
                    cellValue = cell.getStringCellValue();
                    if ("收件人地址".equals(cellValue)) {
                        receiveAddReadressIndex = i;
                    } else if ("结算重量".equals(cellValue)) {
                        weightIndex = i;
                    }
                }
            }
            // 跳过标题
            double sumResult = 0.00;
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                // 遍历每一列
                Cell weight = row.getCell(weightIndex);
                Cell addr = row.getCell(receiveAddReadressIndex);
                double result = new Compute(addr.getStringCellValue()).ComputeResult(weight.getNumericCellValue());
                sumResult = sumResult+result;
                Cell resulRcell = row.createCell(columnCount );
                resulRcell.setCellValue(result);
            }
            System.out.println(file.getName()+"      "+sumResult);

            inputStream.close();
            // 将更新后的工作簿写入文件
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        }

    }


    static class Compute {
        private String receivePrice;
        private double startPrice = 0.00;
        private double addPrice = 0.00;
        private double otherAddPrice = 0.00;

        public double ComputeResult(double weight) {
            double reslut;
            if (weight <= 30) {
                reslut = startPrice;
            } else {
                reslut = startPrice + (addPrice + otherAddPrice) * (weight - 30);
            }

            return reslut;
        }


        public Compute(String address) {
            if (address.startsWith("湖南省")) {
                startPrice = 30;
                addPrice = 1.2;
                if (address.indexOf("湘西") > 0) {
                    otherAddPrice = 0.3;
                }
            } else if (address.startsWith("江西省")) {
                startPrice = 30;
                addPrice = 0.9;
            } else if (address.startsWith("浙江省")) {
                startPrice = 35;
                addPrice = 1;
                if (address.indexOf("舟山") > 0) {
                    otherAddPrice = 0.3;
                }
            } else if (address.startsWith("江苏省")) {
                startPrice = 35;
                addPrice = 1.1;
            } else if (address.startsWith("上海")) {
                startPrice = 35;
                addPrice = 1.1;
            } else if (address.startsWith("安徽省")) {
                startPrice = 30;
                addPrice = 1.1;
            } else if (address.startsWith("湖北省")) {
                startPrice = 35;
                addPrice = 1.2;
                if (address.indexOf("伍家岗") > 0) {
                    otherAddPrice = 0.2;
                } else if (address.indexOf("神农架") > 0) {
                    otherAddPrice = 0.2;
                }
            } else if (address.startsWith("福建省")) {
                startPrice = 35;
                addPrice = 1.2;
            } else if (address.startsWith("广东省")) {
                startPrice = 35;
                addPrice = 1.2;
                if (address.indexOf("茂名") > 0) {
                    otherAddPrice = 0.3;
                } else if (address.indexOf("湛江") > 0) {
                    otherAddPrice = 0.3;
                }
            } else if (address.startsWith("山东省")) {
                startPrice = 40;
                addPrice = 1.4;
            } else if (address.startsWith("河南省")) {
                startPrice = 35;
                addPrice = 1.3;
            } else if (address.startsWith("河北省")) {
                startPrice = 40;
                addPrice = 1.5;
                if (address.indexOf("唐山") > 0) {
                    otherAddPrice = 0.1;
                } else if (address.indexOf("秦皇岛") > 0) {
                    otherAddPrice = 0.1;
                }
            } else if (address.startsWith("天津")) {
                startPrice = 40;
                addPrice = 1.7;
            } else if (address.startsWith("广西省")) {
                startPrice = 40;
                addPrice = 1.7;
                if (address.indexOf("梧州") > 0) {
                    otherAddPrice = 0.1;
                } else if (address.indexOf("桂林") > 0) {
                    otherAddPrice = 0.1;
                } else if (address.indexOf("加州") > 0) {
                    otherAddPrice = 0.1;
                }
            } else if (address.startsWith("北京")) {
                startPrice = 55;
                addPrice = 1.8;
            } else if (address.startsWith("黑龙江省")) {
                startPrice = 60;
                addPrice = 2;
                if (address.indexOf("齐齐哈尔") > 0) {
                    otherAddPrice = 0.2;
                } else if (address.indexOf("大庆") > 0) {
                    otherAddPrice = 0.2;
                } else if (address.indexOf("鹤岗") > 0) {
                    otherAddPrice = 0.2;
                }
            } else if (address.startsWith("吉林省")) {
                startPrice = 60;
                addPrice = 2;
                if (address.indexOf("延边") > 0) {
                    otherAddPrice = 0.2;
                } else if (address.indexOf("白城") > 0) {
                    otherAddPrice = 0.2;
                }
            } else if (address.startsWith("辽宁省")) {
                startPrice = 60;
                addPrice = 2;
                if (address.indexOf("鞍山") > 0) {
                    otherAddPrice = 0.2;
                } else if (address.indexOf("本溪") > 0) {
                    otherAddPrice = 0.2;
                } else if (address.indexOf("丹东") > 0) {
                    otherAddPrice = 0.2;
                }
            } else if (address.startsWith("四川省")) {
                startPrice = 45;
                addPrice = 1.6;
                if (address.indexOf("凉山") > 0) {
                    otherAddPrice = 0.2;
                } else if (address.indexOf("雅安") > 0) {
                    otherAddPrice = 0.2;
                } else if (address.indexOf("阿坝") > 0) {
                    otherAddPrice = 0.2;
                }
            } else if (address.startsWith("重庆")) {
                startPrice = 45;
                addPrice = 1.6;
                if (address.indexOf("万州") > 0) {
                    otherAddPrice = 0.2;
                } else if (address.indexOf("秀山") > 0) {
                    otherAddPrice = 0.2;
                }
            } else if (address.startsWith("山西省")) {
                startPrice = 45;
                addPrice = 1.7;
            } else if (address.startsWith("陕西省")) {
                startPrice = 45;
                addPrice = 1.7;
                if (address.indexOf("榆林") > 0) {
                    otherAddPrice = 0.2;
                }
            } else if (address.startsWith("贵州省")) {
                startPrice = 50;
                addPrice = 1.7;
            } else if (address.startsWith("云南省")) {
                startPrice = 70;
                addPrice = 2;
            } else if (address.startsWith("内蒙古省")) {
                startPrice = 80;
                addPrice = 2.8;
            } else if (address.startsWith("甘肃")) {
                startPrice = 80;
                addPrice = 2.8;
            } else if (address.startsWith("宁夏")) {
                startPrice = 80;
                addPrice = 2.8;
            } else if (address.startsWith("青海")) {
                startPrice = 80;
                addPrice = 2.8;
            } else if (address.startsWith("新疆")) {
                startPrice = 100;
                addPrice = 3.2;
            }
        }


    }

}
