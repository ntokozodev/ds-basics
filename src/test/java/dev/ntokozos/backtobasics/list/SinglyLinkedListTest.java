package dev.ntokozos.backtobasics.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {
    @Nested
    class appendFront {
        @Test
        public void shouldAddInitialValueToTailAndHead_givenListIsEmpty() {
            // Arrange
            SinglyLinkedList<String> list = new SinglyLinkedList<>(null);

            // Act
            list.insertFront("Ntokozo");

            // Assert
            assertEquals(list.peekFirst(), list.peekLast());
        }

        @Test
        public void shouldAppendToHead_givenListIsNotEmpty() {
            // Arrange
            SinglyLinkedList<String> list = new SinglyLinkedList<>("Seed");
            String input = "Ntokozo";

            // Act
            list.insertFront(input);

            // Assert
            assertEquals(input, list.peekFirst());
            assertNotEquals(list.peekLast(), list.peekFirst());
        }
    }

    @Nested
    class appendBack {
        @Test
        public void shouldAddInitialValueToTailAndHead_givenListIsEmpty() {
            // Arrange
            SinglyLinkedList<String> list = new SinglyLinkedList<>(null);

            // Act
            list.insertBack("Ntokozo");

            // Assert
            assertEquals(list.peekLast(), list.peekFirst());
        }

        @Test
        public void shouldAppendToTail_givenListIsNotEmpty() {
            // Arrange
            SinglyLinkedList<String> list = new SinglyLinkedList<>(null);
            String input = "Ntokozo";

            // Pre-Act
            list.insertBack("Init");

            // Act
            list.insertBack(input);

            // Assert
            assertEquals(input, list.peekLast());
            assertNotEquals(list.peekLast(), list.peekFirst());
        }
    }

    @Nested
    class removeFront {
        @Test
        public void shouldReturnNull_givenListIsEmpty() {
            // Arrange
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(null);

            // Act
            Integer deleted = list.removeFirst();

            // Assert
            assertEquals(null, deleted);
        }

        @Test
        public void shouldRemoveFromHeadAndReturnValue_givenListHasSingleItem() {
            // Arrange
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2001);

            // Act
            Integer deleted = list.removeFirst();

            // Assert
            assertEquals(2001, deleted);
        }

        @Test
        public void shouldRemoveFromHeadAndReturnValue_givenListHasManyItems() {
            // Arrange
            Integer expectedDelete = 2000;
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2001);
            list.insertFront(expectedDelete);
            list.insertBack(2002);

            // Act
            Integer deleted = list.removeFirst();

            // Assert
            assertEquals(expectedDelete, deleted);
        }
    }

    @Nested
    class removeBack {
        @Test
        public void shouldReturnNull_givenListHasIsEmpty() {
            // Arrange
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(null);

            // Act
            Integer deleted = list.removeLast();

            // Assert
            assertEquals(null, deleted);
        }

        @Test
        public void shouldRemoveFromTailAndReturnValue_givenListHasSingleItem() {
            // Arrange
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2001);

            // Act
            Integer deleted = list.removeLast();

            // Assert
            assertEquals(2001, deleted);
        }

        @Test
        public void shouldRemoveFromTailAndReturnValue_givenListHasManyItems() {
            // Arrange
            Integer expectedDelete = 2002;
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2001);
            list.insertFront(2000);
            list.insertBack(expectedDelete);

            // Act
            Integer deleted = list.removeLast();

            // Assert
            assertEquals(expectedDelete, deleted);
        }
    }

    @Nested
    class peekFirst {
        @Test
        public void shouldReturnNull_givenListIsEmpty() {
            // Arrange
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

            // Act
            Integer first = list.peekFirst();

            // Assert
            assertNull(first);
        }

        @Test
        public void shouldReturnFirstElement_givenListHasSingleItem() {
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2000);

            // Act
            Integer first = list.peekFirst();

            // Assert
            assertEquals(2000, first);
        }

        @Test
        public void shouldReturnFirstElement_givenListHasManyItems() {
            // Arrange
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2000);
            list.insertFront(1999);
            list.insertBack(2001);
            list.insertBack(2002);

            // Act
            Integer first = list.peekFirst();

            // Assert
            assertEquals(1999, first);
        }
    }

    @Nested
    class peekLast {
        @Test
        public void shouldReturnNull_givenListIsEmpty() {
            // Arrange
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

            // Act
            Integer last = list.peekLast();

            // Assert
            assertNull(last);
        }

        @Test
        public void shouldReturnLastElement_givenListHasSingleItem() {
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2000);

            // Act
            Integer last = list.peekLast();

            // Assert
            assertEquals(2000, last);
        }

        @Test
        public void shouldReturnLastElement_givenListHasManyItems() {
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2000);
            list.insertBack(2001);
            list.insertBack(2002);

            // Act
            Integer last = list.peekLast();

            // Assert
            assertEquals(2002, last);
        }
    }

    @Nested
    class peekAt {
        @Test
        public void shouldReturnNull_givenListIsEmpty() {
            // Arrange
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

            // Act
            Integer element = list.peekAt(0);

            // Assert
            assertNull(element);
        }

        @Test
        public void shouldThrowException_givenNegativeIndex() {
            // Arrange
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2000);

            // Act
            Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> list.peekAt(-2));

            // Assert
            assertEquals("Invalid index", exception.getMessage());
        }

        @Test
        public void shouldThrowException_givenOutOfBoundIndex() {
            // Arrange
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2000);
            list.insertBack(2001);

            // Act
            Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> list.peekAt(2));

            // Assert
            assertEquals("Invalid index", exception.getMessage());
        }

        @Test
        public void shouldReturnElement_givenValidIndex() {
            // Arrange
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>(2000);
            list.insertBack(2001);
            list.insertBack(2002);
            list.insertBack(2003);
            list.insertBack(2004);

            // Act
            Integer element = list.peekAt(3);

            // Assert
            assertEquals(2003, element);
        }
    }

}