package com.monica.ec3_monica_gonzales_.data


sealed class ListServiceResults<T>(data : T? = null, error : Exception? = null) {
    data class Success<T>(val data : T) : ListServiceResults<T>(data, null)
    data class Error<T>(val error : Exception) : ListServiceResults<T>(null, error)
}