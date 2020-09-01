package hhhirokunn.sampleapi.app.service

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import com.github.kittinunf.fuel.httpGet
import hhhirokunn.sampleapi.app.controller.model.*
import hhhirokunn.sampleapi.app.repository.ItemRepository
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.InputStreamReader

@Service
class ItemService(val itemRepository: ItemRepository) {

    fun load(id: Long): SampleApiDomainResponse<out DomainResponse> =
        itemRepository.findOne(id)?.let {
            ItemResponse(
                data = ItemDomain(
                    id = it.id!!,
                    title = it.title,
                    createdAt = it.createdAt.toString(),
                    updatedAt = it.updatedAt.toString())) }
            ?: ItemNotFoundErrorResponse.create("read")

    fun loadAll(): SampleApiDomainResponse<List<ItemDomain>> {
        val responseDomain = itemRepository.findAll().map {
            ItemDomain(
                id = it.id!!,
                title = it.title,
                createdAt = it.createdAt.toString(),
                updatedAt = it.updatedAt.toString())}
        return ItemResponse(responseDomain)
    }

    fun test(): String {
//        val filename = "file.csv"
//        val file = try {
////            val file = File("file.csv")
////            val fileReader = BufferedReader(file)
//
////            csvReader().
//        }
        csvWriter().open("test.csv") {
            val rows =  listOf(listOf("a","b","c"), listOf("a","b","c"))
            writeAll(rows)
        }


        val file = File("tet.csv")
        val rows: List<List<String>> = csvReader().readAll(file)
        csvReader().open("xxx.csv") {
//            val Array(id, title) =
            readAllAsSequence().forEach {
                ItemDomain(
                        id = it[0].toLong(),
                        title = it[1],
                        createdAt = "",
                        updatedAt = ""
                )
            }
        }

        val tsvReader = csvReader {
            charset = "ISO_8859_1"
            quoteChar = '"'
            delimiter = '\t'
            escapeChar = '\\'
        }

        val xxx:List<ItemDomain> = tsvReader.open("") {
            readAllAsSequence().map {
                ItemDomain(
                        id = it[0].toLong(),
                        title = it[1],
                        createdAt = "",
                        updatedAt = ""
                )
            }.toList()
        }

        // 非同期処理
        "https://www.casareal.co.jp/".httpGet().response { request, response, result ->
            when (result) {
                is com.github.kittinunf.result.Result.Success -> {
                    // レスポンスボディを表示
                    println("非同期処理の結果：" + String(response.data))
                }
                is com.github.kittinunf.result.Result.Failure -> {
                    println("通信に失敗しました。")
                }
            }
        }

        // 同期処理
        val triple = "https://www.casareal.co.jp/".httpGet().response()



        return ""
    }

}