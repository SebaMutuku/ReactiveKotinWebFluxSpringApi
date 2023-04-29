package com.webflux.springwebflux.servicesimpl

import com.webflux.springwebflux.entities.Users
import com.webflux.springwebflux.utils.ResponseDTO
import com.webflux.springwebflux.utils.UserRequestDTO
import com.webflux.springwebflux.utils.UserResponseDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

abstract class UserServiceInterface {
    abstract fun login(request: UserRequestDTO): Mono<UserResponseDTO>
    abstract fun createUser(request: UserRequestDTO): Mono<ResponseDTO>
    abstract fun deleteUser(user: Users): Mono<UserResponseDTO>
    abstract fun updateUser(userRequest: UserRequestDTO): Mono<ResponseDTO>
    abstract fun findAllUsers(): Flux<ResponseDTO>

}
