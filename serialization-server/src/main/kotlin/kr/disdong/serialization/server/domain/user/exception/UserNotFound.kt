package kr.disdong.serialization.server.domain.user.exception

import kr.disdong.serialization.common.exception.NotFoundException

class UserNotFound(private val userId: Long) : NotFoundException("$userId 유저를 찾을 수 없습니다.")
