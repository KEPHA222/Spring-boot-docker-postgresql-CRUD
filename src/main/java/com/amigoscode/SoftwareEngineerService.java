package com.amigoscode;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService  {
    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    // Get all software engineers
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    // Get one software engineer by ID
    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    // Create new software engineer
    public SoftwareEngineer createSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        return softwareEngineerRepository.save(softwareEngineer);
    }

    // Update existing engineer (FULL UPDATE) software engineer
    public SoftwareEngineer updateSoftwareEngineer(Integer id, SoftwareEngineer updatedEngineer) {
        SoftwareEngineer existingEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Software Engineer with id " + id + " not found"));

        // Update only the fields we want to allow updating
        existingEngineer.setName(updatedEngineer.getName());
        existingEngineer.setTechStack(updatedEngineer.getTechStack());

        return softwareEngineerRepository.save(existingEngineer);
    }

    // Partial update (PATCH) software engineer
    public SoftwareEngineer patchSoftwareEngineer(Integer id, SoftwareEngineer partialUpdate) {
        SoftwareEngineer existingEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Engineer with id " + id + " not found"));

        // Only update non-null fields
        if (partialUpdate.getName() != null) {
            existingEngineer.setName(partialUpdate.getName());
        }
        if (partialUpdate.getTechStack() != null) {
            existingEngineer.setTechStack(partialUpdate.getTechStack());
        }

        return softwareEngineerRepository.save(existingEngineer);
    }

    // Delete software engineer
    public void deleteSoftwareEngineer(Integer id) {
        if (!softwareEngineerRepository.existsById(id)) {
            throw new IllegalStateException("Engineer with id " + id + " not found");
        }
        softwareEngineerRepository.deleteById(id);
    }

}
