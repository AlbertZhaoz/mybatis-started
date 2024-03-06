package org.example.mapper;

import org.example.pojo.Brand;

import java.util.List;

/**
 * ClassName:BrandMapper
 * Package:org.example.mapper
 * Description:
 *
 * @Author AlbertZhao
 * @Create 3/2/2024 9:54 PM
 * @Version 1.0
 */
public interface BrandMapper {
    public List<Brand> selectAllBrand();

    Brand seletOneById(int id);

    Brand selectOneByName(String companyName);
}
