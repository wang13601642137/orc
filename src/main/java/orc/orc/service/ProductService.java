package orc.orc.service;

import orc.orc.domain.Category;
import orc.orc.repository.CategoryMapper;
import orc.orc.repository.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wenjin.wang on 2019/12/27.
 */
@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    public void saveCategory(Category record) {
        categoryMapper.insert(record);
    }

    public List<Category> findCategory(Category condition) {
        return categoryMapper.find(condition);
    }

}
