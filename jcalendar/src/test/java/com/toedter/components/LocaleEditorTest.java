package com.toedter.components;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LocaleEditorTest {
    private LocaleEditor localeEditor;

    @Before
    public void setUp() throws Exception {
        localeEditor = new LocaleEditor();
    }

    @Test
    public void getTags() {
        List<String> names = new ArrayList<>();
        List<Locale> locales = Arrays.asList(Calendar.getAvailableLocales());
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