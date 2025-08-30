package org.example.bigwebbackend.repositories.tag;

import org.example.bigwebbackend.entites.Tag;
import org.example.bigwebbackend.repositories.MySqlAbstractRepository;

import java.util.List;

public class MySqlTagRepository extends MySqlAbstractRepository implements TagRepository {
    @Override
    public List<Tag> getAllTags() {
        return List.of();
    }

    @Override
    public Tag createTag(Tag tag) {
        return null;
    }
}
