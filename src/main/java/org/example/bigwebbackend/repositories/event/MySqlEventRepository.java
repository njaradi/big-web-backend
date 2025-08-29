package org.example.bigwebbackend.repositories.event;

import org.example.bigwebbackend.entites.Category;
import org.example.bigwebbackend.entites.Event;
import org.example.bigwebbackend.entites.Tag;
import org.example.bigwebbackend.repositories.MySqlAbstractRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlEventRepository extends MySqlAbstractRepository implements EventRepository {
    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<Event>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from events");
            while (resultSet.next()) {
                events.add(new Event(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("timeCreated"),
                        resultSet.getTimestamp("dateTimeEvent"),
                        resultSet.getString("location"),
                        resultSet.getInt("idAuthor"),
                        resultSet.getInt("idCategory"),
                        resultSet.getInt("maxCapacity")));
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return events;
    }

    @Override
    public Event getEventById(int id) {
        return null;
    }

    @Override
    public Event createEvent(Event event) {
        return null;
    }

    @Override
    public Event editEvent(Event event) {
        return null;
    }

    @Override
    public void deleteEvent(int id) {

    }

    @Override
    public List<Event> get10MostViewedEvents() {
        return List.of();
    }

    @Override
    public List<Event> getEventsByCategory(Category category) {
        return List.of();
    }

    @Override
    public List<Event> getEventsByTag(Tag tag) {
        return List.of();
    }

    @Override
    public List<Event> getTop3LikedEvents() {
        return List.of();
    }
}
