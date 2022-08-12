package com.example.myfirsttest

import org.junit.Assert.*
import org.junit.Test

class EmailValidatorUnitTest {

    @Test
    fun `Проверка на корректный емайл`() {
        assertTrue(EmailValidator.isValidEmail("i.ivanov@mail.ru"))
    }

    @Test
    fun `Проверка на некорректный емайл`() {
        assertFalse(EmailValidator.isValidEmail("i.ivanov"))
    }

    @Test
    fun `Проверка на NotNULL`() {
        assertNotNull(EmailValidator.isNullText("i.ivanov"))
    }

    @Test
    fun `Проверка на NULL`() {
        assertNull(EmailValidator.isNullText(null))
    }
}