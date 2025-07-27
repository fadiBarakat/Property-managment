package com.mycompany.property_management.service.Impl;

import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

   @Autowired
    private PropertyRepository propertyRepository;


   @Autowired
   private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {


       PropertyEntity pe =  propertyConverter.convertDTOtoEntity(propertyDTO);
        pe=propertyRepository.save(pe);

        propertyDTO = propertyConverter.convertEntitytoDTO(pe);
        return propertyDTO;

    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity>listOfProperty =  (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> proplist  = new ArrayList<>();

        for( PropertyEntity pe : listOfProperty)
        {
           PropertyDTO propertyDTO= propertyConverter.convertEntitytoDTO(pe);
           proplist.add(propertyDTO);

        }
        return proplist;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long proertyId) {

        Optional<PropertyEntity> optEn=  propertyRepository.findById(proertyId);

        PropertyDTO propertyDTO1 = null;
        if (optEn.isPresent())
        {
            PropertyEntity pe = optEn.get(); // data from DB

            pe.setTitle(propertyDTO.getTitle());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setDescription(propertyDTO.getDescription());

            propertyRepository.save(pe);
            propertyDTO1 = propertyConverter.convertEntitytoDTO(pe);
        }

        return propertyDTO1;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
