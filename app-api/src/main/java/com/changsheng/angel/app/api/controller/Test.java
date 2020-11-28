package com.changsheng.angel.app.api.controller;

import com.changsheng.angel.dubhe.parent.controller.BaseController;
import com.changsheng.angel.dubhe.parent.controller.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class Test extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    /**
     * 查询所有的标签
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public RestResult<Void> test() {
        LOGGER.info("success");
        return success();
    }

}
