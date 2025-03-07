package com.mizanlabs.mr.service;

import com.mizanlabs.mr.repository.DevisRepository;
import com.mizanlabs.mr.entities.Devis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DevisService {





	    private final DevisRepository devisRepository;

	    @Autowired
	    public DevisService(DevisRepository devisRepository) {
	        this.devisRepository = devisRepository;
	    }

	    // Renamed from findAllContacts to match the controller
	    public List<Devis> getAllDevis() {
	        return devisRepository.findAll();
	    }

	    // Renamed from findContactById to match the controller
	    public Optional<Devis> getDevisById(Long id) {
	        return devisRepository.findById(id);
	    }

	    // Renamed from saveContact to match the controller
	    public Devis createDevis(Devis Devis) {
	        return devisRepository.save(Devis);
	    }

	    // Renamed from updateContact and changed return type to Optional<Contact> to match the controller
	    public Optional<Devis> updateDevis(Long id, Devis devisDetails) {
	        return devisRepository.findById(id).map(devis -> {
	        	devis.setDevisId(devisDetails.getDate().getTime());
	        	devis.setAmount(devisDetails.getAmount());
	        	devis.setDiscount(devisDetails.getDiscount());
	        	devis.setStatus(devisDetails.getStatus());
	        	devis.setDevisId(devisDetails.getDevisId());
	        	devis.setProject(devisDetails.getProject());



	            // Set other fields...
	            return devisRepository.save(devis);
	        });
	    }

	    // Changed to return a boolean to match the controller's expectation
	    public boolean deleteDevis(Long id) {
	        boolean exists = devisRepository.existsById(id);
	        if (!exists) {
	            return false;
	        }
	        devisRepository.deleteById(id);
	        return true;
	    }
	}


