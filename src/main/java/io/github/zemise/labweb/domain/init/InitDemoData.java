package io.github.zemise.labweb.domain.init;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import io.github.zemise.labweb.domain.Protein;
import io.github.zemise.labweb.domain.repository.DaoProtein;
import io.github.zemise.labweb.utils.FileUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/9
 * @since 1.0
 */

@Controller
@Slf4j
public class InitDemoData {
    private final DaoProtein daoProtein;

    @Autowired
    public InitDemoData(DaoProtein daoProtein) {
        this.daoProtein = daoProtein;
    }

    @PostConstruct
    public void init() {
        //String fileName = FileUtil.getPath() + "data" + File.separator + "initData.xlsx";
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("data/initData.xlsx");
        List<Protein> proteins = new ArrayList<>();

        // 这里 只要，然后读取第一个sheet 同步读取会自动finish
        EasyExcel.read(resourceAsStream, DemoProtein.class, new PageReadListener<DemoProtein>(datalist -> {
            log.info("{}条数据，开始初始化测试数据库！", datalist.size());
            for (DemoProtein demoProtein : datalist) {
                Protein protein = new Protein();
                protein.setName(demoProtein.getName());
                protein.setMoleculeWeight(demoProtein.getMoleculeWeight());
                protein.setWebUrl(demoProtein.getWebUrl());

                proteins.add(protein);
            }
        })).sheet(0).doRead();

        daoProtein.saveAll(proteins);
        log.info("初始化数据库成功！");
    }
}
