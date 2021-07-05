import core.Line;
import core.Station;
import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Assert;

import java.util.*;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    List<Station> way;
    List<Station> station;
    HashMap<Integer, Line> number2line;
    TreeSet<Station> connections;
    Set<Station> connected;
    private StationIndex stationIndex;


    @Override
    protected void setUp() throws NullPointerException {


        route = new ArrayList<>();
        Line line1 = new Line(1, "First");
        Line line2 = new Line(2, "Second");

        route.add(new Station("Petrovskaya", line1));
        route.add(new Station("Vasilevskaya", line1));

        route.add(new Station("Gorkovskaya", line2));
        route.add(new Station("Octyabrskaya", line2));
    }

    public void testShortestRoute(){

        boolean actual = (route != null && route.size() != 0);
        assert route != null;
        boolean expected = !route.isEmpty();
        assertEquals(expected, actual);

    }
    //========================================================================//

    public void testCalculateDuration(){

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

//========================================================================//

    public void testRouteOnTheLine(){

    double actual = RouteCalculator.calculateDuration(route);
    double expected = 1;
        double expected1 = getExpected1();
        assertEquals(expected,expected1, actual);
    }

    public double getExpected1() {
        return -1;
    }
//======================================================================//

    public void testRouteWithOneConnection(){
        Line line1 = new Line(1, "First");
        boolean actual = route.add(new Station("Petrovskaya", line1));
        boolean expected = route.contains(station);
        assertTrue(expected,actual);

    }

    private TestResult assertTrue(boolean expected, boolean actual) {
        return createResult();
    }
//========================================================================//

    public void testisConnected(){

        Line line1 = new Line(1, "First");
        Line line2 = new Line(2, "Second");
        Station station1 = new Station("Greenway", line1);
        Station station2 = new Station("RedWay", line2);
        Set<Station> actuals = new TreeSet<>();
        boolean actual = actuals.add(station1);
        actuals.add(station2);
        boolean expected = actuals.contains(station2);
        assertEquals(expected, actual);

    }
 //========================================================================//

    public void testRouteViaConnectedLine(){

        Line line1 = new Line(1, "First");
        Line line2 = new Line(2, "Second");
        Station station1 = new Station("Greenway", line1);
        Station station2 = new Station("RedWay", line2);
        List<Station> fromConnected = station1.getLine().getStations();
        List<Station> toConnected = station2.getLine().getStations();
        boolean actual = !fromConnected.isEmpty() && !toConnected.isEmpty();
        boolean expected = station1.getLine().equals(station2.getLine());
        assertEquals(expected,actual);

    }
    //========================================================================//

    public  void  testRouteWithTwoConnections(){

        Line line1 = new Line(1, "First");
        Line line2 = new Line(2, "Second");
        Station station1 = new Station("Greenway", line1);
        Station station2 = new Station("RedWay", line2);
        List<Station> fromLineStations = station1.getLine().getStations();
        List<Station> toLineStations = station2.getLine().getStations();
        boolean actual = fromLineStations.equals(station1) && !toLineStations.isEmpty();
        boolean expected = route.contains(station2);
        assertEquals(expected, actual);
    }


    @Override
    protected void tearDown() throws Exception {

    }
}
