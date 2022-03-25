package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    @Test
    public void whenAddRoleAndFind() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "administrator"));
        String expected = "administrator";
        assertThat(store.findById("1").getRole(), is(expected));
    }

    @Test
    public void whenReplaced() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "administrator"));
        store.replace("1", new Role("1", "superuser"));
        String expected = "superuser";
        assertThat(store.findById("1").getRole(), is(expected));
    }

    @Test
    public void whenDidNotReplaced() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "administrator"));
        assertFalse(store.replace("2", new Role("2", "superuser")));
    }

    @Test
    public void whenDelete() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "administrator"));
        store.add(new Role("2", "backup user"));
        store.delete("2");
        assertNull(store.findById("2"));
    }
}
