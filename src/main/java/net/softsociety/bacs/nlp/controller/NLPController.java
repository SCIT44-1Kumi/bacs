package net.softsociety.bacs.nlp.controller;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.nlp.service.NLPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("nlp")
@Slf4j
public class NLPController {

    @Autowired
    private NLPService service;

    @GetMapping("test")
    public Map<String, Integer> analysis(@RequestBody String text) throws Exception {

        log.info(this.getClass().getName() + ".inputForm !");

        //신조어 및 새롭게 생겨난 가수 및 그룹명은 제대로 된 분석이 불가능합니다.
        // 새로운 명사 단어들은 어떻게 데이터를 처리해야 할까?? => 데이터사전의 주기적인 업데이트

        Map<String, Integer> rMap = service.doWordAnalysis(text);

        if(rMap == null) {
            rMap = new HashMap<>();
        }


        return rMap;
    }

    @PostMapping("test1")
    public List<String> test1(@RequestBody String text) {
        log.debug("----text: {}", text);
        return service.getNounList(text);
    }

    @GetMapping("test2")
    public String test2(@PathVariable(name = "storeId") String storeId) {

        // 8888/bacs/starbucks/test2
        return storeId;
    }
}
