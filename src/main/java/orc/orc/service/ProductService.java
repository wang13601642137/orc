package orc.orc.service;

import orc.orc.domain.Category;
import orc.orc.domain.Product;
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

    public List<Product> findProduct(Product condition) {
        return productMapper.find(condition);
    }

    public void deleteCategory(Integer cid) {
        categoryMapper.deleteByPrimaryKey(cid);
    }

    public void deleteProduct(Integer pid) {
        productMapper.deleteByPrimaryKey(pid);
    }

    public Category getCategoryById(Integer cid) {
        return categoryMapper.selectByPrimaryKey(cid);
    }

    public void modifyCategory(Category record) {
        categoryMapper.updateByPrimaryKey(record);
    }

    public void modifyProduct(Product record) {
        productMapper.updateByPrimaryKeySelective(record);
    }

    public Product getProductById(Integer pid) {
        return productMapper.selectByPrimaryKey(pid);
    }

    public void saveProduct(Product record) {
        productMapper.insert(record);
    }
}
