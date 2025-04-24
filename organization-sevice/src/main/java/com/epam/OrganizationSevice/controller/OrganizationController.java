package com.epam.OrganizationSevice.controller;

import com.epam.OrganizationSevice.entity.Organization;
import com.epam.OrganizationSevice.repository.OrganizationRepository;
import com.epam.OrganizationSevice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/organization")
@AllArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public Organization saveOrganization(@RequestBody Organization organization)
    {

        return organizationService.save(organization);
    }

    @GetMapping
    public List<Organization> getAll()
    {
        return organizationService.getALl();
    }
}
