package kr.disdong.serialization.domain.user.service

import kr.disdong.serialization.domain.user.model.PlainUser
import kr.disdong.serialization.domain.user.model.User
import kr.disdong.serialization.domain.user.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserManager(
    private val userRepository: UserRepository,
) {
    @Transactional(readOnly = true)
    fun getUser(userId: Long): User? {
        return userRepository.findByUserId(userId)
    }

    @Transactional
    fun create(user: PlainUser): User {
        return userRepository.save(user)
    }
}
