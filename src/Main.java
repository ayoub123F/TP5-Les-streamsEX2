import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Créer une liste de type ArrayList d'employés
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Finance", 5000));
        employees.add(new Employee("Alice", "HR", 6000));
        employees.add(new Employee("Bob", "IT", 5500));
        employees.add(new Employee("Emma", "Marketing", 5200));

        // 1. Utiliser mapToDouble et sum pour calculer la somme totale des salaires de tous les employés
        double totalSalaries = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Somme totale des salaires : " + totalSalaries);

        // 2. Utiliser sorted pour trier la liste des employés par ordre alphabétique du nom
        // 2. Utiliser sorted pour trier la liste des employés par ordre alphabétique du nom
        employees.sort(Comparator.comparing(Employee::getName));

        System.out.println("Liste des employés triés par nom : " + employees);

        // 3. Utiliser min pour trouver l'employé avec le salaire le plus bas
        Optional<Employee> minSalaryEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getSalary));
        minSalaryEmployee.ifPresent(employee -> System.out.println("Employé avec le salaire le plus bas : " + employee.getName()));

        // 4. Utiliser filter pour obtenir la liste des employés ayant un salaire supérieur à une valeur donnée
        double thresholdSalary = 5500;
        List<Employee> highSalaryEmployees = employees.stream()
                .filter(employee -> employee.getSalary() > thresholdSalary)
                .collect(Collectors.toList());
        System.out.println("Employés avec un salaire supérieur à " + thresholdSalary + " : " + highSalaryEmployees);

        // 5. Utiliser reduce pour trouver l'employé avec le salaire le plus élevé dans l'ensemble de l'entreprise
        Optional<Employee> maxSalaryEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        maxSalaryEmployee.ifPresent(employee -> System.out.println("Employé avec le salaire le plus élevé : " + employee.getName()));

        // 6. Utiliser reduce pour concaténer les noms de tous les employés
        String concatenatedNames = employees.stream()
                .map(Employee::getName)
                .reduce("", (name1, name2) -> name1 + ", " + name2);
        System.out.println("Noms de tous les employés : " + concatenatedNames);
    }
}
