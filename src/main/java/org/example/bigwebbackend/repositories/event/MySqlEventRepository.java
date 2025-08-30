package org.example.bigwebbackend.repositories.event;

import org.example.bigwebbackend.entites.Category;
import org.example.bigwebbackend.entites.Event;
import org.example.bigwebbackend.entites.Tag;
import org.example.bigwebbackend.repositories.MySqlAbstractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlEventRepository extends MySqlAbstractRepository implements EventRepository {
    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from events order by created_at desc");
            while (resultSet.next()) {
                events.add(new Event(
                        resultSet.getInt("id_event"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("event_datetime"),
                        resultSet.getString("location"),
                        resultSet.getInt("id_user"),
                        resultSet.getInt("id_category"),
                        resultSet.getInt("views"),
                        resultSet.getInt("max_capacity")));
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
        Event event = null;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from events where id_event=" + id);
            if (resultSet.next()) {
                event = new Event(
                        resultSet.getInt("id_event"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("event_datetime"),
                        resultSet.getString("location"),
                        resultSet.getInt("id_user"),
                        resultSet.getInt("id_category"),
                        resultSet.getInt("views"),
                        resultSet.getInt("max_capacity"));
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return event;
    }

    @Override
    public Event createEvent(Event event) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            String[] generatedColumns = {"id_event"};

            preparedStatement = connection.prepareStatement("INSERT INTO events (title, description, event_datetime, location, id_user, id_category, max_capacity) VALUES(?, ?, ?,?,?,?,?)", generatedColumns);
            preparedStatement.setString(1, event.getTitle());
            preparedStatement.setString(2, event.getDescription());
            preparedStatement.setTimestamp(3, event.getDateTimeEvent());
            preparedStatement.setString(4, event.getLocation());
            preparedStatement.setInt(5, event.getId_user());
            preparedStatement.setInt(6, event.getId_category());
            preparedStatement.setInt(7, event.getMaxCapacity());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                event.setId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return event;
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
        List<Event> events = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from events where event_datetime > now() order by views desc limit 10");
            while (resultSet.next()) {
                events.add(new Event(
                        resultSet.getInt("id_event"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("event_datetime"),
                        resultSet.getString("location"),
                        resultSet.getInt("id_user"),
                        resultSet.getInt("id_category"),
                        resultSet.getInt("views"),
                        resultSet.getInt("max_capacity")));
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
    public List<Event> getEventsByCategory(Category category) {
        List<Event> events = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from events where id_category ="+category.getId_category()+" order by created_at desc");
            while (resultSet.next()) {
                events.add(new Event(
                        resultSet.getInt("id_event"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("event_datetime"),
                        resultSet.getString("location"),
                        resultSet.getInt("id_user"),
                        resultSet.getInt("id_category"),
                        resultSet.getInt("views"),
                        resultSet.getInt("max_capacity")));
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
    public List<Event> getEventsByTag(Tag tag) {
        List<Event> events = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from events e " +
                    "join event_tags et on e.id_event = et.id_event " +
                    "where et.id_tag = " + tag.getId_tag() +
                    " order by created_at desc");
            while (resultSet.next()) {
                events.add(new Event(
                        resultSet.getInt("id_event"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("event_datetime"),
                        resultSet.getString("location"),
                        resultSet.getInt("id_user"),
                        resultSet.getInt("id_category"),
                        resultSet.getInt("views"),
                        resultSet.getInt("max_capacity")));
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
    public List<Event> getTop3LikedEvents() {
        List<Event> events = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = this.newConnection();

            statement = connection.createStatement();//todo: ja nemam likes dislikes nigde
            resultSet = statement.executeQuery("select * from events order by views desc limit 3");
            while (resultSet.next()) {
                events.add(new Event(
                        resultSet.getInt("id_event"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("event_datetime"),
                        resultSet.getString("location"),
                        resultSet.getInt("id_user"),
                        resultSet.getInt("id_category"),
                        resultSet.getInt("views"),
                        resultSet.getInt("max_capacity")));
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
}
