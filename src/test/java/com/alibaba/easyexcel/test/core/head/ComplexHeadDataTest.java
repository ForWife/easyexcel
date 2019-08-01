package com.alibaba.easyexcel.test.core.head;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.easyexcel.test.util.TestFileUtil;
import com.alibaba.excel.EasyExcelFactory;

/**
 *
 * @author zhuangjiaju
 */
public class ComplexHeadDataTest {

    private static File file07;
    private static File file03;

    @BeforeClass
    public static void init() {
        file07 = TestFileUtil.createNewFile("complexHead07.xlsx");
        file03 = TestFileUtil.createNewFile("complexHead03.xls");
    }

    @Test
    public void T01ReadAndWrite07() {
        readAndWrite(file07);
    }

    @Test
    public void T02ReadAndWrite03() {
        readAndWrite(file03);
    }

    private void readAndWrite(File file) {
        EasyExcelFactory.write(file, ComplexHeadData.class).sheet().doWrite(data()).finish();
        EasyExcelFactory.read(file, ComplexHeadData.class, new ComplexDataListener()).sheet().doRead().finish();
    }

    private List<ComplexHeadData> data() {
        List<ComplexHeadData> list = new ArrayList<ComplexHeadData>();
        ComplexHeadData data = new ComplexHeadData();
        data.setString0("字符串0");
        data.setString1("字符串1");
        data.setString2("字符串2");
        data.setString3("字符串3");
        data.setString4("字符串4");
        list.add(data);
        return list;
    }
}
