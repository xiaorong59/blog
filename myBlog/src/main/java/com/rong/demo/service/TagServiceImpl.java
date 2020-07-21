package com.rong.demo.service;

import com.rong.demo.dao.TagReposiotry;
import com.rong.demo.myException.NotFoundException;
import com.rong.demo.po.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagReposiotry tagReposiotry;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagReposiotry.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagReposiotry.getOne(id);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagReposiotry.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagReposiotry.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagReposiotry.findAllById(converToList(ids));
    }

    private List<Long> converToList(String ids){
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null){
            String[] idarray = ids.split(",");
            for (String s : idarray) {
                list.add(new Long(s));
            }
        }
        return list;
    }

    @Override
    public Tag getTagByName(String name) {
        return tagReposiotry.findByName(name);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagReposiotry.getOne(id);
        if (t == null){
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(tag, t);
        return tagReposiotry.save(t);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagReposiotry.deleteById(id);
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = PageRequest.of(0, size, sort);
        return tagReposiotry.findTop(pageable);
    }
}
