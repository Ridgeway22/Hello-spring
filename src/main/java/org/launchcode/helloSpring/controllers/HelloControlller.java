package org.launchcode.helloSpring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControlller {

// HANDLES REQEUST AT PATH /hELLO
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello (){
//        return "Hello, String";
//    }
//    @GetMapping("goodbye")
//    @ResponseBody
//    public String goodbye (){
//        return "Goodbye, String";
//    }
//    @RequestMapping(value="hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
//
//    public String hellogoodbye() {
//        return"hello and goodbye";
//    }
//    @GetMapping("hello")
//    @ResponseBody
//
//    public String helloWithQueryParam (@RequestParam String name)
//    {
//        return "hello, " + name +"!";
//    }
//@GetMapping("hello")
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value ="hello")
@ResponseBody
public String helloWithQueryParam (@RequestParam String name, String language) {
    if (language.equals("French")) {
        return "<html>" +
                "<body>" +
                "Benjour " + name+
        "</body>" +
        "</html>" ;
    } else if (language.equals("Mandarin")){
        return "Ni hao, " + name;
      }else if(language.equals("German")) {
        return "Hallo, " + name;
    }else if(language.equals("Spanish")) {
        return "Hola, " + name;
    }
    return "Hello"+ name;
}
   // @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value ="hello")
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithQueryParam2 (@PathVariable String name){
        return "Hellosss, " + name;
    }

    @GetMapping("form")
    @ResponseBody
    public String helloform (){
        return "<html>" +
                "<body>" +
                "<form action='hello' method = 'post'>" +
                "<input type='text' name='name'>" +
               " <select id='language' name='language'>"+
                            " <option value='French'>French"+
                            " <option value='Spanish'>Spanish"+
                             " <option value='Mandarin'>Mandarin"+
                            " <option value='English'>English"+
                            " <option value='German'>German"+
                            "</select>"+
                "<input type='submit' value='Greet me'>"+
                "</form>" +
                "</body>"+
                "</html>";
    }
}
