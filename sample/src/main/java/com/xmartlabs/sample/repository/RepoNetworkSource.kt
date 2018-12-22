package com.xmartlabs.sample.repository

import com.xmartlabs.sample.model.Repo
import com.xmartlabs.sample.service.GitHubService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoNetworkSource @Inject constructor(
    private val gitHubService: GitHubService
) {
  fun getTrendingRepositories(): Single<List<Repo>> = gitHubService.getTrendingRepositories()
      .map { it.items }
      .subscribeOn(Schedulers.io())
}
