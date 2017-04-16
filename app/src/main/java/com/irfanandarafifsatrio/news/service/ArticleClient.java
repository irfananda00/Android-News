package com.irfanandarafifsatrio.news.service;

import com.irfanandarafifsatrio.news.dao.ArticleDao;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by irfanandarafifsatrio on 4/15/17.
 */

public interface ArticleClient {
    @GET("articles?apiKey="+Service.API_KEY)
    Call<ArticleDao> getArticle(
            @Query("source") String source
    );
}
