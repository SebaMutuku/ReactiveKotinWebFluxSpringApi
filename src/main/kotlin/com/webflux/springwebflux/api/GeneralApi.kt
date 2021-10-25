package com.webflux.springwebflux.api

import com.webflux.springwebflux.entities.Users
import com.webflux.springwebflux.services.Usersservice
import com.webflux.springwebflux.utils.GeneralResponse
import com.webflux.springwebflux.utils.UserRequest
import com.webflux.springwebflux.utils.UserResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/api/users")
class GeneralApi {
    @Autowired
    lateinit var usersservice: Usersservice
    var response = UserResponse()

    @PostMapping(
        path = ["/login"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getUsers(@RequestBody request: UserRequest): ResponseEntity<Mono<Any>> {
        return ResponseEntity.ok(Mono.from(usersservice.login(request)))
    }

    @PostMapping(
        path = ["/createuser"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createUsers(@RequestBody request: UserRequest): ResponseEntity<Mono<Users>> {
        return ResponseEntity.ok(usersservice.createUser(request))
    }

    @PostMapping(
        path = ["/deleteuser"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteUser(@RequestBody request: UserRequest): ResponseEntity<Mono<UserResponse>> {
        return ResponseEntity.ok(usersservice.deleteUser(request))
    }

    @PostMapping(
        path = ["/updateuser"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateuser(@RequestBody request: UserRequest): ResponseEntity<Mono<Users>> {
        return ResponseEntity.ok(usersservice.updateUser(request))
    }

    @GetMapping(
        path = ["/findall"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findall(@RequestBody request: UserRequest): ResponseEntity<Flux<GeneralResponse>> {
        return ResponseEntity(usersservice.findAllUsers(),HttpStatus.FOUND)
    }
//
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    fun handle(e: Exception?) {
//        print("An error occurred $e")
//    }
}