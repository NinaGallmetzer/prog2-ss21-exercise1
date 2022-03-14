package exercise01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {

    @Test
    void checkNotEmpty_IsEmpty(){
        String pw = "";
        assertFalse(PasswordChecker.checkNotEmpty(pw));
    }

    @Test
    void checkNotEmpty_NotEmpty(){
        String pw = "a";
        assertTrue(PasswordChecker.checkNotEmpty(pw));
    }

    @Test
    void checkLength_TooShort() {
        String pw = "1234";
        assertFalse(PasswordChecker.checkLength(pw));
    }

    @Test
    void checkLength_TooLong() {
        String pw = "123456789012345678901234567890";
        assertFalse(PasswordChecker.checkLength(pw));
    }

    @Test
    void checkLength_LengthOK() {
        String pw = "12345678";
        assertTrue(PasswordChecker.checkLength(pw));
    }

    @Test
    void checkLowerCase_NoLowerCase() {
        String pw = "1234";
        assertFalse(PasswordChecker.checkLowerCase(pw));
    }

    @Test
    void checkLowerCase_HasLowerCase() {
        String pw = "1234a";
        assertTrue(PasswordChecker.checkLowerCase(pw));
    }

    @Test
    void checkUpperCase_NoUpperCase() {
        String pw = "1234";
        assertFalse(PasswordChecker.checkUpperCase(pw));
    }

    @Test
    void checkUpperCase_HasUpperCase() {
        String pw = "1234A";
        assertTrue(PasswordChecker.checkUpperCase(pw));
    }

    @Test
    void checkDigit_NoDigit() {
        String pw = "abcd";
        assertFalse(PasswordChecker.checkDigit(pw));
    }

    @Test
    void checkDigit_HasDigit() {
        String pw = "abcd1";
        assertTrue(PasswordChecker.checkDigit(pw));
    }

    @Test
    void checkSpecialCharacters_NoSpecialCharacter() {
        String pw = "abcd1";
        assertFalse(PasswordChecker.checkSpecialCharacters(pw));
    }

    @Test
    void checkSpecialCharacters_HasWrongSpecialCharacter() {
        String pw = "abcd1§";
        assertFalse(PasswordChecker.checkSpecialCharacters(pw));
    }

    @Test
    void checkSpecialCharacters_HasCorrectSpecialCharacter() {
        String pw = "abcd1!";
        assertTrue(PasswordChecker.checkSpecialCharacters(pw));
    }

    @Test
    void checkConsecutiveDigits_MoreThan2ConsecutiveDigits() {
        String pw = "abcd123";
        assertFalse(PasswordChecker.checkConsecutiveDigits(pw));
    }

    @Test
    void checkConsecutiveDigits_LessThan3ConsecutiveDigits() {
        String pw = "abcd12";
        assertTrue(PasswordChecker.checkConsecutiveDigits(pw));
    }

    @Test
    void checkDigitQuartett_Has4Digits() {
        String pw = "abcd1111";
        assertFalse(PasswordChecker.checkDigitQuartett(pw));
    }

    @Test
    void checkDigitQuartett_LessThan4Digits() {
        String pw = "abcd111";
        assertTrue(PasswordChecker.checkDigitQuartett(pw));
    }

}