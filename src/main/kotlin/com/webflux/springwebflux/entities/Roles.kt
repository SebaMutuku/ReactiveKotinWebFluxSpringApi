package com.webflux.springwebflux.entities


import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.ToString
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
class Roles {
    @Id
    var roleid = 0
    var rolename: String? = null
}