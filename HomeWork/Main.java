import java.util.*;

public class Main {
    static List<Laptop> laptops = Arrays.asList(
            new Laptop(8, 256, "Windows", "Black"),
            new Laptop(16, 512, "MacOS", "Silver"),
            new Laptop(12, 1024, "Linux", "Gray")
    );

    static void filterLaptops(List<Laptop> laptops, Map<String, Object> criteria) {
        List<Laptop> filteredLaptops = new ArrayList<>();

        for (Laptop laptop : laptops) {
            boolean match = true;
            for (Map.Entry<String, Object> entry : criteria.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    switch (fieldName) {
                        case "ram":
                            Integer minRam = (Integer) fieldValue;
                            if (!Objects.equals(minRam, laptop.getRam())) {
                                match = false;
                                break;
                            }
                            break;
                        case "hddSize":
                            Long minHddSize = (Long) fieldValue;
                            if (!Objects.equals(minHddSize, laptop.getHddSize())) {
                                match = false;
                                break;
                            }
                            break;
                        case "os":
                            String minOs = (String) fieldValue;
                            if (!Objects.equals(minOs, laptop.getOs())) {
                                match = false;
                                break;
                            }
                            break;
                        case "color":
                            String minColor = (String) fieldValue;
                            if (!Objects.equals(minColor, laptop.getColor())) {
                                match = false;
                                break;
                            }
                            break;
                    }
                } catch (ClassCastException e) {
                    System.out.println("Invalid data type for criterion");
                }
            }

            if (match) {
                filteredLaptops.add(laptop);
            }
        }

        System.out.println("Filtered laptops:");
        for (Laptop laptop : filteredLaptops) {
            System.out.printf("%d RAM, %d GB HDD, %s OS, %s Color\n", laptop.getRam(), laptop.getHddSize() / 1024, laptop.getOs(), laptop.getColor());
        }
    }

    static Map<String, Object> getFilterCriteria() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> criteria = new HashMap<>();

        while (true) {
            System.out.println("Enter a number corresponding to the required criterion:");
            System.out.println("1 - RAM");
            System.out.println("2 - Hard Disk Size");
            System.out.println("3 - Operating System");
            System.out.println("4 - Color");
            System.out.println("5 - Exit");
            int selection = scanner.nextInt();

            if (selection == 5) {
                break;
            } else if (selection >= 1 && selection <= 4) {
                System.out.print("Enter minimum value for ");
                switch (selection) {
                    case 1:
                        System.out.println("RAM:");
                        int minRam = scanner.nextInt();
                        criteria.put("ram", minRam);
                        break;
                    case 2:
                        System.out.println("Hard Disk Size:");
                        long minHddSize = scanner.nextLong();
                        criteria.put("hddSize", minHddSize);
                        break;
                    case 3:
                        System.out.println("Operating System:");
                        String minOs = scanner.next();
                        criteria.put("os", minOs);
                        break;
                    case 4:
                        System.out.println("Color:");
                        String minColor = scanner.next();
                        criteria.put("color", minColor);
                        break;
                }
            } else {
                System.out.println("Invalid option selected.");
            }
        }

        return criteria;
    }

    public static void main(String[] args) {
        Map<String, Object> criteria = getFilterCriteria();
        filterLaptops(laptops, criteria);
    }
}