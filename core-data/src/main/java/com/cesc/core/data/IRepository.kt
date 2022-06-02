package com.cesc.core.data

interface IRepository<in Parameter, out Output> {
    suspend operator fun invoke(param: Parameter? = null): Output
}
