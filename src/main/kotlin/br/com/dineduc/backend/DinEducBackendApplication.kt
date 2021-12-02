package br.com.dineduc.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class DinEducBackendApplication

fun main(args: Array<String>) {
    runApplication<DinEducBackendApplication>(*args)
}
