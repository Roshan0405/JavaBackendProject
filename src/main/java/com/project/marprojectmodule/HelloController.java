package com.project.marprojectmodule;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("id") String id) {
        return "My Name is " + id;
    }
}
