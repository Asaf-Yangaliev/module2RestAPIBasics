package com.epam.esm.dao.tag;

import java.util.List;

public interface TagDAO {
    List<Tag> getAll();
    Tag get(Long id);
    void create(Tag tag);
    void delete(Long id);
}
