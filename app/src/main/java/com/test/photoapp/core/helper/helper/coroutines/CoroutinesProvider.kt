package com.test.photoapp.core.helper.helper.coroutines

import kotlinx.coroutines.Job

interface CoroutinesProvider {
    fun <T : Any> request(
        work: suspend (() -> T?),
        callback: ((Result) -> Unit)
    ): Job
}