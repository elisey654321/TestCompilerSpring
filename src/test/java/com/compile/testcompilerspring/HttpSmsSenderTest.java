package com.compile.testcompilerspring;

import com.compile.testcompilerspring.сonfigurations.HttpSmsSender;
import org.junit.jupiter.api.Test;

class HttpSmsSenderTest {

    @Test
    void testedSMS_sender() {
        String smsText = new String("Ваш пароль, код подтверждения: 251925");

        HttpSmsSender kvsspb = new HttpSmsSender("kvsspbfdasfsdf", "15616115656116116161");
        kvsspb.send("79867099218", smsText);
        System.out.println(kvsspb.getLastError());
    }


}