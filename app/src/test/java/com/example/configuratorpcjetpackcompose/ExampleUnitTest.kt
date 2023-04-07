package com.example.configuratorpcjetpackcompose

import com.example.configuratorpcjetpackcompose.model.Configuration
import com.example.configuratorpcjetpackcompose.model.User
import com.example.configuratorpcjetpackcompose.services.ValidationService
import com.example.configuratorpcjetpackcompose.utils.ConfigurationError
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private var validation: ValidationService = ValidationService
    private var mockConfiguration: Configuration? = Mockito.mock(Configuration::class.java)
    private var configuration: Configuration? = null

    @Before
    fun setUp() {
        var user: User = User(
            name = "User1",
            avatarPath = "",
            email = "qwe@mail.com"
        )
    configuration = Configuration(userOwner = user)
    }

    @Test
    fun testBlackBox1() {
        validation.isUserCredentialsValid("", "Aa123__", "Aa123__").isError.let {
            assertTrue(
                it.value
            )
        }
    }

    @Test
    fun testBlackBox2() {
        validation.isUserCredentialsValid(
            "qwe",
            "Aa123__",
            "Aa123__"
        ).isError.let {
            assertTrue(
                it.value
            )
        }
    }

    @Test
    fun testBlackBox3() {
        validation.isUserCredentialsValid(
            "qwe@mail.com",
            "",
            "Aa123__"
        ).isError.let {
            assertTrue(
                it.value
            )
        }
    }

    @Test
    fun testBlackBox4() {
        validation.isUserCredentialsValid("qwe@mail.com", "1", "1").isError.let {
            assertTrue(
                it.value
            )
        }
    }

    @Test
    fun testBlackBox5() {
        validation.isUserCredentialsValid(
            "qwe@mail.com",
            "Aa123__",
            "456789Aa"
        ).isError.let {
            assertTrue(
                it.value
            )
        }
    }

    @Test
    fun testBlackBox6() {
        validation.isUserCredentialsValid(
            "qwe@mail.com",
            "Aa123__",
            "Aa123__"
        ).isError.let {
            assertFalse(
                it.value
            )
        }
    }

    @Test
    fun testBasePath1() {
        Assert.assertTrue(validation.isUserChangePassword("","","").isError.value)
    }

    @Test
    fun testBasePath2() {
        Assert.assertTrue(validation.isUserChangePassword("12356","","").isError.value)
    }

    @Test
    fun testBasePath3() {
        Assert.assertTrue(validation.isUserChangePassword("123456","123","").isError.value)
    }

    @Test
    fun testBasePath4() {
        Assert.assertFalse(validation.isUserChangePassword("123456","12345678","12345678").isError.value)
    }

    @Test
    fun integrationTestWithMoq() {
        mockConfiguration = Mockito.spy(configuration)
        Mockito.`when`(mockConfiguration?.checkingCompatibility()).thenReturn(ConfigurationError())
        Mockito.`when`(mockConfiguration?.checkingTheRequiredComponents()).thenReturn(ConfigurationError())
        configuration?.checkingCompatibility()?.isError?.let { Assert.assertTrue(it.value) }
    }

    @Test
    fun integrationTestWithoutMoq() {
        configuration?.checkingCompatibility()?.isError?.let { Assert.assertTrue(it.value) }
    }


    @After
    fun clean() {
    }
}