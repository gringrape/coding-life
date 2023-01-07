package com.gringrape.board.infrastructure

import org.jetbrains.exposed.spring.autoconfigure.ExposedAutoConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(value = [ExposedAutoConfiguration::class])
@EnableAutoConfiguration(exclude = [DataSourceTransactionManagerAutoConfiguration::class])
@Configuration
class ExposedConfig
