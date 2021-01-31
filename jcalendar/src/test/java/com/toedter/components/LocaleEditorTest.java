package com.toedter.components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocaleEditorTest {
    private LocaleEditor localeEditor;

    @BeforeEach
    public void setUp() throws Exception {
        localeEditor = new LocaleEditor();
    }

    @Test
    public void getTags() {
        List<String> names = new ArrayList<>();
        final Locale[] locales = Calendar.getAvailableLocales();
        for (Locale local : locales) {
            names.add(local.getDisplayName());
        }
        assertArrayEquals(names.toArray(), localeEditor.getTags());
    }

    /**
     * Made up locale should not be selected
     */
    @Test
    public void setAsText1() {
        localeEditor.setAsText("I have no Idea what I'm doing");
        assertEquals(Locale.getDefault().getDisplayName(), localeEditor.getAsText());
    }

    @Test
    public void getAsText() {
        assertEquals(Locale.getDefault().getDisplayName(), localeEditor.getAsText());
    }
}