package com.ua.pavliyk.advance.domain.posts


import com.ua.pavliyk.advance.data.common.NetworkResult
import com.ua.pavliyk.advance.data.posts.PostApiService
import com.ua.pavliyk.advance.data.posts.model.requests.NewPost
import com.ua.pavliyk.advance.data.posts.model.responses.DeletedPost
import com.ua.pavliyk.advance.data.posts.model.responses.Post
import com.ua.pavliyk.advance.data.posts.model.responses.Posts

internal class AppPostRepository(
    private val postApiService: PostApiService
) : PostRepository {

    override suspend fun getAllPosts(): NetworkResult<Posts> {
        return postApiService.getAllPosts()
    }

    override suspend fun addPost(post: NewPost): NetworkResult<Post> {
        return postApiService.addPost(post)
    }

    override suspend fun updatePost(post: Post): NetworkResult<Post> {
        return postApiService.updatePost(post)
    }

    override suspend fun deletePost(postId: Int): NetworkResult<DeletedPost> {
        return postApiService.deletePost(postId)
    }
}