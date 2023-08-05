package org.upsmf.grievance.service;

import org.springframework.stereotype.Service;
import org.upsmf.grievance.model.OtpRequest;
import org.upsmf.grievance.model.Ticket;

@Service
public interface OtpService {

    String generateAndSendOtp(OtpRequest otpRequest);
    boolean validateOtp(String email, String otp);
}
