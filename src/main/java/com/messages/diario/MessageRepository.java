package com.messages.diario;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>{

    public List<Message> findAllByOrderByIdDesc();
    public List<Message> findByName(String name);

}