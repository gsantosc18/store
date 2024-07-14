package com.github.gsantosc18.store.infra.metrics

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.Duration.ZERO

@Component
class CreateProductMeter(
    private val meterRegistry: MeterRegistry
) {
    private val name = "create_product_store"

    private fun timer(pulse: Boolean): Timer =
        meterRegistry.timer(name, "pulse", pulse.toString())

    fun timer(): Timer = timer(false)

    @Scheduled(fixedDelay = 300_000)
    private fun pulse() {
        timer(true).record(ZERO)
    }
}