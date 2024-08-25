package kr.disdong.serialization.domain.user.fixture

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.serialization.domain.common.fixture.FixtureUtil
import kr.disdong.serialization.domain.user.model.PlainUser
import kr.disdong.serialization.domain.user.model.impl.PlainUserJpaImpl

object PlainUserFixture {

    fun any(): PlainUser = FixtureUtil.monkey().giveMeBuilder<PlainUserJpaImpl>()
        .sample()
}
