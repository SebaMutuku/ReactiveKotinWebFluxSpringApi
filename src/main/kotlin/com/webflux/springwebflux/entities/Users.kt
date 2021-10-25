package com.webflux.springwebflux.entities


import lombok.*
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.persistence.Id


@AllArgsConstructor
@NoArgsConstructor
@Document
@ToString
@Data
data class Users(
    @Id
    @Generated
    var userId: Int = 0,
    var username: String = "",
    var password: String = "",
    var phonenumber: String = "",
    var createdOn: Date = Date(2021),
    var lastLogin: Date = Date(2021),
    var admin: Boolean = false,
    var isActive: Boolean = true,
    var token: String = "",
    var agent: Boolean = false,

//
//    @JsonIgnore
//    @JoinColumn(name = "roleid", referencedColumnName = "roleid")
//    @ManyToOne
//    var roles: Roles


)