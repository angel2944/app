package com.changsheng.angel.app.api.controller;

import com.changsheng.angel.dubhe.parent.controller.BaseController;
import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@Data
public class Test extends BaseController {


    public static void main(String[] args) {
        System.out.println("11");
    }
}
