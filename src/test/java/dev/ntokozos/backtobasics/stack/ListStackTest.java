package dev.ntokozos.backtobasics.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class ListStackTest {
    @Nested
    class push {
        @Test
        public void shouldInsertFirstElement_givenStackIsEmpty() {
            // Arrange
            ListStack<String> stack = new ListStack<>();

            // Pre-Assert
            assertEquals(0, stack.getSize());

            // Act
            stack.push("hello-stack");

            // Assert
            assertEquals(1, stack.getSize());
        }

        @Test
        public void shouldInsertElementAtTheTop_givenStackIsNotEmpty() {
            // Arrange
            ListStack<String> stack = new ListStack<>("top-item");

            // Pre-Assert
            assertEquals(1, stack.getSize());

            // Act
            stack.push("new-top");

            // Assert
            assertEquals(2, stack.getSize());
        }
    }

    @Nested
    class pop {
        @Test
        public void shouldThrowException_givenStackIsEmpty() {
            // Arrange
            ListStack<String> stack = new ListStack<>();

            // Pre-Assert
            assertEquals(0, stack.getSize());

            // Act
            Executable pop = () -> stack.pop();

            // Assert
            assertThrows(EmptyStackException.class, pop);

        }

        @Test
        public void shouldRetrieveAndRemoveTopElement_givenStackIsNotEmpty() {
            // Arrange
            String top = "top-dawg";
            ListStack<String> stack = new ListStack<>("dawg");
            stack.push(top);

            // Pre-Assert
            assertEquals(2, stack.getSize());

            // Act
            String element = stack.pop();

            // Assert
            assertEquals(top, element);
            assertEquals(1, stack.getSize());
        }
    }

    @Nested
    class peek {
        @Test
        public void shouldThrowException_givenStackIsEmpty() {
            // Arrange
            ListStack<String> stack = new ListStack<>();

            // Pre-Assert
            assertEquals(0, stack.getSize());

            // Act
            Executable peek = () -> stack.peek();

            // Assert
            assertThrows(EmptyStackException.class, peek);

        }

        @Test
        public void shouldRetrieveTopElement_givenStackIsNotEmpty() {
            // Arrange
            String top = "top-dawg";
            ListStack<String> stack = new ListStack<>("dawg");
            stack.push(top);

            // Pre-Assert
            assertEquals(2, stack.getSize());

            // Act
            String element = stack.peek();

            // Assert
            assertEquals(top, element);
            assertEquals(2, stack.getSize());
        }

    }
}
