package kr.disdong.serialization.server.domain.user.service

import kr.disdong.serialization.domain.user.model.impl.PlainUserJpaImpl
import kr.disdong.serialization.domain.user.repository.UserRepository
import kr.disdong.serialization.server.core.config.IntegrationTestConfiguration
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserServiceTest : IntegrationTestConfiguration() {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var sut: UserService

    @BeforeEach
    fun setup() {
        userRepository.deleteAll()
        userRepository.save(PlainUserJpaImpl(name = "one", phone = "01012341234"))
    }

    @Test
    fun `simple test`() {
        val response = sut.getByUserId(1L)

        assertNotNull(response)
    }
}
