package com.kotlin.kotlingithubbookmarks.retrofit;


import com.kotlin.kotlingithubbookmarks.models.Repository;
import com.kotlin.kotlingithubbookmarks.models.SearchResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;


public interface GithubAPIService {

	@GET("search/repositories")
	Call<SearchResponse> searchRepositories(@QueryMap Map<String, String> options);

	@GET("/users/{username}/repos")
	Call<List<Repository>> searchRepositoriesByUser(@Path("username") String githubUser);
}