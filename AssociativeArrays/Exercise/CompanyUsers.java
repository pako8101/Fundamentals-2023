package ProgrammingFundamentalsWithJava2023.AssociativeArrays.Exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> company = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] companyArr = input.split("->");
            String companyName = companyArr[0];
            String employeeId = companyArr[1];
            company.putIfAbsent(companyName, new ArrayList<>());
            List<String> employees = company.get(companyName);
            if (!employees.contains(employeeId)) {
                employees.add(employeeId);
                //company.get(companyName).add(employeeId);
            }

                input = scanner.nextLine();
            }
            for (Map.Entry<String,List<String>> entry: company.entrySet()) {
                System.out.println(entry.getKey());
                for (String id : entry.getValue()) {
                    System.out.println("--" + id);
                }
            }
        }
    }
