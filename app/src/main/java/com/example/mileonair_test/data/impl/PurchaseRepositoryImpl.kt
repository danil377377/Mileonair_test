package com.example.mileonair_test.data.impl

import com.example.mileonair_test.domain.api.PurchaseRepository
import com.example.mileonair_test.domain.model.PurchaseGroup
import com.example.mileonair_test.domain.model.PurchaseItem
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Singleton
import javax.inject.Inject

@Singleton
class PurchaseRepositoryImpl @Inject constructor() :PurchaseRepository  {
    override suspend fun getPurchaseData(): List<PurchaseItem> {
        val jsonData = """
            {
               "data":[
                  {
                     "date":"2022-09-10T21:55:33Z",
                     "name":[
                        "123",
                        "321"
                     ]
                  },
                  {
                     "date":"2022-09-10T21:50:33Z",
                     "name":[
                        "1234",
                        "4321"
                     ]
                  },
                  {
                     "date":"2022-09-08T01:55:33Z",
                     "name":[
                        "12345",
                        "54321"
                     ]
                  },
                  {
                     "date":"2022-09-07T21:55:33Z",
                     "name":[
                        "123456",
                        "654321"
                     ]
                  },
                  {
                     "date":"2022-09-07T11:55:33Z",
                     "name":[
                        "1234567",
                        "7654321"
                     ]
                  }
               ]
            }
        """.trimIndent()

        return try {
            val jsonObject = JSONObject(jsonData)
            val jsonArray = jsonObject.getJSONArray("data")
            val purchaseList = mutableListOf<PurchaseItem>()
            for (i in 0 until jsonArray.length()) {
                val itemJson = jsonArray.getJSONObject(i)
                val date = itemJson.getString("date")
                val nameArray = itemJson.getJSONArray("name")
                val nameList = (0 until nameArray.length()).map { nameArray.getString(it) }
                purchaseList.add(PurchaseItem(date, nameList))
            }
            purchaseList
        } catch (e: JSONException) {
            emptyList() //Обработка ошибок
        }
    }

    override fun transformData(purchaseList: List<PurchaseItem>): List<PurchaseGroup> {
        val purchaseMap = purchaseList.groupBy {
            SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault()).parse(it.date)
            )
        }

        return purchaseMap.map { (date, items) ->
            PurchaseGroup(date, items.flatMap { it.name })
        }
    }
}