package org.example.bigwebbackend.repositories.comment;

import org.example.bigwebbackend.entites.Comment;
import org.example.bigwebbackend.entites.Comment;
import org.example.bigwebbackend.repositories.MySqlAbstractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlCommentRepository extends MySqlAbstractRepository implements CommentRepository {
    @Override
    public List<Comment> getCommentsByEventId(int idEvent) {
        List<Comment> comments = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from comment where event_id = " + idEvent + "order by created_at desc");
            while (resultSet.next()) {
                comments.add(new Comment(
                        resultSet.getInt("id_comment"),
                        resultSet.getInt("id_event"),
                        resultSet.getString("author"),
                        resultSet.getString("text"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getInt("likes"),
                        resultSet.getInt("dislikes")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return comments;
    }

    @Override
    public Comment createComment(Comment comment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            String[] generatedColumns = {"id_comment"};

            preparedStatement = connection.prepareStatement("INSERT INTO comments (id_event, author, text) VALUES(?, ?, ?)", generatedColumns);
            preparedStatement.setInt(1, comment.getEventId());
            preparedStatement.setString(2, comment.getAuthor());
            preparedStatement.setString(3, comment.getText());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                comment.setId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return comment;
    }
}
