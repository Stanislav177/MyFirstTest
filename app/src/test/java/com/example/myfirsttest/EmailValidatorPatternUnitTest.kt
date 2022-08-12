package com.example.myfirsttest

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class EmailValidatorPatternUnitTest {

    lateinit var validator: EmailValidatorPattern

    @Before
    fun setup() {
        validator = EmailValidatorImplPattern()
    }

    @Test
    fun `Проверка на корректный емайл`() {
        assertTrue(validator.isValidEmail("i.ivanov@mail.ru"))
    }

    @Test
    fun `Проверка на некорректный емайл`() {
        assertFalse(validator.isValidEmail("i.ivanov"))
    }

    @Test
    fun `Проверка на NotNULL`() {
        assertNotNull(validator.isNullText("i.ivanov"))
    }

    @Test
    fun `Проверка на NULL`() {
        assertNull(validator.isNullText(null))
    }
}