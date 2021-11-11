package br.com.dineduc.backend.model

import lombok.Getter
import lombok.RequiredArgsConstructor
import org.hibernate.annotations.Formula
import javax.persistence.*

@Entity
data class Organization (
    @Id
    @GeneratedValue
    @Getter
    var id: Long,
    var legalName: String,
    var fantasyName: String,
    var document: String,
    var address: String,
    var addressNumber: String,
    var addressExtra: String,
    var state : String,
    var city : String,
    var active : Boolean,
    var maxStudents: Int,
    var invitationCode: String,

) : BaseEntity() {
    constructor() : this(0, "" ,"" ,"" ,"" ,"" ,"" ,"" ,"" , false, 0, "") {

    }

}