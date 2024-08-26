package kr.disdong.serialization.reactive.server

import kr.disdong.serialization.domain.DomainApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@Import(DomainApplication::class)
@RestController
class ReactiveServerApplication {

    @GetMapping("/health")
    fun health(): String {
        return "ok"
    }
}

fun main(args: Array<String>) {
    runApplication<ReactiveServerApplication>(*args)
}
