package kr.disdong.serialization.domain

import kr.disdong.serialization.jpa.JpaApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(JpaApplication::class)
class DomainApplication
