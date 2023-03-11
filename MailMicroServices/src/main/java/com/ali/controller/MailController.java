package com.ali.controller;

import com.ali.dto.request.ActivatedCode;
import com.ali.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ali.constant.EndPoints.MAIL;

@RestController
@RequiredArgsConstructor
@RequestMapping(MAIL)
public class MailController {

    private final MailService mailService;

    @PostMapping
    public ResponseEntity<Boolean> activatedCode(@RequestBody ActivatedCode activatedCode) {
        return ResponseEntity.ok(mailService.activateCode(activatedCode));
    }
}
