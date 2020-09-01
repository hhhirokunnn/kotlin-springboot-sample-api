package hhhirokunn.sampleapi.app.controller

import hhhirokunn.sampleapi.app.controller.model.*
import hhhirokunn.sampleapi.app.service.ItemService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/items")
class ItemController(private val itemService: ItemService) {

    fun read(@PathVariable("itemId") itemId: Long): SampleApiResponse<out DomainResponse> =
            itemService.load(itemId)

    fun show(): SampleApiResponse<List<ItemDomain>> = itemService.loadAll()
}