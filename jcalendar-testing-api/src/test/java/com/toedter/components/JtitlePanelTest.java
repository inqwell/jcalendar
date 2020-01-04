package com.toedter.components;

import com.toedter.pageobject.components.JTitlePanelPageObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JtitlePanelTest {
    private JTitlePanel jTitlePanel;
    private JFrame frame;
    private JTitlePanelPageObject pageObject;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("creating JFrame");
        frame = new JFrame("AJFrame");
        frame.setLayout(new BorderLayout());
    }
    
    @AfterEach
    public void tearDown(){
        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }
    
    public void secondSetup(){
        frame.add(jTitlePanel);
        frame.setSize(400, 400);
        frame.setVisible(true);
        pageObject = new JTitlePanelPageObject("AJFrame");
        System.out.println("JFrame should be visible");
    }

    @Test
    public void emptyTitle() {
        jTitlePanel = new JTitlePanel();
        secondSetup();
        assertEquals("", pageObject.getTitleOfTitlePanel());
    }
    
    @Test
    public void customTitle() {
        jTitlePanel = new JTitlePanel("custom title",null,null,null);
        secondSetup();
        assertEquals("custom title", pageObject.getTitleOfTitlePanel());
    }
}
