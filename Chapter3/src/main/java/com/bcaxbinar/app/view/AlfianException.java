package com.bcaxbinar.app.view;

import java.io.IOException;

public class AlfianException extends RuntimeException {
    MainMenu mm = new MainMenu();
    public AlfianException(String message) throws IOException {
        super(message);
        System.out.println(message);
        mm.showBody();
    }
}