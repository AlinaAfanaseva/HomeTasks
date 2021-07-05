import core.Line;
import core.Station;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class StationIndex
{
    private static final Logger logger = LogManager.getLogger(Station.class.getName());
    public Set<Station> getConnectedStations;
    HashMap<Integer, Line> number2line;
    TreeSet<Station> stations;
    TreeMap<Station, TreeSet<Station>> connections;

//    public boolean doIt(){
//        logger.entry();
//        logger.error("Did it again!");
//        return logger.exit(false);
//    }

    public StationIndex()
    {
        number2line = new HashMap<>();
        stations = new TreeSet<>();
        connections = new TreeMap<>();
        logger.info("Index gotten!");
    }

    public void addStation(Station station)
    {
        stations.add(station);
        logger.info("Station added!");
    }

    public void addLine(Line line)
    {
        number2line.put(line.getNumber(), line);
        logger.info("Line added!");
    }

    public void addConnection(List<Station> stations)
    {
        for(Station station : stations)
        {
            if(!connections.containsKey(station)) {
                connections.put(station, new TreeSet<>());
            }
            TreeSet<Station> connectedStations = connections.get(station);
            connectedStations.addAll(stations.stream()
                .filter(s -> !s.equals(station)).collect(Collectors.toList()));
        }
        logger.info("Connection");
    }

    public Line getLine(int number)
    {
        logger.info("Line gotten!");
        return number2line.get(number);
    }

    public Station getStation(String name)
    {
        for(Station station : stations)
        {
            if(station.getName().equalsIgnoreCase(name)) {
                logger.info("Station gotten!");
                return station;
            }
        }
        logger.error("We can not get a Station");
        return null;
    }

    public Station getStation(String name, int lineNumber)
    {
        Station query = new Station(name, getLine(lineNumber));
        Station station = stations.ceiling(query);
        return station.equals(query) ? station : null;
    }

    public Set<Station> getConnectedStations(Station station)
    {
        if(connections.containsKey(station)) {
            return connections.get(station);
        }
        logger.info("Well Done! Got station!");
        return new TreeSet<>();
    }
}
