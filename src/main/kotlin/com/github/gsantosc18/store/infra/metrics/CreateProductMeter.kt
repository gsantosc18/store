package com.github.gsantosc18.store.infra.metrics

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import org.springframework.stereotype.Component

@Component
class CreateProductMeter(
    private val meterRegistry: MeterRegistry
) {
    private val name = "create_product_store"

    fun timer(): Timer = meterRegistry.timer(name)
}