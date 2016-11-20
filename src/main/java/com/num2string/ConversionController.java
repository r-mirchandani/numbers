package com.num2string;

// Import Spring Boot annotations
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.stereotype.Controller;

@CrossOrigin
@Controller
public class ConversionController { // Object model controller to route requests

    // Initialize resources to be used by the server
    NumMap numMap = new NumMap();
    Converter conversion = new Converter(numMap);

    // GET request handler to serve index.html
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index.html";
    }

    // GET request to extract output string
    @RequestMapping(value = "/pull", method = RequestMethod.GET)
    public @ResponseBody String Pull(){
        return conversion.getOutput();
    }

    // POST request to send input string to server
    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public @ResponseBody void Convert(@RequestParam String input){
        conversion.setInput(input);
        conversion.Convert();
    }
}
