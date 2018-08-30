package com.messages.diario;



import javax.persistence.criteria.Order;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GreetingController {

  

    private MessageRepository messageRepo; 

    public GreetingController(MessageRepository repo){
        this.messageRepo = repo;
    }

    @GetMapping("/messages")
    public String greetingForm(Model model) {
        model.addAttribute("message", new Message());
        model.addAttribute("messages", this.messageRepo.findAllByOrderByIdDesc());
        return "messages";
    }

    @PostMapping("/messages")
    public String greetingSubmit(@ModelAttribute Message message) {
        this.messageRepo.save(message);
        return "redirect:/messages";
    }

}