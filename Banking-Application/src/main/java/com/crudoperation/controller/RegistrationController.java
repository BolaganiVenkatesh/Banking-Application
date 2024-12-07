package com.crudoperation.controller;

import com.crudoperation.entity.Registration;
import com.crudoperation.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud")

public class RegistrationController {

    @Autowired // it will perform dependency injection // registration service is an interface it does not provide object
    // registration service interface implementing the registration service impl // this auto wired injects impl object into controller class
    private RegistrationService registrationService;  


    @PostMapping
    public ResponseEntity<String> createRegistration(@RequestBody Registration registration){

        registrationService.createRegistration(registration);

        return new ResponseEntity<>("Registration is done",HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity< List<Registration>> getAllRegistration(){
        List<Registration> allRegistrations = registrationService.getAllRegistrations();
        return new ResponseEntity<>(allRegistrations,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> deleteRegistration(@PathVariable long id){

        registrationService.deleteRegistration(id);

        return new ResponseEntity<>("Record is deleted",HttpStatus.CREATED);
    }

    @PutMapping("/{id}")

    public ResponseEntity<String> updateRegistration(@RequestBody Registration registration,@PathVariable long id){

        registrationService.updateRegistration(id,registration);
        return new ResponseEntity<>("Record is updated",HttpStatus.CREATED);
    }



}
