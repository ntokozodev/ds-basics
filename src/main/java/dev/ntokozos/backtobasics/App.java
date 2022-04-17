package dev.ntokozos.backtobasics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

import dev.ntokozos.backtobasics.list.DoublyLinkedList;
import dev.ntokozos.backtobasics.list.SinglyLinkedList;

/**
 * Hello good people!
 *
 */
public class App {
    public static void main(String[] args) {
        int n = 19;
        System.out.println("First digit:" + n / 10);
        System.out.println("Second digit:" + n % 10);
        System.out.println("Century:" + 1905 / 100);
        System.out.println("Century:" + 1700 / 100);

    }

    static void countCharacterOccurrences() {
        String string = "Ntokozo";

        HashMap<Character, Integer> occurrences = characterCounts(string);

        System.out.print("Occurrences: ");
        System.out.println(occurrences);

    }

    static HashMap<Character, Integer> characterCounts(String string) {
        HashMap<Character, Integer> occurrences = new HashMap<>();

        int[] chars = new int[256];
        for (int i = 0; i < string.length(); i++) {
            occurrences.put(string.charAt(i), ++chars[string.charAt(i)]);
        }

        return occurrences;
    }

    // Hello person
    // stack: [{
    static void removeDuplicate(char[] chars) {
        HashSet<Character> set = new LinkedHashSet<>(chars.length - 1);

        for (char c : chars) {
            set.add(c);
        }

        System.out.print("None dup?: " + set.toString());

        // Print content of the set
        for (char x : set) {
            System.out.print("None: " + x + " ");
        }

    }

    static void createSinglyLinkedList() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>(null);

        list.insertFront("Ntokozo");
        list.insertBack("Nicholas");
        list.insertBack("Shagala");

        list.printPrimitiveDataTypes();
    }

    static void createDoublyLinkedList() {
        DoublyLinkedList<String> doubleList = new DoublyLinkedList<>(null);

        doubleList.insertFront("Ntokozo");
        doubleList.insertBack("Nicholas");
        doubleList.insertBack("Gabela");

        doubleList.printReverse();
    }
}
