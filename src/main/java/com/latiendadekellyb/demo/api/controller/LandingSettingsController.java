package com.latiendadekellyb.demo.api.controller;

import com.latiendadekellyb.demo.api.dto.LandingSettingsRequest;
import com.latiendadekellyb.demo.api.dto.LandingSettingsResponse;
import com.latiendadekellyb.demo.service.LandingSettingsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/landing")
public class LandingSettingsController {

    private final LandingSettingsService landingSettingsService;

    public LandingSettingsController(LandingSettingsService landingSettingsService) {
        this.landingSettingsService = landingSettingsService;
    }

    @GetMapping
    public LandingSettingsResponse getMain() {
        return landingSettingsService.getMain();
    }

    @PutMapping
    public LandingSettingsResponse updateMain(@Valid @RequestBody LandingSettingsRequest request) {
        return landingSettingsService.updateMain(request);
    }
}
