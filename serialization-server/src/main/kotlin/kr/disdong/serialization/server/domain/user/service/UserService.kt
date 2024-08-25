package kr.disdong.serialization.server.domain.user.service

import kr.disdong.serialization.domain.user.model.User
import kr.disdong.serialization.domain.user.service.UserManager
import kr.disdong.serialization.server.domain.user.dto.CreateUserBody
import kr.disdong.serialization.server.domain.user.exception.UserNotFound
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userManager: UserManager,
) {

    fun getByUserId(userId: Long) =
        userManager.getUser(userId)
            ?: throw UserNotFound(userId)

    fun create(request: CreateUserBody): User {
        return userManager.create(request.toUser())
    }
}
