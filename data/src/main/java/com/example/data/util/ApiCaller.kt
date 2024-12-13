package com.example.data.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException

fun <T> performApiCall(
    funcName: String,
    apiCall: suspend () -> Response<T>
): Flow<Result<T>> = flow {
    try {
        val response = apiCall()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                emit(Result.success(body))
            } else {
                emit(Result.failure(ApiException.EmptyResponseException(funcName)))
            }
        } else {
            emit(
                Result.failure(
                    ApiException.ApiErrorException(
                        funcName,
                        "Status Code: ${response.code()}, Error Body: ${response.errorBody()?.string()}"
                    )
                )
            )
        }
    } catch (e: IOException) {
        emit(Result.failure(ApiException.NetworkException("[$funcName] - Network error: ${e.message}")))
    } catch (e: Exception) {
        emit(Result.failure(Exception("[$funcName] - Unexpected error: ${e.message}")))
    }
}