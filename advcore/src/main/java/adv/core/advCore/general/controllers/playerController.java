package adv.core.advCore.general.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class playerController {

    @GetMapping
    public String  getTestControllerData(){
        return "TEST";
    }
}
