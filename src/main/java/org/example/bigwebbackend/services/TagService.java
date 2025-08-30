package org.example.bigwebbackend.services;

import org.example.bigwebbackend.entites.Tag;
import org.example.bigwebbackend.repositories.tag.TagRepository;

import javax.inject.Inject;
import java.util.List;

public class TagService {
    @Inject
    private TagRepository tagRepository;

    public List<Tag> getAllTags() {return this.tagRepository.getAllTags();}
    public Tag createTag(Tag tag) {return tagRepository.createTag(tag);}
}
