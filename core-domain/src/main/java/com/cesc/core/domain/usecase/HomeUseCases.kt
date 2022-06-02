package com.cesc.core.domain.usecase

import com.cesc.core.data.repository.HomeBannerRepository
import com.cesc.core.domain.IUseCase
import com.cesc.core.model.HomeBanner
import org.koin.core.annotation.Singleton

interface GetHomeBannersUseCase : IUseCase<Unit, List<HomeBanner>>


@Singleton
class GetHomeBannersUseCaseImpl(
    private val repository: HomeBannerRepository
) : GetHomeBannersUseCase {
    override suspend fun invoke(param: Unit?): List<HomeBanner> = repository()
}
