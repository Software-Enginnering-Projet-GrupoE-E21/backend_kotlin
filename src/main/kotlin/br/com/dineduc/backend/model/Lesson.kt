package br.com.dineduc.backend.model

import lombok.Getter
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "lessons")
data class Lesson(
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var title: String,
    var content: String,
    var description: String,
) : BaseCMSEntity() {
    constructor() : this(0, "", "", "") {}
}