package dev.ntokozos.dsbasics.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    @Nested
    class insertFront {

        @Test
        public void shouldAddInitialValueToTailAndHead_givenListIsEmpty() {
            // Arrange
            DoublyLinkedList<String> list = new DoublyLinkedList<>();

            // Act
            list.insertFront("Ntokozo");

            // Assert
            assertEquals(list.peekLast(), list.peekFirst());
        }

        @Test
        public void shouldAppendToHead_givenListIsNotEmpty() {
            // Arrange
            DoublyLinkedList<String> list = new DoublyLinkedList<>("Seed");
            String input = "Ntokozo";

            // Act
            list.insertFront(input);

            // Assert
            assertEquals(list.peekFirst(), input);
            assertNotEquals(list.peekLast(), list.peekFirst());
        }
    }

    @Nested
    class insertBack {

        @Test
        public void shouldAddInitialValueToTailAndHead_givenListIsEmpty() {
            // Arrange
            DoublyLinkedList<String> list = new DoublyLinkedList<>();

            // Act
            list.insertBack("Ntokozo");

            // Assert
            assertEquals(list.peekLast(), list.peekFirst());
        }

        @Test
        public void shouldAppendToTail_givenListIsNotEmpty() {
            // Arrange
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            String input = "Ntokozo";

            // Pre-Act
            list.insertBack("Init");

            // Act
            list.insertBack(input);

            // Assert
            assertEquals(list.peekLast(), input);
            assertNotEquals(list.peekLast(), list.peekFirst());
        }
    }

    @Nested
    class removeLast {

        @Test
        public void shouldReturnNull_givenListIsEmpty() {
            // Arrange
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

            // Act
            Integer deleted = list.removeLast();

            // Assert
            assertEquals(null, deleted);
        }

        @Test
        public void shouldRemoveFromTailAndReturnValue_givenListHasSingleItem() {
            // Arrange
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>(2001);

            // Act
            Integer deleted = list.removeLast();

            // Assert
            assertEquals(2001, deleted);
        }

        @Test
        public void shouldRemoveFromTailAndReturnValue_givenListHasManyItems() {
            // Arrange
            Integer expectedDelete = 2002;
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>(2001);
            list.insertFront(2000);
            list.insertBack(expectedDelete);

            // Act
            Integer deleted = list.removeLast();

            // Assert
            assertEquals(expectedDelete, deleted);
        }
    }

    @Nested
    class removeFirst {

        @Test
        public void shouldReturnNull_givenListIsEmpty() {
            // Arrange
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

            // Act
            Integer deleted = list.removeFirst();

            // Assert
            assertEquals(null, deleted);
        }

        @Test
        public void shouldRemoveFromHeadAndReturnValue_givenListHasSingleItem() {
            // Arrange
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>(2001);

            // Act
            Integer deleted = list.removeFirst();

            // Assert
            assertEquals(2001, deleted);
        }

        @Test
        public void shouldRemoveFromHeadAndReturnValue_givenListHasManyItems() {
            // Arrange
            Integer expectedDelete = 2000;
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>(2001);
            list.insertFront(expectedDelete);
            list.insertBack(2002);

            // Act
            Integer deleted = list.removeFirst();

            // Assert
            assertEquals(expectedDelete, deleted);
        }
    }

    @Nested
    class peekFirst {

        @Test
        public void shouldReturnNull_givenListIsEmpty() {
            // Arrange
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

            // Act
            Integer first = list.peekFirst();

            // Assert
            assertNull(first);
        }

        @Test
        public void shouldReturnFirstElement_givenListHasSingleItem() {
            // Arrange
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>(1000);

            // Act
            Integer first = list.peekFirst();

            // Assert
            assertEquals(1000, first);
        }

        @Test
        public void shouldFirstElement_givenListHasManyItems() {
            // Arrange
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>(1000);
            list.insertBack(1001);
            list.insertBack(1002);
            list.insertBack(1003);

            // Act
            Integer first = list.peekFirst();

            // Assert
            assertEquals(1000, first);
        }
    }

    @Nested
    class peekLast {

        @Test
        public void shouldReturnNull_givenListIsEmpty() {
            // Arrange
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

            // Act
            Integer last = list.peekLast();

            // Assert
            assertNull(last);
        }

        @Test
        public void shouldLastElement_givenListHasItems() {
            // Arrange
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>(1000);

            // Act
            int last = list.peekLast();

            // Assert
            assertEquals(1000, last);
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
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>(2000);

            // Act
            Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> list.peekAt(-2));

            // Assert
            assertEquals("Invalid index", exception.getMessage());
        }

        @Test
        public void shouldThrowException_givenOutOfBoundIndex() {
            // Arrange
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>(2000);
            list.insertBack(2001);

            // Act
            Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> list.peekAt(2));

            // Assert
            assertEquals("Invalid index", exception.getMessage());
        }

        @Test
        public void shouldReturnElement_givenValidIndex() {
            // Arrange
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>(2000);
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
