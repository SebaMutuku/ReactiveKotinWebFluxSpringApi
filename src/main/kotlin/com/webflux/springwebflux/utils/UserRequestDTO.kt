package com.webflux.springwebflux.utils

import lombok.Getter
import lombok.Setter
import lombok.ToString


@ToString
@Getter
@Setter
data class UserRequestDTO  (
        val username: String = "",
        val password: String = "")