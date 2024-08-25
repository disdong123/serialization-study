package kr.disdong.serialization.domain.user.model.impl

import kr.disdong.serialization.domain.user.model.PlainUser

class PlainUserJpaImpl(
    override val id: Long = 0,
    override var name: String,
    override val phone: String
) : PlainUser
