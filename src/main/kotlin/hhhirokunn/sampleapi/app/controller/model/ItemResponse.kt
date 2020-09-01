package hhhirokunn.sampleapi.app.controller.model

data class ItemDomain(
        val id: Long,
        val title: String?,
        val updatedAt: String,
        val createdAt: String
): DomainResponse

data class ItemResponse<ItemDomain>(
    override val data: ItemDomain
): SampleApiDomainResponse<ItemDomain>(data = data)

data class ItemError(
        val method: String?,
        val context: String
): DomainResponse

class ItemNotFoundErrorResponse(
        override val data: ItemError
): SampleApiDomainResponse<ItemError>(data = data) {
    companion object Factory {
        fun create(method: String) = ItemNotFoundErrorResponse(data = ItemError(method, "ItemNotFound"))
    }
}


//data class ItemNotFoundError(
//    override val domain: String = "Item",
//    override val method: String,
//    override val content: String = "The item does not exist."
//): ItemError(), SampleApiDomain
