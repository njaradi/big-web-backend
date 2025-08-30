package org.example.bigwebbackend.services;

import org.example.bigwebbackend.entites.Comment;
import org.example.bigwebbackend.repositories.comment.CommentRepository;

import javax.inject.Inject;
import java.util.List;

public class CommentService {
    @Inject
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByEventId(int idEvent) {return this.commentRepository.getCommentsByEventId(idEvent);}
    public Comment createComment(Comment comment) {return commentRepository.createComment(comment);}
}
