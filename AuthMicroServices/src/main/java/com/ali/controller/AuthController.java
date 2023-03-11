package com.ali.controller;

import com.ali.dto.request.AuthLoginRequestDto;
import com.ali.dto.request.AuthRegisterRequestDto;
import com.ali.dto.response.TokenResponseDto;
import com.ali.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Optional;

import static com.ali.constant.EndPoints.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Boolean> registerAuth(@RequestBody @Valid AuthRegisterRequestDto authRegisterDto) {
        return ResponseEntity.ok(authService.save(authRegisterDto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Optional<String>> login(@RequestBody AuthLoginRequestDto authLoginRequestDto) {
        return ResponseEntity.ok(authService.login(authLoginRequestDto));
    }
}
