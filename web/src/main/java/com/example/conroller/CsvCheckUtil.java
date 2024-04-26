package com.example.conroller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvCheckUtil {

    public static void main(String[] args) {
        String csvFilePath = "/Users/chenghao/Downloads/office/sevenfee/对比/mq当前数量.csv";
        List<Map<String, String>> list = new ArrayList<>();

        EasyExcel.read(csvFilePath, CsvData.class, new CsvDataListener(list)).sheet().doRead();

        System.out.println(list);
    }

    public static class CsvData {
        @ExcelProperty("列1")
        private String col1;
        @ExcelProperty("列2")
        private String col2;

        // getter and setter methods


        public String getCol1() {
            return col1;
        }

        public void setCol1(String col1) {
            this.col1 = col1;
        }

        public String getCol2() {
            return col2;
        }

        public void setCol2(String col2) {
            this.col2 = col2;
        }
    }

    public static class CsvDataListener extends AnalysisEventListener<CsvData> {
        private List<Map<String, String>> list;

        public CsvDataListener(List<Map<String, String>> list) {
            this.list = list;
        }

        @Override
        public void invoke(CsvData csvData, AnalysisContext analysisContext) {
            Map<String, String> map = new HashMap<>();
            map.put("列1", csvData.getCol1());
            map.put("列2", csvData.getCol2());
            list.add(map);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            // do nothing
        }
    }
}