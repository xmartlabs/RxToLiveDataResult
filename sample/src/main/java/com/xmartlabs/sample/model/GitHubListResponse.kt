package com.xmartlabs.sample.model

data class GitHubListResponse<T>(val totalCount: Int, val items: List<T>)
