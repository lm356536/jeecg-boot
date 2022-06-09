package org.jeecg.modules.demo.test.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "Hello World")
@RestController
@RequestMapping("/test/helloWorld")
public class HelloWorldController {
    /**
     * hello world
     */
    @GetMapping(value = "/hello")
    public Result<String> hello(){
        Result<String> result = new Result<String>();
        result.setResult("hello Liming");
        result.setSuccess(true);
        return result;
    }
}
