package com.toedter.components;

import com.toedter.pageobject.components.JTitlePanelPageObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.awt.BorderLayout;

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
        jTitlePanel = new JTitlePanel();
        frame.add(jTitlePanel);
        frame.setSize(400, 400);
        frame.setVisible(true);
        pageObject = new JTitlePanelPageObject("AJFrame");
        System.out.println("JFrame should be visible");
    }

    @Test
    public void emptyTitle() {
        assertEquals("", pageObject.getTitleOfTitlePanel());
    }
}
