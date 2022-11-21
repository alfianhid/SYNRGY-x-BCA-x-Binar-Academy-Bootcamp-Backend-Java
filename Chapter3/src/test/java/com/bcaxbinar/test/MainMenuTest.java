package com.bcaxbinar.test;

import com.bcaxbinar.app.view.MainMenu;
import com.bcaxbinar.app.view.Menu;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainMenuTest {
    @Mock
    File file = new File("data/data_sekolah.csv");

    @InjectMocks
    MainMenu mainMenu = new MainMenu();

    String filepath = "wrongpath/data_sekolah.csv";

    public MainMenuTest() throws IOException {
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkFile_Success() {
        Boolean result = file.exists();
        assertEquals(true, result);
    }

    @Test
    void checkFile_Failed_FileNotFound() {
        assertThrows(IOException.class, () -> mainMenu.checkFile(filepath));
    }


}
