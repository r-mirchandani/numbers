package com.num2string;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class ConversionController {

    NumMap numMap = new NumMap();
    Converter conversion = new Converter(numMap);

    @RequestMapping(value = "/pull", method =  RequestMethod.GET)
    public String index() {
        return conversion.getOutput();
    }

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public void Convert(@RequestParam String input){
        conversion.setInput(input);
        conversion.Convert();
    }
}
