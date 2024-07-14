package com.github.gsantosc18.store.shared

import io.micrometer.core.instrument.Timer

fun <T> T?.notNull(
    message: String = "Required value not null"
): T = requireNotNull(this){ message }

fun <T> T.record(
    timer: Timer,
    record: (T) -> T
): T = timer.recordCallable{record(this)}.notNull()