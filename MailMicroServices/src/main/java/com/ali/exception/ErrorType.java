package com.ali.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {


    BAD_REQUEST_ERROR(1201,"Geçersiz Parametre Girişi Yaptınız",BAD_REQUEST),

    AUTH_PASSWORD_ERROR(1301,"Şifreler uyuşmuyor",BAD_REQUEST),

    AUTH_USERNAME_ERROR(1302,"Kullanıcı adı daha önce alınmış",BAD_REQUEST),
    AUTH_LOGIN_ERROR(1303,"Kullanıcı adı ya da şifre hatali",BAD_REQUEST),

    TOKEN_ERROR(3001,"Token Oluşturma hatası",INTERNAL_SERVER_ERROR),

    TOKEN_VALID_ERROR(3002,"Token Çözümleme Hatası",INTERNAL_SERVER_ERROR),

    INTERNAL_ERROR(3000,"Sunucuda beklenmeyen hata", INTERNAL_SERVER_ERROR),

    LOGIN_FAILED(2301,"Şifre ya da kullanıcı adı yanlış",INTERNAL_SERVER_ERROR),

    AUTH_NOT_FOUND(2302,"Auth bulunamadı",BAD_REQUEST),

    AUTH_NOT_CREATED(2303,"User Not Created",BAD_REQUEST),
    AUTH_NOT_ACTIVE(2304,"User Not Activate Profile",BAD_REQUEST);
    private int code;

    private String message;

    private HttpStatus httpStatus;

}
