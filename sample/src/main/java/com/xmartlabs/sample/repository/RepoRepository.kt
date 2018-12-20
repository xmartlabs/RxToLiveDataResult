package com.xmartlabs.sample.repository

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoRepository @Inject constructor(
    private val repoNetworkSource: RepoNetworkSource
) {
  fun getTrendingRepositories() = repoNetworkSource.getTrendingRepositories()
}