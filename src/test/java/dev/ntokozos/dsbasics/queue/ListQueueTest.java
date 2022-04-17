package dev.ntokozos.dsbasics.queue;

import dev.ntokozos.dsbasics.queue.ListQueue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class ListQueueTest {
    @Nested
    class add {
        @Test
        public void shouldInsertFirstElement_givenQueueIsEmpty() {
            // Arrange
            ListQueue<String> queue = new ListQueue<>();

            // Pre-Assert
            assertEquals(0, queue.getSize());

            // Act
            queue.add("first-element");

            // Assert
            assertEquals(1, queue.getSize());
        }

        @Test
        public void shouldInsertElementAtTheEnd_givenQueueIsNotEmpty() {
            // Arrange
            ListQueue<String> queue = new ListQueue<>("first-element");

            // Pre-Assert
            assertEquals(1, queue.getSize());

            // Act
            queue.add("last-element");

            // Assert
            assertEquals(2, queue.getSize());
        }
    }

    @Nested
    class remove {
        @Test
        public void shouldThrowNoSuchElementException_givenQueueIsEmpty() {
            // Arrange
            ListQueue<String> queue = new ListQueue<>();

            // Pre-Assert
            assertEquals(0, queue.getSize());

            // Act
            Executable remove = () -> queue.remove();

            // Assert
            assertThrows(NoSuchElementException.class, remove);
        }

        @Test
        public void shouldRetrieveAndRemoveFirstElement_givenQueueIsNotEmpty() {
            // Arrange
            String first = "first-dawg";
            ListQueue<String> queue = new ListQueue<>(first);
            queue.add("second-last");

            // Pre-Assert
            assertEquals(2, queue.getSize());

            // Act
            String element = queue.remove();

            // Assert
            assertEquals(first, element);
            assertEquals(1, queue.getSize());
        }
    }

    @Nested
    class peek {
        @Test
        public void shouldThrowNoSuchElementException_givenQueueIsEmpty() {
            // Arrange
            ListQueue<String> queue = new ListQueue<>();

            // Pre-Assert
            assertEquals(0, queue.getSize());

            // Act
            Executable peek = () -> queue.peek();

            // Assert
            assertThrows(NoSuchElementException.class, peek);
        }

        @Test
        public void shouldRetrieveFirstElement_givenQueueIsNotEmpty() {
            // Arrange
            String first = "first-dawg";
            ListQueue<String> queue = new ListQueue<>(first);
            queue.add("second-last");

            // Pre-Assert
            assertEquals(2, queue.getSize());

            // Act
            String element = queue.peek();

            // Assert
            assertEquals(first, element);
            assertEquals(2, queue.getSize());
        }
    }
}
