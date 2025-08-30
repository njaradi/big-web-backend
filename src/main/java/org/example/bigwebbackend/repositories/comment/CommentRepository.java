package org.example.bigwebbackend.repositories.comment;

import org.example.bigwebbackend.entites.Comment;
import org.example.bigwebbackend.entites.Event;

import java.util.List;

public interface CommentRepository {
    public List<Comment> getCommentsByEventId(int idEvent);
    public Comment createComment(Comment comment);
}
