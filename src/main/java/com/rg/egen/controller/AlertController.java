package com.rg.egen.controller;

import com.rg.egen.Application;
import com.rg.egen.entity.Alert;
import com.rg.egen.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    private final AlertService service;

    @Autowired
    public AlertController(AlertService alertService) {
        this.service = alertService;
    }

    @GetMapping(path = "/vin/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> findAlerts(@PathVariable String vin) {
        return service.findAlertsByVin(vin);
    }

    @GetMapping(path = "/priority/{priority_type}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> findAlertsByPriority(@PathVariable String priority_type) {
        return service.findAlertsByPriority(priority_type);
    }
}
