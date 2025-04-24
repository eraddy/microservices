package com.epam.OrganizationSevice.service;

import com.epam.OrganizationSevice.dto.OrganizationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrganizationEventPublisher {
    private final RabbitTemplate rabbitTemplate;
    String queue_name = "organization-event-queue";
    public OrganizationEventPublisher(RabbitTemplate rabbitTemplate) { this.rabbitTemplate = rabbitTemplate; }
    public void sendOrganizationEvent(OrganizationEvent organizationEvent)
    {
        rabbitTemplate.convertAndSend(queue_name,organizationEvent);
        log.info("Added to queue");
    }
}
