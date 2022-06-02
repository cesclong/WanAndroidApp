package com.cesc.core.domain


interface IUseCase<in Parameter, out Output> {
    suspend operator fun invoke(param: Parameter? = null): Output
}
