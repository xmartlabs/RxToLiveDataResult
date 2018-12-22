package com.xmartlabs.sample.service

import com.xmartlabs.sample.model.GitHubListResponse
import com.xmartlabs.sample.model.Repo
import io.reactivex.Single
import retrofit2.http.GET

interface GitHubService {
  @GET("search/repositories?sort=stars&order=desc&q=language:kotlin")
  fun getTrendingRepositories(): Single<GitHubListResponse<Repo>>
}
