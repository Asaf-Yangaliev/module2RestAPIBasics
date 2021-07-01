package com.epam.esm.controller;

import com.epam.esm.dao.tag.Tag;
import com.epam.esm.service.tag.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;
    private final static String GET_ALL = "/getAll";
    private final static String GET = "/get/{id}";
    private final static String CREATE = "/create";
    private final static String DELETE = "/delete/{id}";

    @GetMapping(GET_ALL)
    public List<Tag> getAll() {
        return tagService.getAll();
    }

    @GetMapping(GET)
    public Tag get(@PathVariable("id") Long id) {
        return tagService.get(id);
    }

    @PostMapping(CREATE)
    public void create(@RequestBody Tag tag) {
        tagService.create(tag);
    }

    @DeleteMapping(DELETE)
    public void delete(@PathVariable("id") Long id) {
        tagService.delete(id);
    }
}
