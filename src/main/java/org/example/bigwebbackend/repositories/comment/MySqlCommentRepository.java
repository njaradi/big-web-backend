package org.example.bigwebbackend.repositories.comment;

import org.example.bigwebbackend.entites.Comment;
import org.example.bigwebbackend.repositories.MySqlAbstractRepository;

import java.util.List;

public class MySqlCommentRepository extends MySqlAbstractRepository implements CommentRepository {
    @Override
    public List<Comment> getCommentsByEventId(int idEvent) {
        return List.of();
    }

    @Override
    public Comment createComment(Comment comment) {
        return null;
    }
}
