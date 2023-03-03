package com.ds.ds.domain.auth.service.Impl;

import com.ds.ds.domain.auth.domain.entity.AuthCode;
import com.ds.ds.domain.auth.domain.repository.AuthCodeRepository;
import com.ds.ds.domain.auth.exception.InValidAuthCodeException;
import com.ds.ds.domain.auth.presentation.data.dto.CheckAuthCodeDto;
import com.ds.ds.domain.auth.service.EmailService;
import com.ds.ds.domain.auth.util.AuthConverter;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;


@Service
@PropertySource("classpath:application.yml")
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    private final AuthCodeRepository authCodeRepository;
    private final AuthConverter authConverter;
    private final TemplateEngine templateEngine;

    private final String code = createKey();

    private MimeMessage createMessage(String to)throws MessagingException {
        String setFrom = "shgurtns7236@naver.com"; //email-config 에 설정한 자신의 이메일 주소(보내는 사람)
        String title = "DS 인증 번호"; //제목

        MimeMessage message = javaMailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, to); //보낼 이메일 설정
        message.setSubject(title); //제목 설정
        message.setFrom(setFrom); //보내는 이메일
        message.setText(setContext(code), "utf-8", "html");

        return message;
    }

    private static String createKey() {
        StringBuilder key = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 6; i++) {
            key.append((rnd.nextInt(10)));
        }
        return key.toString();
    }

    @Override
    public void sendSimpleMessage(String to)throws Exception {
        MimeMessage message = createMessage(to);
        javaMailSender.send(message); // 메일 발송

        AuthCode authCode = authConverter.toEntity(to, code);
        authCodeRepository.save(authCode);
    }

    @Override
    public CheckAuthCodeDto checkAuthCode(String authCode) {
        if(!authCode.equals(code)){
            throw new InValidAuthCodeException(ErrorCode.INVALID_AUTH_CODE);
        }
        AuthCode findAuthCode = authCodeRepository.findByCode(authCode);
        return authConverter.toDto(findAuthCode.getEmail());
    }

    private String setContext(String code) {
        Context context = new Context();
        context.setVariable("code", code);
        return templateEngine.process("mail", context); //mail.html
    }

}
