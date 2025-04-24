package com.epam.OrganizationSevice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationEvent {
    String name;
    int workForce;
    String description;
}
