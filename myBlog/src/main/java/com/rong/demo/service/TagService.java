package com.rong.demo.service;

import com.rong.demo.po.Tag;
import com.rong.demo.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    Tag saveTag(Tag tag);
    Tag getTag(Long id);
    Page<Tag> listTag(Pageable pageable);
    List<Tag> listTag();
    List<Tag> listTag(String ids);
    Tag getTagByName(String name);
    Tag updateTag(Long id, Tag tag);
    void deleteTag(Long id);
    List<Tag> listTagTop(Integer size);
}
