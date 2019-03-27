package com.xml;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class RegularUtilTest {
    private List<String> listOfPhoneNumbers;
    private List<String> listOfEmails;
    private List<String> listOfDates;
    private List<String> listOfIps;

    @Before
    public void init() {
        listOfPhoneNumbers = new ArrayList<String>() {{
            add("+380671234567");
            add("+38(067)1234567");
            add("+38(097)123-45-67");
            add("+38)098)l2-3-45-67");
            add("+380o1234567");
        }};
        listOfEmails = new ArrayList<String>() {{
            add("test@gmail.com");
            add("anothertest@gmail.com");
            add("onemoretest@gmail.com");
            add("wrongtest@@.com");
            add("complitliwrong@.com.com");
        }};
        listOfDates = new ArrayList<String>() {{
            add("11.10.1979");
            add("01.01.2020");
            add("32.01.2019");
            add("30.13.2019");
            add("29.02.2019");
        }};
        listOfIps = new ArrayList<String>() {{
            add("192.168.0.1");
            add("192.192.0.0");
            add("192.192.0");
            add("192..2.0.0");
        }};
    }

    @Test
    public void testPhoneNumber() {
        assertTrue(RegularUtil.isPhoneNumberValid(listOfPhoneNumbers.get(0)));
        assertTrue(RegularUtil.isPhoneNumberValid(listOfPhoneNumbers.get(1)));
        assertTrue(RegularUtil.isPhoneNumberValid(listOfPhoneNumbers.get(2)));
        assertFalse(RegularUtil.isPhoneNumberValid(listOfPhoneNumbers.get(3)));
        assertFalse(RegularUtil.isPhoneNumberValid(listOfPhoneNumbers.get(4)));
    }

    @Test
    public void testEmail() {
        assertTrue(RegularUtil.isEmailValid(listOfEmails.get(0)));
        assertTrue(RegularUtil.isEmailValid(listOfEmails.get(1)));
        assertTrue(RegularUtil.isEmailValid(listOfEmails.get(2)));
        assertFalse(RegularUtil.isEmailValid(listOfEmails.get(3)));
        assertFalse(RegularUtil.isEmailValid(listOfEmails.get(4)));

    }

    @Test
    public void testDate() {
        assertTrue(RegularUtil.isDateValid(listOfDates.get(0)));
        assertTrue(RegularUtil.isDateValid(listOfDates.get(1)));
        assertFalse(RegularUtil.isDateValid(listOfDates.get(2)));
        assertFalse(RegularUtil.isDateValid(listOfDates.get(3)));
        assertFalse(RegularUtil.isDateValid(listOfDates.get(4)));
    }

    @Test
    public void testIp() {
        assertTrue(RegularUtil.isIpValid(listOfIps.get(0)));
        assertTrue(RegularUtil.isIpValid(listOfIps.get(1)));
        assertFalse(RegularUtil.isIpValid(listOfIps.get(2)));
        assertFalse(RegularUtil.isIpValid(listOfIps.get(3)));
    }
}
