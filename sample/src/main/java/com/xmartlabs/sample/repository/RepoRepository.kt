package com.xmartlabs.sample.repository

import com.xmartlabs.sample.model.Repo
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoRepository @Inject constructor(
    private val repoNetworkSource: RepoNetworkSource
) {
  fun getTrendingRepositories(): Single<List<Repo>> = repoNetworkSource.getTrendingRepositories()
}
