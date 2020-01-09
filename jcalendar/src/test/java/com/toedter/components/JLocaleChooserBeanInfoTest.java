package com.toedter.components;

import org.junit.jupiter.api.Test;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

class JLocaleChooserBeanInfoTest {
    @Test
    void name() {
        try {
            BeanInfo localeChooserBeanInfo = Introspector.getBeanInfo(JLocaleChooser.class);
            BeanDescriptor beanDescriptor = localeChooserBeanInfo.getBeanDescriptor();
            assertNotNull(beanDescriptor);
            assertEquals(JLocaleChooser.class.getSimpleName(), beanDescriptor.getName());
            assertEquals(JLocaleChooser.class, beanDescriptor.getBeanClass());
            assertNull(localeChooserBeanInfo.getAdditionalBeanInfo());
            PropertyDescriptor[] propertyDescriptors = localeChooserBeanInfo.getPropertyDescriptors();
            // System.out.println(Arrays.toString(propertyDescriptors));
            assertNotNull(propertyDescriptors);
            assertEquals(78, propertyDescriptors.length);
        } catch (IntrospectionException e) {
            fail("could not create bean info for JSpinField", e);
        }
    }
}