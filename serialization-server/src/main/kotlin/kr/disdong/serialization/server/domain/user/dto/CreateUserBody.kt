package kr.disdong.serialization.server.domain.user.dto

import kr.disdong.serialization.domain.user.model.PlainUser
import kr.disdong.serialization.domain.user.model.impl.PlainUserJpaImpl

class CreateUserBody(
    val name: String,
    val phone: String,
) {

    fun toUser(): PlainUser {
        return PlainUserJpaImpl(
            name = name,
            phone = phone,
        )
    }
}
