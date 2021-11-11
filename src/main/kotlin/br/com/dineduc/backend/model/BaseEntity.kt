package br.com.dineduc.backend.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass


@MappedSuperclass
abstract class BaseEntity {
    @Column(updatable = false)
    @CreationTimestamp
    private val createdAt: LocalDateTime? = null

    @UpdateTimestamp
    private val updatedAt: LocalDateTime? = null
}