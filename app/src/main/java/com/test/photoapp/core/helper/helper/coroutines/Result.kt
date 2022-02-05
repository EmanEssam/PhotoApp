package com.test.photoapp.core.helper.helper.coroutines

sealed class Result
class Success<T>(var result: T) : Result()
class Failure<E>(var error: E) : Result()