package com.binio.nprabbit.api;

import java.util.Optional;

import com.binio.nprabbit.model.EmployerApi;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/employer")
@AllArgsConstructor
public class EmployerController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping(path="/create")
    public @ResponseBody
    ResponseEntity<EmployerApi> createEmployer(@RequestBody EmployerApi employerApi) {
        rabbitTemplate.convertAndSend("default-queue", employerApi.getName());
        return ResponseEntity.of(Optional.of(employerApi));
    }
}
