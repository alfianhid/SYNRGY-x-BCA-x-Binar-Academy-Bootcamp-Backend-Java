package com.bcaxbinar.app.service.filehandling;

import java.io.IOException;

public interface FileHandler {
    void readFile(String filepath);
    void generateFile(String filepath, String number) throws IOException;
}