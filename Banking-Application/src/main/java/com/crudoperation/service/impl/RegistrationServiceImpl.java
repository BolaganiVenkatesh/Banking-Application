package com.crudoperation.service.impl;

import com.crudoperation.entity.Registration;
import com.crudoperation.repository.RegistrationRepository;
import com.crudoperation.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // to automatically create springbean for the class

public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;// we want the reference of the repository


    @Override
    public void createRegistration(Registration registration) {

        registrationRepository.save(registration);
    }

    @Override
    public List<Registration> getAllRegistrations() {

        List<Registration> registrations = registrationRepository.findAll();

        return registrations;
    }

    @Override
    public void deleteRegistration(long id) {

        registrationRepository.deleteById(id);
    }

    @Override
    public void updateRegistration(long id, Registration registration) {

        Registration reg = registrationRepository.findById(id).get();

        reg.setName(registration.getName());
        reg.setMobile(registration.getMobile());
        reg.setEmail(registration.getEmail());
        registrationRepository.save(reg);
    }
}
