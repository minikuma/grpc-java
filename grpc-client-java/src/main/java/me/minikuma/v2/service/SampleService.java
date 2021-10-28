package me.minikuma.v2.service;

import lombok.RequiredArgsConstructor;
import me.minikuma.v2.repository.SampleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository sampleRepository;

    public String getString() {
        return sampleRepository.getString();
    }
}
