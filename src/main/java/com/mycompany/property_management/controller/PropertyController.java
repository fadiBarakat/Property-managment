package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello Word";
    }


    @Autowired
    private PropertyService propertyService;


    @PostMapping("/save")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO)
    {
        propertyDTO= propertyService.saveProperty(propertyDTO);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }


    @GetMapping("get")
    public ResponseEntity<List<PropertyDTO>> getAllProperties()
    {
        List<PropertyDTO> propertyList =  propertyService.getAllProperties();

        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList,HttpStatus.OK);

    return responseEntity;
    }

    @PutMapping("update/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO , @PathVariable Long propertyId)
    {
        propertyDTO = propertyService.updateProperty(propertyDTO,propertyId );

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("update-de/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDesc(@RequestBody PropertyDTO propertyDTO , @PathVariable Long propertyId)
    {
        propertyDTO = propertyService.updateProperty(propertyDTO,propertyId );

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("delete/{id}")
    public void deleteProperty(@PathVariable Long id)
    {
        propertyService.deleteProperty(id);
    }




}
