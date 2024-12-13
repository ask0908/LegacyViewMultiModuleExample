package com.example.data.util

sealed class ApiException(message: String) : Exception(message) {
    class NetworkException(message: String) : ApiException(message)
    class EmptyResponseException(funcName: String) : ApiException("[$funcName] - response.body() == null")
    class ApiErrorException(funcName: String, errorBody: String?) : ApiException("[$funcName] - api error : $errorBody")
}