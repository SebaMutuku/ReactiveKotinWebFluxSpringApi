package com.webflux.springwebflux.api

import com.webflux.springwebflux.entities.Users
import com.webflux.springwebflux.exception.GenericExceptionHandler
import com.webflux.springwebflux.services.Usersservice
import com.webflux.springwebflux.utils.ResponseDTO
import com.webflux.springwebflux.utils.UserRequestDTO
import com.webflux.springwebflux.utils.UserResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/api/users")
class GeneralApi @Autowired constructor(private var usersservice: Usersservice) {

    @PostMapping(
            path = ["/login"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ExceptionHandler(value = [GenericExceptionHandler::class])
    fun getUsers(@RequestBody request: UserRequestDTO): ResponseEntity<Mono<Any>> {
        return ResponseEntity.ok(Mono.from(usersservice.login(request)))
    }

    @PostMapping(
            path = ["/createuser"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ExceptionHandler(value = [GenericExceptionHandler::class])
    fun createUsers(@RequestBody request: UserRequestDTO): ResponseEntity<Mono<ResponseDTO>> {
        return ResponseEntity.ok(usersservice.createUser(request))
    }

    @PostMapping(
            path = ["/deleteuser"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ExceptionHandler(value = [GenericExceptionHandler::class])
    fun deleteUser(@RequestBody user: Users): ResponseEntity<Mono<UserResponseDTO>> {
        return ResponseEntity.ok(usersservice.deleteUser(user))
    }

    @PostMapping(
            path = ["/updateuser"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ExceptionHandler(value = [GenericExceptionHandler::class])
    fun updateUser(@RequestBody request: UserRequestDTO): ResponseEntity<Mono<ResponseDTO>> {
        return ResponseEntity.ok(usersservice.updateUser(request))
    }

    @GetMapping(
            path = ["/findall"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ExceptionHandler(value = [GenericExceptionHandler::class])
    fun findAll(@RequestBody request: UserRequestDTO): ResponseEntity<Flux<ResponseDTO>> {
        return ResponseEntity(usersservice.findAllUsers(), HttpStatus.FOUND)
    }
}