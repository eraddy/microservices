package com.epam.OrganizationSevice.service;

import com.epam.OrganizationSevice.dto.OrganizationEvent;
import com.epam.OrganizationSevice.entity.Organization;
import com.epam.OrganizationSevice.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationEventPublisher organizationEventPublisher;

    public Organization save(Organization organization)
    {
        OrganizationEvent organizationEvent = new OrganizationEvent(
                organization.getName(),
                organization.getWorkForce(),
                organization.getDescription()
        );
        organizationEventPublisher.sendOrganizationEvent(organizationEvent);
        return organizationRepository.save(organization);
    }

    public List<Organization> getALl()
    {
        return organizationRepository.findAll();
    }
}
