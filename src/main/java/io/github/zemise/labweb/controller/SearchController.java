package io.github.zemise.labweb.controller;

import io.github.zemise.labweb.domain.Protein;
import io.github.zemise.labweb.domain.repository.DaoProtein;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public class SearchController {
    private final DaoProtein daoProtein;

    @Autowired
    public SearchController(DaoProtein daoProtein) {
        this.daoProtein = daoProtein;
    }

    @GetMapping("/search")
    public String showSearchPage(@RequestParam(name = "q", required = false) String query, Model model) {
        model.addAttribute("title", "搜索页");
        model.addAttribute("name", "Hello Thymeleaf! from SearchController");

        if (query != null && !query.isEmpty()) {
            // Perform a search (simulated here)

            log.info("点击查询" + query);
            List<String> results = performActualSearch(query);
            model.addAttribute("results", results);
        }

        model.addAttribute("query", query);
        return "search";
    }


    private List<String> performActualSearch(String query) {

        Protein protein = daoProtein.findByName(query);
        List<String> results = new ArrayList<>();
        if (null == protein) {
            results.add("未找到相关数据");
        } else {
            results.add(protein.getName());
            results.add(protein.getMoleculeWeight() + "Kd");
            results.add(protein.getWebUrl());
        }
        return results;
    }
}
