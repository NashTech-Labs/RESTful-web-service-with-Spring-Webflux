package com.knoldus.RESTful.web.service.with.Spring.Webflux.controller;

import com.knoldus.RESTful.web.service.with.Spring.Webflux.entity.Post;
import com.knoldus.RESTful.web.service.with.Spring.Webflux.repository.PostRepository;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@WebFluxTest(controllers = PostController.class)
public class PostControllerTest {

    @Autowired
    WebTestClient client;

    @MockBean
    PostRepository posts;

    @Test
    public void getAllPosts() {
        when(this.posts.findAll()).thenReturn(Flux.just(
                Post.builder().id(UUID.randomUUID()).title("post one").content("content of post one").build(),
                Post.builder().id(UUID.randomUUID()).title("post two").content("content of post two").build()
        ));
        client.get().uri("/posts")
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.size()").isEqualTo(2);

        verify(this.posts, times(1)).findAll();
        verifyNoMoreInteractions(this.posts);
    }

    @Test
    void testAll() {

        // TODO: Complete this test.

        (new PostController(new PostRepository())).all();
    }



    /**
     * Method under test: {@link PostController#get(UUID)}
     */
    @Test
    void testGet() {

        PostController postController = new PostController(new PostRepository());
        postController.get(UUID.randomUUID());
    }

    /**
     * Method under test: {@link PostController#get(UUID)}
     */
    @Test
    void testGet3() {

        PostRepository postRepository = mock(PostRepository.class);
        when(postRepository.findById((UUID) any())).thenReturn(null);
        PostController postController = new PostController(postRepository);
        assertNull(postController.get(UUID.randomUUID()));
        verify(postRepository).findById((UUID) any());
    }

    /**
     * Method under test: {@link PostController#create(Post)}
     */
    @Test
    void testCreate() {

        PostController postController = new PostController(new PostRepository());
        postController.create(new Post());
    }

    /**
     * Method under test: {@link PostController#create(Post)}
     */
    @Test
    void testCreate4() {

        PostRepository postRepository = mock(PostRepository.class);
        when(postRepository.save((Post) any())).thenReturn((Mono<Post>) mock(Mono.class));
        PostController postController = new PostController(postRepository);
        postController.create(new Post());
        verify(postRepository).save((Post) any());
    }

    /**
     * Method under test: {@link PostController#create(Post)}
     */
    @Test
    void testCreate6() {

        PostController postController = new PostController(new PostRepository());
        Post post = mock(Post.class);
        when(post.getContent()).thenReturn("Not all who wander are lost");
        when(post.getTitle()).thenReturn("Dr");
        postController.create(post);
        verify(post).getContent();
        verify(post).getTitle();
    }
}

