package com.ds.ds.domain.auth.service.Impl;

import com.ds.ds.domain.auth.domain.entity.AuthCode;
import com.ds.ds.domain.auth.domain.entity.Authentication;
import com.ds.ds.domain.auth.domain.repository.AuthCodeRepository;
import com.ds.ds.domain.auth.domain.repository.AuthenticationRepository;
import com.ds.ds.domain.auth.exception.DuplicateEmailException;
import com.ds.ds.domain.auth.exception.InValidAuthCodeException;
import com.ds.ds.domain.auth.exception.NotFoundEmailException;
import com.ds.ds.domain.auth.presentation.data.dto.CheckAuthCodeDto;
import com.ds.ds.domain.auth.presentation.data.dto.CreateMessageDto;
import com.ds.ds.domain.auth.presentation.data.dto.SendAuthCodeDto;
import com.ds.ds.domain.auth.service.EmailService;
import com.ds.ds.domain.auth.util.AuthConverter;
import com.ds.ds.domain.user.domain.repository.UserRepository;
import com.ds.ds.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    private final AuthenticationRepository authenticationRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public SendAuthCodeDto sendSimpleMessage(String to)throws Exception {
        if (userRepository.existsByEmail(to)) {
            throw new DuplicateEmailException(ErrorCode.DUPLICATE_EMAIL);
        }

        CreateMessageDto message = createMessage(to);
        javaMailSender.send(message.getMessage()); // 메일 발송

        AuthCode authCode = authConverter.toEntity(to, message.getCode());
        authCodeRepository.save(authCode);

        return authConverter.toDto(authCode);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public SendAuthCodeDto sendSimpleMessagePasswordVersion(String to)throws Exception {
        CreateMessageDto message = createMessage(to);
        javaMailSender.send(message.getMessage()); // 메일 발송

        AuthCode authCode = authConverter.toEntity(to, message.getCode());
        authCodeRepository.save(authCode);

        return authConverter.toDto(authCode);
    }

    @Override
    public CheckAuthCodeDto checkAuthCode(String authCode, String email) {
        AuthCode authCodeEntity = authCodeRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundEmailException(ErrorCode.NOT_FOUND_EMAIL));

        if(!authCode.equals(authCodeEntity.getCode())) {
            throw new InValidAuthCodeException(ErrorCode.INVALID_AUTH_CODE);
        }

        Authentication authentication = authConverter.toEntity(email);
        authenticationRepository.save(authentication);

        return authConverter.toDto(email);
    }

    private String setContext(String code) {
        Context context = new Context();
        context.setVariable("code", code);
        return templateEngine.process("Mail", context); //Mail.html
    }

    private CreateMessageDto createMessage(String to)throws MessagingException {
        String code = createKey();

        String setFrom = "shgurtns7236@naver.com"; //email-config 에 설정한 자신의 이메일 주소(보내는 사람)
        String title = "DS 인증 번호"; //제목

        MimeMessage message = javaMailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, to); //보낼 이메일 설정
        message.setSubject(title); //제목 설정
        message.setFrom(setFrom); //보내는 이메일
        message.setText(setContext(code), "utf-8", "html");

        return authConverter.toDto(message, code);
    }

    private static String createKey() {
        StringBuilder key = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 4; i++) {
            key.append((rnd.nextInt(10)));
        }
        return key.toString();
    }

}
