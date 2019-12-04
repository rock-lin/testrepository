package cn.enjoy.service.impl;

import cn.enjoy.mapper.ProductMapper;
import cn.enjoy.service.IProductService;
import cn.enjoy.vo.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Product get(long id) {
        return productMapper.findById(id);
    }

    @Override
    public boolean add(Product product) {
        return productMapper.create(product);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }

    @Override
    @Transactional
    public boolean update(Product product) {

        for (long i = 1; i < 8; i++) {
            Product product2 = new Product();
            product2.setProductId(i);
//            product2.setProductName("b");
            product2.setProductDesc("productDesc1");
            productMapper.update(product2);
            //            try {
            //              Thread.sleep(100);
            //          } catch (InterruptedException e) {
            //              e.printStackTrace();
            //          }
        }

        //        try {
        //            Thread.sleep(100);
        //        } catch (InterruptedException e) {
        //            // TODO Auto-generated catch block
        //            e.printStackTrace();
        //        }
        //        Product product1 = new Product();
        //        product1.setProductId(6L);
        ////        product1.setProductName("a");
        //        product1.setProductDesc("productDesc");
        //        productMapper.update(product1);

        //         int i = 1/0;
        return true;
    }

    @Override
    @Transactional
    public boolean update2(Product product) {
        for (long i = 7; i > 0; i--) {
            Product product2 = new Product();
            product2.setProductId(i);
//            product2.setProductName("b");
            product2.setProductDesc("productDesc2");
            productMapper.update(product2);
            //            try {
            //              Thread.sleep(100);
            //          } catch (InterruptedException e) {
            //              e.printStackTrace();
            //          }
        }

        //        Product product1 = new Product();
        //        product1.setProductId(6L);
        ////        product1.setProductName("a");
        //        product1.setProductDesc("productDesc");
        //        productMapper.update(product1);
        //        
        ////        try {
        ////            Thread.sleep(100);
        ////        } catch (InterruptedException e) {
        ////            // TODO Auto-generated catch block
        ////            e.printStackTrace();
        ////        }
        //        
        //        Product product2 = new Product();
        //        product2.setProductId(7L);
        ////        product2.setProductName("b");
        //        product2.setProductDesc("productDesc");
        //        productMapper.update(product2);
        //        int i = 1/0;
        return true;
    }
}
