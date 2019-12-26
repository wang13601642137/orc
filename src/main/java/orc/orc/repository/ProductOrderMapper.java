package orc.orc.repository;

import orc.orc.domain.ProductOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated
     */
    int insert(ProductOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated
     */
    int insertSelective(ProductOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated
     */
    ProductOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ProductOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_order
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ProductOrder record);
}