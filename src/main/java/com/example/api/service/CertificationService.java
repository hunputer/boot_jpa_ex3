package com.example.api.service;

import com.example.api.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.h2.util.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class CertificationService {

    private final CertificationRepository certificationRepository;

    public void certifiedPhoneNumber(String phoneNumber, String cerNum){

    }
}
