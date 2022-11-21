package com.bcaxbinar.app.view;

import java.io.IOException;

public interface Menu {
    void showHeader();
    void checkFile(String filepath) throws IOException;
    void showBody();
    void backToMain();
}