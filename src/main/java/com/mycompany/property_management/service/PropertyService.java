package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {



    public PropertyDTO saveProperty(PropertyDTO propertyDTO);

    public List<PropertyDTO> getAllProperties();

    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long proertyId);

    public void deleteProperty(Long id);
}
