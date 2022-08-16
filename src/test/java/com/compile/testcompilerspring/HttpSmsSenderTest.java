package com.compile.testcompilerspring;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.*;

class HttpSmsSenderTest {

    @Test
    void testedSMS_sender() {
        String smsText = new String("Ваш пароль, код подтверждения: 251925");

        HttpSmsSender kvsspb = new HttpSmsSender("kvsspbfdasfsdf", "15616115656116116161");
        kvsspb.send("79867099218", smsText);
        System.out.println(kvsspb.getLastError());
    }


}