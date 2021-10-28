package me.minikuma.v2.adaptor.in.controller;

import lombok.RequiredArgsConstructor;
import me.minikuma.v2.service.SampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping
    public String getString() {
        return sampleService.getString();
    }
}
