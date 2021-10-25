package com.webflux.springwebflux.entities


import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Entity
class Registeredvehicles {
    @Id
    var carid = 0
    var carname: String? = null
    var carmodel: String? = null
    var carcolor: String? = null
    var carregnumber: String? = null
    var registeredon: Timestamp? = Timestamp(System.currentTimeMillis())
//
//    @get:JoinColumn(name = "userid", referencedColumnName = "user_id")
//    @get:ManyToOne
//    var users: Users? = null
}