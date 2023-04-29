package com.webflux.springwebflux.utils

import org.springframework.http.HttpStatus

data class UserResponseDTO(val token: String = "",
                           val message: String = "",
                           val status: HttpStatus = HttpStatus.NOT_FOUND)