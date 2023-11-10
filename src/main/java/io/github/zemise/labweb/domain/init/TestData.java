package io.github.zemise.labweb.domain.init;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import io.github.zemise.labweb.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/10
 * @since 1.0
 */

@Slf4j
public class TestData {
    public static void main(String[] args) {
        new TestData().simpleRead();
    }

    public void simpleRead() {
        // 写法2：
        // 匿名内部类 不用额外写一个DemoDataListener
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("data/initData.xlsx");
        //String fileName = FileUtil.getPath() + "data" + File.separator + "initData.xlsx";
        //String fileName = "/Volumes/MySSD/001_AllCode/Java/SpringBoot/LabWeb/target/classes/data/initData.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        //EasyExcel.read(fileName, DemoProtein.class, new ReadListener<DemoProtein>() {
        EasyExcel.read(resourceAsStream, DemoProtein.class, new ReadListener<DemoProtein>() {
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 100;
            /**
             *临时存储
             */
            private List<DemoProtein> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(DemoProtein data, AnalysisContext context) {
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    saveData();
                    // 存储完成清理 list
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData();
            }

            /**
             * 加上存储数据库
             */
            private void saveData() {
                log.info("{}条数据，开始存储数据库！", cachedDataList.size());
                log.info("存储数据库成功！");
            }
        }).sheet().doRead();
    }
}
