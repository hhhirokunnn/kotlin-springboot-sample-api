package hhhirokunn.sampleapi.app.repository

import hhhirokunn.sampleapi.app.repository.model.ItemEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository: CrudRepository<ItemEntity, Long> {

    fun findOne(id: Long): ItemEntity?

    fun findByTitle(title: String): ItemEntity?
}