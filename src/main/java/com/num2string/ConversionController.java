package com.num2string;

// Import Spring Boot annotations
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class ConversionController { // Object model controller to route requests

    // Initialize resources to be used by the server
    NumMap numMap = new NumMap();
    Converter conversion = new Converter(numMap);

    // GET request to extract output string
    @RequestMapping(value = "/pull", method =  RequestMethod.GET)
    public String index() {
        return conversion.getOutput();
    }

    // POST request to send input string to server
    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public void Convert(@RequestParam String input){
        conversion.setInput(input);
        conversion.Convert();
    }
}
