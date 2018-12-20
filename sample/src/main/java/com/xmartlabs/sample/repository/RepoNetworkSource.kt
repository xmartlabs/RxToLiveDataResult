package com.xmartlabs.sample.repository

import com.xmartlabs.sample.service.GitHubService
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoNetworkSource @Inject constructor(
    private val gitHubService: GitHubService
) {
  fun getTrendingRepositories() = gitHubService.getTrendingRepositories()
      .map { it.items }
      .subscribeOn(Schedulers.io())
}