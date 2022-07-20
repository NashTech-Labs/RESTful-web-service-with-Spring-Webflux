package com.knoldus.RESTful.web.service.with.Spring.Webflux.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class PostTest {
    /**
     * Method under test: {@link Post#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Post()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Post#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Post post = new Post();
        assertTrue(post.canEqual(new Post()));
    }

    /**
     * Methods under test:
     */
    @Test
    void testConstructor() {
        Post actualPost = new Post();
        actualPost.setContent("Follow healthy diet");
        UUID randomUUIDResult = UUID.randomUUID();
        actualPost.setId(randomUUIDResult);
        actualPost.setTitle("Prescription");
        actualPost.toString();
        assertEquals("Follow healthy diet", actualPost.getContent());
        assertSame(randomUUIDResult, actualPost.getId());
        assertEquals("Prescription", actualPost.getTitle());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Post#Post(UUID, String, String)}
     *   <li>{@link Post#setContent(String)}
     *   <li>{@link Post#setId(UUID)}
     *   <li>{@link Post#setTitle(String)}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Post actualPost = new Post(UUID.randomUUID(), "Dr", "Homi Jangeer Bhabha");
        actualPost.setContent("Just Follow Your Dream");
        UUID randomUUIDResult = UUID.randomUUID();
        actualPost.setId(randomUUIDResult);
        actualPost.setTitle("Dr");
        actualPost.toString();
        assertEquals("Just Follow Your Dream", actualPost.getContent());
        assertSame(randomUUIDResult, actualPost.getId());
        assertEquals("Dr", actualPost.getTitle());
    }

    /**
     * Method under test: {@link Post#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new Post(), null);
        assertNotEquals(new Post(), "Different type to Post");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Post#equals(Object)}
     *   <li>{@link Post#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        Post post = new Post();
        assertEquals(post, post);
        int expectedHashCodeResult = post.hashCode();
        assertEquals(expectedHashCodeResult, post.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Post#equals(Object)}
     *   <li>{@link Post#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Post post = new Post();
        Post post1 = new Post();
        assertEquals(post, post1);
        int expectedHashCodeResult = post.hashCode();
        assertEquals(expectedHashCodeResult, post1.hashCode());
    }

    /**
     * Method under test: {@link Post#equals(Object)}
     */
    @Test
    void testEquals4() {
        Post post = new Post(UUID.randomUUID(), "Fever", "Aspirin 450mg");
        assertNotEquals(post, new Post());
    }

    /**
     * Method under test: {@link Post#equals(Object)}
     */
    @Test
    void testEquals5() {
        Post post = new Post();
        assertNotEquals(post, new Post(UUID.randomUUID(), "Dr", "Paracetamol Calli pol-250mg"));
    }

    /**
     * Method under test: {@link Post#equals(Object)}
     */
    @Test
    void testEquals6() {
        Post post = new Post();
        post.setTitle("Mr.");
        assertNotEquals(post, new Post());
    }

    /**
     * Method under test: {@link Post#equals(Object)}
     */
    @Test
    void testEquals7() {
        Post post = new Post();
        post.setContent("Honesty is the Best Policy");
        assertNotEquals(post, new Post());
    }

    /**
     * Method under test: {@link Post#equals(Object)}
     */
    @Test
    void testEquals8() {
        Post post = new Post();

        Post post1 = new Post();
        post1.setTitle("Dr");
        assertNotEquals(post, post1);
    }

    /**
     * Method under test: {@link Post#equals(Object)}
     */
    @Test
    void testEquals9() {
        Post post = new Post();

        Post post1 = new Post();
        post1.setContent("Keep Calm");
        assertNotEquals(post, post1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Post#equals(Object)}
     *   <li>{@link Post#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        Post post = new Post();
        post.setTitle("Mr Shashi");

        Post post1 = new Post();
        post1.setTitle("Mr Shashi");
        assertEquals(post, post1);
        int expectedHashCodeResult = post.hashCode();
        assertEquals(expectedHashCodeResult, post1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Post#equals(Object)}
     *   <li>{@link Post#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        Post post = new Post();
        post.setContent("Something is better than Nothing");

        Post post1 = new Post();
        post1.setContent("Something is better than Nothing");
        assertEquals(post, post1);
        int expectedHashCodeResult = post.hashCode();
        assertEquals(expectedHashCodeResult, post1.hashCode());
    }
}

