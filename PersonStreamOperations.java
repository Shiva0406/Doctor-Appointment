import java.util.*;
import java.util.stream.Collectors;

public class PersonStreamOperations {

    // Method to get a sorted list of person names in uppercase
    public static Optional<List<String>> getPersonListSortedByNameInUpperCase(List<String> personList) {
        if (personList == null || personList.isEmpty()) {
            return Optional.empty();
        }
        
        List<String> sortedList = personList.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        
        return Optional.of(sortedList);
    }

    // Method to get distinct person names sorted in descending order
    public static Set<String> getDistinctPersonNamesSortedInDescendingOrder(List<String> personList) {
        if (personList == null || personList.isEmpty()) {
            return Collections.emptySet();
        }
        
        return personList.stream()
                .map(String::toUpperCase)  // Optional: If case-insensitive comparison is needed
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new)); // Use LinkedHashSet to preserve order
    }

    // Method to search for a person by name
    public static String searchPerson(List<String> personList, String nameToSearch) {
        if (personList == null || nameToSearch == null || nameToSearch.trim().isEmpty()) {
            return "List or name to search cannot be null";
        }
        
        boolean found = personList.stream()
                .anyMatch(name -> name.equalsIgnoreCase(nameToSearch));
        
        return found ? "Person found" : "Person not found";
    }

    // Method to get person names sorted by length with names longer than five characters
    public static List<String> getPersonListSortedByLengthWithNameLengthGreaterThanFive(List<String> personList) {
        if (personList == null || personList.isEmpty()) {
            return Collections.emptyList();
        }
        
        return personList.stream()
                .filter(name -> name.length() > 5)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    // Method to get the person name with the maximum age
    public static String getPersonByMaxAge(Map<String, Integer> ageMap) {
        if (ageMap == null || ageMap.isEmpty()) {
            return "Give proper input not null";
        }
        
        return ageMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Give proper input not null");
    }

    // Main method to interact with console
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Get person list sorted by name in uppercase");
            System.out.println("2. Get distinct person names sorted in descending order");
            System.out.println("3. Search for a person by name");
            System.out.println("4. Get person names longer than five characters sorted by length");
            System.out.println("5. Get person with maximum age");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter person names separated by commas (e.g., Kamala,Priyanka,Gautham,Moses):");
                    String personInput = scanner.nextLine();
                    List<String> personList = Arrays.asList(personInput.split("\\s*,\\s*"));
                    System.out.println("Sorted names in uppercase: " + getPersonListSortedByNameInUpperCase(personList).orElse(Collections.emptyList()));
                    break;

                case 2:
                    System.out.println("Enter person names separated by commas (e.g., Kamala,Priyanka,Gautham,Moses):");
                    personInput = scanner.nextLine();
                    personList = Arrays.asList(personInput.split("\\s*,\\s*"));
                    System.out.println("Distinct names sorted in descending order: " + getDistinctPersonNamesSortedInDescendingOrder(personList));
                    break;

                case 3:
                    System.out.println("Enter person names separated by commas (e.g., Kamala,Priyanka,Gautham,Moses):");
                    personInput = scanner.nextLine();
                    personList = Arrays.asList(personInput.split("\\s*,\\s*"));
                    System.out.println("Enter the name to search:");
                    String nameToSearch = scanner.nextLine();
                    System.out.println("Search result for '" + nameToSearch + "': " + searchPerson(personList, nameToSearch));
                    break;

                case 4:
                    System.out.println("Enter person names separated by commas (e.g., Kamala,Priyanka,Gautham,Moses):");
                    personInput = scanner.nextLine();
                    personList = Arrays.asList(personInput.split("\\s*,\\s*"));
                    System.out.println("Names longer than five characters, sorted by length: " + getPersonListSortedByLengthWithNameLengthGreaterThanFive(personList));
                    break;

                case 5:
                    System.out.println("Enter ages in the format 'Name=Age' separated by commas (e.g., Gautham=30,Latha=56,Punith=45):");
                    String ageInput = scanner.nextLine();
                    Map<String, Integer> ageMap = Arrays.stream(ageInput.split("\\s*,\\s*"))
                            .map(s -> s.split("="))
                            .collect(Collectors.toMap(
                                    arr -> arr[0],
                                    arr -> Integer.parseInt(arr[1])
                            ));
                    System.out.println("Person with maximum age: " + getPersonByMaxAge(ageMap));
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
}
