package kr.disdong.serialization.domain.user.repository

import kr.disdong.serialization.domain.user.model.PlainUser
import kr.disdong.serialization.domain.user.model.User

interface UserRepository {

    fun findByUserId(userId: Long): User?

    fun save(user: PlainUser): User

    fun deleteAll()
}
