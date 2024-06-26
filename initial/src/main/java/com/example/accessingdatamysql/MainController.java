package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// Marks this class as a controller. RequestMapping indicates URLs start with [app path]/demo
@Controller
@RequestMapping(path="/demo")
public class MainController {
    // Autowired marks userRepository as a bean which is automatically generated by Spring to handle the data
    @Autowired
    private UserRepository userRepository;

    /* This maps only to POST requests.
     * ResponseBody marks that the returned String is the response, not a view name.
     * RequestParam marks that the parameter comes from a GET or POST request. */
    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    /** Returns a JSON or XML with the users */
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
