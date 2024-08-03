package com.example.configuratorpcjetpackcompose

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.configuratorpcjetpackcompose.model.data_class.Configuration
import com.example.configuratorpcjetpackcompose.model.data_class.User
import com.example.configuratorpcjetpackcompose.services.ValidationService
import com.example.configuratorpcjetpackcompose.utils.ConfigurationError
import com.example.configuratorpcjetpackcompose.viewmodel.AccessoriesViewModel
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

    @Test
    fun testBasePath1() {
        Assert.assertTrue(validation.isUserCredentialsValid("", "", "").isError.value)
    }

    @Test
    fun testBasePath2() {
        Assert.assertTrue(validation.isUserCredentialsValid("1","","").isError.value)
    }

    @Test
    fun testBasePath3() {
        Assert.assertTrue(validation.isUserCredentialsValid("dsaa@gmail.com","","").isError.value)
    }

    @Test
    fun testBasePath4() {
        Assert.assertTrue(validation.isUserCredentialsValid("dsaa@gmail.com","123","").isError.value)
    }

    @Test
    fun testBasePath5() {
        Assert.assertTrue(validation.isUserCredentialsValid("dsaa@gmail.com","12345678","1234567").isError.value)
    }
    @Test
    fun testBasePath6() {
        Assert.assertFalse(validation.isUserCredentialsValid("dsaa@gmail.com","12345678","12345678").isError.value)

    }

   /* @Test
    fun integrationTestWithMoq() {
        mockConfiguration = Mockito.spy(configuration)
        Mockito.`when`(mockConfiguration?.checkingCompatibility()).thenReturn(ConfigurationError())
        Mockito.`when`(mockConfiguration?.checkingTheRequiredComponents()).thenReturn(ConfigurationError())
        configuration?.checkingCompatibility()?.isError?.let { Assert.assertTrue(it.value) }
    }

    @Test
    fun integrationTestWithoutMoq() {
        configuration?.checkingCompatibility()?.isError?.let { Assert.assertTrue(it.value) }
    }*/


    @After
    fun clean() {
    }
}