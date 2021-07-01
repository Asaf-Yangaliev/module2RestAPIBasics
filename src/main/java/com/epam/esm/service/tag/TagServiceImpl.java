package com.epam.esm.service.tag;

import com.epam.esm.dao.tag.Tag;
import com.epam.esm.dao.tag.TagDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagDAO tagDAO;

    @Override
    public List<Tag> getAll() {
        return tagDAO.getAll();
    }

    @Override
    public Tag get(Long id) {
        return tagDAO.get(id);
    }

    @Override
    public void create(Tag tag) {
        tagDAO.create(tag);
    }

    @Override
    public void delete(Long id) {
        tagDAO.delete(id);
    }
}
