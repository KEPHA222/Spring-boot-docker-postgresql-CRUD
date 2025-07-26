package com.amigoscode;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("/{id}")
    public SoftwareEngineer getEngineerById(
            @PathVariable Integer id
    ) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public SoftwareEngineer addNewSoftwareEngineer(
            @RequestBody SoftwareEngineer softwareEngineer
    ) {
        return softwareEngineerService.createSoftwareEngineer(softwareEngineer);
    }

    @PutMapping("/{id}")
    public SoftwareEngineer updateEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        return softwareEngineerService.updateSoftwareEngineer(id, softwareEngineer);
    }

    @PatchMapping("/{id}")
    public SoftwareEngineer patchEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer partialUpdate) {
        return softwareEngineerService.patchSoftwareEngineer(id, partialUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteEngineer(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineer(id);
    }

}
