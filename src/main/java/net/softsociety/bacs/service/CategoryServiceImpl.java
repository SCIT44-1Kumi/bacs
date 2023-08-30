package net.softsociety.bacs.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.dao.CategoryDAO;
import net.softsociety.bacs.domain.BacsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    CategoryDAO dao;

    @Override
    public boolean createCategory(BacsCategory category)
    {
     return dao.createCategory(category);
    }

}
