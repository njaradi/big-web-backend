package org.example.bigwebbackend.repositories.tag;

import org.example.bigwebbackend.entites.Comment;
import org.example.bigwebbackend.entites.Event;
import org.example.bigwebbackend.entites.Tag;

import java.util.List;

public interface TagRepository {
    public List<Tag> getAllTags();
    public Tag createTag(Tag tag);
}
