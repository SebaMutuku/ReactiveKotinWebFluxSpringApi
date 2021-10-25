package com.webflux.springwebflux.utils

import lombok.Getter
import lombok.Setter
import lombok.ToString


@ToString
@Getter
@Setter
class UserRequest  {
    var username = ""
    var password = ""
}