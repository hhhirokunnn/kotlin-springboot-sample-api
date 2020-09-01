package hhhirokunn.sampleapi.app.repository.model

import org.springframework.data.annotation.Id

import java.time.LocalDateTime
import java.time.LocalDateTime.now

data class ItemEntity(
        @Id
        val id: Long?,
        val title: String,
        val description: String?,
        val createdAt: LocalDateTime = now(),
        val updatedAt: LocalDateTime = now()
)
