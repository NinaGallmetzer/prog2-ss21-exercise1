package exercise01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPasswordTest {

    @Test
    void checkNotEmpty_IsEmpty(){
        CheckPassword pwChecker = new CheckPassword();
        String pw = "";
        assertFalse(pwChecker.checkNotEmpty(pw));
    }

    @Test
    void checkNotEmpty_NotEmpty(){
        CheckPassword pwChecker = new CheckPassword();
        String pw = "a";
        assertTrue(pwChecker.checkNotEmpty(pw));
    }

    @Test
    void checkNotNull_IsNull(){
        CheckPassword pwChecker = new CheckPassword();
        String pw = null;
        assertFalse(pwChecker.checkNotNull(pw));
    }

    @Test
    void checkNotNull_NotNull(){
        CheckPassword pwChecker = new CheckPassword();
        String pw = "a";
        assertTrue(pwChecker.checkNotNull(pw));
    }

    @Test
    void checkLength_TooShort() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "1234";
        assertFalse(pwChecker.checkLength(pw));
    }

    @Test
    void checkLength_TooLong() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "123456789012345678901234567890";
        assertFalse(pwChecker.checkLength(pw));
    }

    @Test
    void checkLength_LengthOK() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "12345678";
        assertTrue(pwChecker.checkLength(pw));
    }

    @Test
    void checkLowerCase_NoLowerCase() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "1234";
        assertFalse(pwChecker.checkLowerCase(pw));
    }

    @Test
    void checkLowerCase_HasLowerCase() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "1234a";
        assertTrue(pwChecker.checkLowerCase(pw));
    }

    @Test
    void checkUpperCase_NoUpperCase() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "1234";
        assertFalse(pwChecker.checkUpperCase(pw));
    }

    @Test
    void checkUpperCase_HasUpperCase() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "1234A";
        assertTrue(pwChecker.checkUpperCase(pw));
    }

    @Test
    void checkNumber_NoNumber() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "abcd";
        assertFalse(pwChecker.checkNumber(pw));
    }

    @Test
    void checkNumber_HasNumber() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "abcd1";
        assertTrue(pwChecker.checkNumber(pw));
    }

    @Test
    void checkSpecialCharacters_NoSpecialCharacter() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "abcd1";
        assertFalse(pwChecker.checkSpecialCharacters(pw));
    }

    @Test
    void checkSpecialCharacters_HasWrongSpecialCharacter() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "abcd1§";
        assertFalse(pwChecker.checkSpecialCharacters(pw));
    }

    @Test
    void checkSpecialCharacters_HasCorrectSpecialCharacter() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "abcd1!";
        assertTrue(pwChecker.checkSpecialCharacters(pw));
    }

    @Test
    void checkConsecutiveNumber_MoreThan2ConsecutiveNumbers() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "abcd123";
        assertFalse(pwChecker.checkConsecutiveNumber(pw));
    }

    @Test
    void checkConsecutiveNumber_LessThan3ConsecutiveNumbers() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "abcd12";
        assertTrue(pwChecker.checkConsecutiveNumber(pw));
    }

    @Test
    void checkSpecialCharacters_LessThan3ConsecutiveNumbers1() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "abcd1111";
        assertFalse(pwChecker.checkNumberQuartett(pw));
    }

    @Test
    void checkSpecialCharacters_LessThan3ConsecutiveNumbers2() {
        CheckPassword pwChecker = new CheckPassword();
        String pw = "abcd111";
        assertTrue(pwChecker.checkNumberQuartett(pw));
    }

}