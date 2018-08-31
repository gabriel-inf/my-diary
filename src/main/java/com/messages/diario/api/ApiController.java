package com.messages.diario.api;


import com.messages.diario.Message;
import com.messages.diario.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
;


@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MessageRepository messageRepo; 

    @GetMapping("/list")
    public List<Message> listMessages(){
        return messageRepo.findAllByOrderByIdDesc();
    }

    @GetMapping("/listByName")
    public List<Message> listMessagesByName(@RequestParam String name) {
        return messageRepo.findByName(name);
    }
    


}