package com.yilan.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

/**
 * Created by Administrator on 2016-11-10.
 */
public class FastExcelTest {
    private final static Logger LOG = LoggerFactory.getLogger(FastExcelTest.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testParse() throws Exception {
        FastExcel fastExcel = new FastExcel("F:\\workspace\\wechat\\src\\test\\resources\\主副营业部.xlsx");
        List<Staff> tests = fastExcel.parse(Staff.class);
        File file = new File("staff.sql");
        if (!file.exists()) file.createNewFile();
        Writer out = new FileWriter(file,true);

        if(null != tests && !tests.isEmpty()) {
            for(Staff a : tests) {
//                LOG.debug("记录:{}", myTest.toString());
                String sql = "insert into t_staff values('"+a.userid+"','"+a.staffname+"','"+a.flag+"','"+a.deptcode+"','"+a.orgcode+"','"+a.deptname+"','"+a.OAdeptname+"');\n";
                out.write(sql);
            }
        } else {
//            LOG.debug("没有结果");
        }
        out.close();
    }
}