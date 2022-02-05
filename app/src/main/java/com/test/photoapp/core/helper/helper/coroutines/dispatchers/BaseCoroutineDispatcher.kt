package com.test.photoapp.core.helper.helper.coroutines.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface BaseCoroutineDispatcher {
    /**
     * Provides main thread coroutine dispatcher.
     * @return CoroutineDispatcher
     */
    fun main(): CoroutineDispatcher

    /**
     * Provides io thread coroutine dispatcher.
     * @return CoroutineDispatcher
     */
    fun io(): CoroutineDispatcher
}