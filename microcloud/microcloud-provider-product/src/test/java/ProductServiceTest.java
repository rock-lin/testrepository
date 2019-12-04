import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ctc.wstx.sr.InputProblemReporter;

import cn.enjoy.ProductApp;
import cn.enjoy.service.IProductService;

@SpringBootTest(classes=ProductApp.class)
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Resource
    private IProductService productService;
    
    @Test
    public void test1(){
        
//        productService.update(null);
//        productService.update2(null);
        
//        System.out.println(">>>>>>>>>>>>>>>>>>>"+productService.get(6).getProductDesc());
//        System.out.println(">>>>>>>>>>>>>>>>>>>"+productService.get(7).getProductDesc());
        for(int i= 0; i<1; i++){
            new Thread(new MyThread()).start();
            new Thread(new MyThread2()).start();
        }
    }
    
    class MyThread implements Runnable {

        @Override
        public void run() {
            productService.update(null);
        }
    }
    
    class MyThread2 implements Runnable {

        @Override
        public void run() {
            productService.update2(null);
        }
    }
}
