package com.epam.notification.service.service;

import com.epam.notification.service.model.EmployeeEvent;
import com.epam.notification.service.model.OrganizationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventListner {

    @RabbitListener(queues = "employee-event-queue")
    public void handleEmployeeEvent(EmployeeEvent employeeEvent)
    {
        log.info("Event received {}",employeeEvent);
        if("CREATED".equalsIgnoreCase(employeeEvent.getAction()))
        {
            log.info("New Employee Created with name {}",employeeEvent.getEmployeeName());
        }
    }

    @RabbitListener(queues = "organization-event-queue")
    public void handleOrganizationEvent(OrganizationEvent organizationEvent)
    {
        log.info("Event Received{}",organizationEvent);
        log.info("Organization had been created with name : {}",organizationEvent.getName());
    }
}
