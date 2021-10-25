package com.webflux.springwebflux.services

import com.webflux.springwebflux.entities.Users
import com.webflux.springwebflux.repos.Usersrepo
import com.webflux.springwebflux.utils.GeneralResponse
import com.webflux.springwebflux.utils.UserRequest
import com.webflux.springwebflux.utils.UserResponse
import lombok.extern.log4j.Log4j2
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*


@Service
@Log4j2
class Usersservice {
    @Autowired
    lateinit var usersrepo: Usersrepo
    lateinit var response: UserResponse

    fun login(request: UserRequest): Mono<UserResponse> {
        val users: Mono<Users> = usersrepo.findByUsername(request.username)
        response.message = "No Data Found"
        response.status = HttpStatus.NOT_FOUND
        return users.map { u ->
            u.userId = 1
            u.lastLogin = Date(2021)
            u.isActive = true
            u.token = "yayauueyya"
            usersrepo.save(u)
            response.message = "Success"
            response.token = "users"
            response.status = HttpStatus.ACCEPTED
            response
        }
            .map { responseValues ->
                responseValues?.log()
                responseValues
            }.switchIfEmpty(response)

    }


    fun createUser(request: UserRequest): Mono<Users> {
        var users = Users()
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
        }
            .switchIfEmpty(
                usersrepo.save(
                    users
                )
            ).map { user ->
                print("User $user saved in db\n")
                user
            }
    }

    fun deleteUser(request: UserRequest): Mono<UserResponse> {
        var response = UserResponse()
        response.message = "User ${request.username} not found"
        response.status = HttpStatus.NOT_FOUND
        response.token = ""
        return usersrepo.findByUsername(request.username).map { user ->
            response.message = "Successfully deleted user ${user.username}"
            response.status = HttpStatus.ACCEPTED
            response.token = ""
            response
        }.doOnNext { response ->
            response
        }.switchIfEmpty(response)
    }

    fun updateUser(userRequest: UserRequest): Mono<Users> {
        return usersrepo.findByUsername(userRequest.username).doOnNext { user ->
            user.username = "sebastianMm"
            user.phonenumber = "072753818"
            user

        }
            .flatMap { user ->
                usersrepo.save(user)
            }.map { user -> user }
    }

    fun findAllUsers(): Flux<GeneralResponse> {
        var response = GeneralResponse()
        response.message = "Not Found"
        response.status = HttpStatus.NOT_FOUND
        response.payload = null
        return usersrepo.findAll().map { user ->
            user
        }.map { user ->
            response.message = "Successfully found user"
            response.status = HttpStatus.FOUND
            response.payload = user
            response
        }
//            .switchIfEmpty(response).flatMap { response ->
//                response
//            }
    }


}


