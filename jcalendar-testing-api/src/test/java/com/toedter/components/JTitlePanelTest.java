package com.toedter.components;

import com.toedter.pageobject.components.JTitlePanelPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JTitlePanelTest {
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
    
//    @Test
//    public void customIcon() {
//        java.net.URL imageURL = JtitlePanelTest.class.getResource("images/myImage.gif");
//        if (imageURL != null) {
//            ImageIcon icon = new ImageIcon(imageURL);
//        }
//        jTitlePanel = new JTitlePanel(null, null, null, null);
//        secondSetup();
//        assertEquals("custom title", pageObject.getTitleOfTitlePanel());
//    }
    
    @Test
    public void customComponent() {
        jTitlePanel = new JTitlePanel(null, null, new JButton("I'm a Button"), null);
        secondSetup();
        assertEquals("", pageObject.getTitleOfTitlePanel());
    }
}
