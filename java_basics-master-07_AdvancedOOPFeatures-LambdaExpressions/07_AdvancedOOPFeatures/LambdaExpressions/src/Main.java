import com.skillbox.airport.Airport;
        import com.skillbox.airport.Terminal;

        import java.lang.reflect.Type;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.text.SimpleDateFormat;
        import java.time.LocalDateTime;
        import java.time.ZoneId;
        import java.time.format.DateTimeFormatter;
        import java.util.*;

        import static com.skillbox.airport.Flight.Type.DEPARTURE;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";
    private Type type;


    public static void main(String[] args)
    {
        ArrayList<Employee> staff = loadStaffFromFile();
        Date date = new Date(2017);
        Calendar calendar = new GregorianCalendar();
        calendar.set(2017,Calendar.JANUARY,0);
        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime twoHoursLater = nowDate.plusHours(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
//        Collections.sort(staff, (o1, o2) -> o1.getName().compareTo(o2.getName()));
//        Collections.sort(staff, (o1, o2) -> o1.getSalary().compareTo(o2.getSalary()));
        staff.sort(Comparator.comparing(Employee::getSalary)
                .thenComparing(Comparator.comparing(Employee::getName)));
        System.out.println(staff);


        System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");

        staff.stream().filter(employee -> employee.getWorkStartYear() == 2017 ).max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");

        for (Employee employee : staff) {
            System.out.println(employee);
        }
        System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");

        Airport.getInstance().getAllAircrafts().stream().sorted(Comparator.comparing(aircraft -> date)).limit(6).forEach(System.out::println);
        System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
        Airport airport = Airport.getInstance();
        System.out.println("Local time: " + nowDate.getHour() + ":" + nowDate.getMinute());

        airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(flight -> {
                    LocalDateTime dt = toLocalDateTime(flight.getDate());
                    return (flight.getType().equals(DEPARTURE))
                            && dt.isAfter(nowDate)
                            && dt.isBefore(twoHoursLater);
                }).distinct()

                .forEach(flight -> {
                    LocalDateTime dt = toLocalDateTime(flight.getDate());
                    System.out.println(
                            dt.format(formatter)
                                    + "\t"
                                    + flight.getAircraft().getModel()
                    );
                });


    }


    private static LocalDateTime toLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }


}