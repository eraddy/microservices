package com.epam.EmployeeService.service;

import com.epam.EmployeeService.dto.EmployeeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EmployeeEvenPublisher {

    private final RabbitTemplate rabbitTemplate;
    String queue_name = "employee-event-queue";
    public EmployeeEvenPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendEmployeeEvent(EmployeeEvent employeeEvent)
    {
        rabbitTemplate.convertAndSend(queue_name,employeeEvent);
        log.info("Added to the queue");
    }
}
