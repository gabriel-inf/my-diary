package com.messages.diario;



import javax.persistence.criteria.Order;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class GreetingController {

    private MessageRepository messageRepo; 

    public GreetingController(MessageRepository repo){
        this.messageRepo = repo;
    }

    @GetMapping
    public String greetingForm(Model model) {
        model.addAttribute("message", new Message());
        model.addAttribute("messages", this.messageRepo.findAllByOrderByIdDesc());
        return "messages";
    }

    @PostMapping
    public String greetingSubmit(@ModelAttribute Message message) {
        this.messageRepo.save(message);
        return "redirect:/messages";
    }

    @GetMapping("/listmessages")
    public Iterable<Message> listMessages(){
          return messageRepo.findAll();
    }


}