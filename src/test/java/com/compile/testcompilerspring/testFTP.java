package com.compile.testcompilerspring;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class testFTP {

    @Test
    void testFTP1(){
        FTPClient f = new FTPClient();
        try {
            f.connect("173123123213123");
            f.login("dasdas", "adsdasdasdasd");

            FTPFile[] files = f.listFiles("/");
            System.out.println(files.length);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
