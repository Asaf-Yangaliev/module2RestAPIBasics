package com.epam.esm.dao.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TagDAOImpl implements TagDAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Tag> getAll() {
        return jdbcTemplate.query("select * from tag;", new TagMapper());
    }

    @Override
    public Tag get(Long id) {
        return jdbcTemplate.queryForObject("select * from tag where id = ?;", new TagMapper(), id);
    }

    @Override
    public void create(Tag tag) {
        jdbcTemplate.update("insert into tag (name) values(?)", tag.getName());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from tag where id = ?", id);
    }
}
