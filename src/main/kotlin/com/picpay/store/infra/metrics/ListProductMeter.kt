package com.picpay.store.infra.metrics

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import org.springframework.stereotype.Component

@Component
class ListProductMeter(
    private val meterRegistry: MeterRegistry
) {
    private val name = "list_product_store";
    fun timer(): Timer =
        meterRegistry.timer(name)
}