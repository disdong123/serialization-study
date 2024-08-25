package kr.disdong.serialization.domain.user.repository.impl

import kr.disdong.serialization.domain.user.model.PlainUser
import kr.disdong.serialization.domain.user.model.User
import kr.disdong.serialization.domain.user.model.impl.toUser
import kr.disdong.serialization.domain.user.repository.UserRepository
import kr.disdong.serialization.jpa.domain.user.model.UserEntity
import kr.disdong.serialization.jpa.domain.user.repository.UserJpaRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryJpaImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {
    override fun findByUserId(userId: Long): User? {
        return userJpaRepository.findByUserId(userId)?.toUser()
    }

    override fun save(user: PlainUser): User {
        return userJpaRepository.save(
            UserEntity(
                name = user.name,
                phone = user.phone,
            )
        ).toUser()
    }

    override fun deleteAll() {
        userJpaRepository.deleteAll()
    }
}
