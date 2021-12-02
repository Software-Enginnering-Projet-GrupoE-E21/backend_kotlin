package br.com.dineduc.backend.model

import lombok.Getter
import lombok.RequiredArgsConstructor
import org.hibernate.annotations.Formula
import javax.persistence.*

@Entity(name = "organizations")
data class Organization (
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var legalName: String,
    var name: String,
    var document: String,
    var street: String,
    var number: String,
    var addressExtra: String?,
    var state : String?,
    var city : String?,
    var enabled : Boolean,
    var maxStudents: Int,
    var inviteCode: String,

    ) : BaseCMSEntity() {
    constructor() : this(0, "" ,"" ,"" ,"" ,"" ,"" ,"" ,"" , false, 0, "") {

    }
}