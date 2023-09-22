import java.util.*;

public class PhoneBook{

    public static void main(String[] args) {
        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иван", "1234567890");
        addContact(phoneBook, "Аля", "9876543210");
        addContact(phoneBook, "Иван", "9876543210");
        addContact(phoneBook, "Иван", "9876543210");
        addContact(phoneBook, "Николай", "9876543210");
        addContact(phoneBook, "Валентин", "5432109876");

        printPhoneBook(phoneBook);
    }

    public static void addContact(HashMap<String, HashSet<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public static void printPhoneBook(HashMap<String, HashSet<String>> phoneBook) {
        HashMap<Integer, HashSet<String>> sortedPhoneBook = new HashMap<>();

        for (String name : phoneBook.keySet()) {
            int numOfPhoneNumbers = phoneBook.get(name).size();

            if (sortedPhoneBook.containsKey(numOfPhoneNumbers)) {
                sortedPhoneBook.get(numOfPhoneNumbers).add(name);
            } else {
                HashSet<String> names = new HashSet<>();
                names.add(name);
                sortedPhoneBook.put(numOfPhoneNumbers, names);
            }
        }

        List<Integer> sortedKeys = new ArrayList<>(sortedPhoneBook.keySet());
        Collections.sort(sortedKeys, Collections.reverseOrder());

        for (int key : sortedKeys) {
            HashSet<String> names = sortedPhoneBook.get(key);
            for (String name : names) {
               System.out.println(name + ": " + key + " телефонных номера(ов):" + phoneBook.get(name) );

            }
        }
    }
}