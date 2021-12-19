package br.com.dineduc.backend.model

import lombok.Getter
import javax.persistence.*

@Entity
data class UserLessons(
    @Id
    @GeneratedValue
    @Getter
    var id: Long,
    @OneToOne(fetch = FetchType.LAZY)
    var user: User?,
    @OneToOne(fetch = FetchType.LAZY)
    var lesson: Lesson?,
    var completed: Boolean) : BaseEntity() {

    constructor() : this(0, null, null, false)
}
