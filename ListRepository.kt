package com.monica.ec3_monica_gonzales_.data.repository

import com.monica.ec3_monica_gonzales_.data.ListServiceResults
import com.monica.ec3_monica_gonzales_.data.response.ListEcResponse
import com.monica.ec3_monica_gonzales_.data.retrofit.RetrogitHelper

class ListRepository {

    suspend fun getList() : ListServiceResults<ListEcResponse> {
        return try {
            val response = RetrogitHelper.listService.gatAllList()
            ListServiceResults.Success(response)
        }
        catch (e : Exception){
            ListServiceResults.Error(e)
        }

    }
}