package com.webflux.springwebflux.repos

import com.webflux.springwebflux.entities.Users
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface Usersrepo : ReactiveMongoRepository<Users, Long> {
    fun findByUsername(username: String): Mono<Users>
}