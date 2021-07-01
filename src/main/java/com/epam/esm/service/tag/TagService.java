package com.epam.esm.service.tag;

import com.epam.esm.dao.tag.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAll();
    Tag get(Long id);
    void create(Tag tag);
    void delete(Long id);
}
