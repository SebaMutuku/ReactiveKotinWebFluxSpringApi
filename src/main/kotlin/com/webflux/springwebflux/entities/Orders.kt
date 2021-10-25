package com.webflux.springwebflux.entities

import java.sql.Timestamp
import javax.persistence.*

@Entity
class Orders {
    @Id
    var orderid = 0
    var ordernumber: String =""
    var ordertime: Timestamp? = Timestamp(System.currentTimeMillis())
    var orderamount = 0.0
    var orderlocation: String=""
    var deliverytime: Timestamp = Timestamp(System.currentTimeMillis())
    var orderdetails: String=""
    var orderstatus: String=""
    var deliveryagent: String=""

//    @get:JoinColumn(name = "customerid", referencedColumnName = "user_id", nullable = false)
//    @get:OneToOne
//    var users: Users? = null
}