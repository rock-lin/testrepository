package cn.enjoy.controller;
import cn.enjoy.Constant;
import cn.enjoy.service.IProductService;
import cn.enjoy.vo.Product;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
@RestController
@RequestMapping("/prodcut")
public class ProductController {

    @Resource
    private IProductService iProductService;

//    import com.netflix.discovery.DiscoveryClient;
//    import org.springframework.cloud.client.discovery.DiscoveryClient;
    @Resource
    private DiscoveryClient client ; // 进行Eureka的发现服务

    private List<Product> list = new ArrayList<Product>();
    
    @RequestMapping(value="/get/{id}")
    public Object get(@PathVariable("id") long id) {
//        for (int i = 0; i < 10000000; i++) {
//            String s = new String("进行Eureka的发现服务进行Eureka的发现服务进行Eureka的发现服务进"
//                    + "行Eureka的发现服务进行Eureka的发现服务进行Eureka"
//                    + "的发现服务进行Eureka的发现服务进行Eureka的发"
//                    + "现服务进行Eureka的发现服务进行Eureka的发现服务进行Eu"
//                    + "reka的发现服务进行Eureka的发现服务进行Eureka的发现服务"
//                    + "进行Eureka的发现服务进行Eureka的发现服务进行Eureka的发现服"
//                    + "务进行Eureka的发现服务进行Eureka的发现服务进行Eureka的发现服务进行Eur"
//                    + "eka的发现服务进行Eureka的发现服务进行Eureka的发现服务");
//            Product p = new Product();
//            p.setProductDesc(s);
//            p.setProductName(s);
//            list.add(p);
//        }
//        
        return this.iProductService.get(id) ;
    }
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.iProductService.add(product) ;
    }
    @RequestMapping(value="/list")
    public Object list() {
        return this.iProductService.list() ;
    }

    @RequestMapping(value="/update")
    public Object update(@RequestBody Product product) {
        return this.iProductService.update(product) ;
    }

    @RequestMapping("/discover")
    public Object discover() { // 直接返回发现服务信息
        return this.client ;
    }
}










