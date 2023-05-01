package com.webflux.springwebflux.services

import com.webflux.springwebflux.entities.Users
import com.webflux.springwebflux.repos.UserRepository
import com.webflux.springwebflux.servicesimpl.UserServiceInterface
import com.webflux.springwebflux.utils.ResponseDTO
import com.webflux.springwebflux.utils.UserRequestDTO
import com.webflux.springwebflux.utils.UserResponseDTO
import java.util.Date
import lombok.extern.log4j.Log4j2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
@Log4j2
class Usersservice @Autowired constructor(private var usersrepo: UserRepository) : UserServiceInterface() {


    override fun login(request: UserRequestDTO): Mono<UserResponseDTO> {
        val users = usersrepo.findByUsername(request.username)
        val response = UserResponseDTO(
            token = "",
            message = "Invalid credentials",
            status = HttpStatus.UNAUTHORIZED
        )
        return users.map { u ->
            u.lastLogin = Date(2021)
            u.isActive = true
            u.token = "yayauueyya"
            usersrepo.save(u)
            u
        }.map { user ->
            response.copy(
                token = user.token,
                status = HttpStatus.OK,
                message = "Successfully logged in"
            )
        }

    }


    override fun createUser(request: UserRequestDTO): Mono<ResponseDTO> {
        val response = ResponseDTO(
            message = "Invalid credentials",
            status = HttpStatus.UNAUTHORIZED,
            payload = null
        )
        val users = Users()
        users.createdOn = Date(2021)
        users.password = request.password
        users.username = request.username
        users.userId = 43
        users.phonenumber = ""
        users.lastLogin = Date(2021)
        users.token = "akakaka"
        users.isActive = true
        users.agent = false


        return usersrepo.findByUsername(request.username).map { user ->
            user
        }.switchIfEmpty(
            usersrepo.save(
                users
            )
        ).map { user ->
            response.copy(
                status = HttpStatus.UNAUTHORIZED,
                payload = user,
                message = "Success"
            )
        }
    }

    override fun deleteUser(user: Users): Mono<UserResponseDTO> {

        val response = UserResponseDTO(
            token = "",
            message = "Not found",
            status = HttpStatus.NOT_FOUND
        )
        return usersrepo.findByUserId(user.userId).doOnNext { user -> usersrepo.delete(user) }.map { deleted ->
            response.copy(
                status = HttpStatus.OK,
                message = deleted.token
            )
        }
    }

    override fun updateUser(userRequest: UserRequestDTO): Mono<ResponseDTO> {
        val response = ResponseDTO(
            message = "Invalid credentials",
            status = HttpStatus.UNAUTHORIZED,
            payload = null
        )
        return usersrepo.findByUsername(userRequest.username).doOnNext { user ->
            user.username = "sebastianMm"
            user.phonenumber = "072753818"
        }.flatMap { user ->
            usersrepo.save(user)
        }.map { user ->
            response.copy(
                payload = user,
                message = "Success"
            )
        }
    }

    override fun findAllUsers(): Flux<ResponseDTO> {
        val response = ResponseDTO(
            message = "Invalid credentials",
            status = HttpStatus.UNAUTHORIZED,
            payload = null
        )
        return usersrepo.findAll().map { user ->
            user
        }.map { user ->
            response.copy(
                payload = user,
                message = "Success",
                status = HttpStatus.OK
            )
        }
    }


}


