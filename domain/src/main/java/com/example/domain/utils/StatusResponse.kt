package com.example.domain.utils

sealed class StatusResponse<R> {
    class Success<R>(val result : R) : StatusResponse<R>()
    class Error<R>(val error : String) : StatusResponse<R>()
}