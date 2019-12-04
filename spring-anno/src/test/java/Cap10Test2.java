import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.enjoy.cap10.aop.Calculator;
import com.enjoy.cap10.config.Cap10MainConfig;
import com.enjoy.cap7.config.Cap7MainConfigOfLifeCycle;
import com.enjoy.cap8.bean.Bird;
import com.enjoy.cap8.config.Cap8MainConfig;
import com.enjoy.cap9.bean.Moon;
import com.enjoy.cap9.bean.Sun;
import com.enjoy.cap9.config.Cap9MainConfig;
import com.enjoy.cap9.dao.TestDao;
import com.enjoy.cap9.service.TestService;

public class Cap10Test2 {
	@Test
	public void test01(){
		
	    AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap10MainConfig.class);
		
	    BlockingQueue<Runnable> que = new ArrayBlockingQueue(9); 
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 50, TimeUnit.SECONDS, que);
        
		//Calculator c = new Calculator();
        for(int i=0; i<5; i++){
	    executorService.execute(new Div(app));
        }
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//		Calculator c = app.getBean(Calculator.class);
//		c.div(4, 2);
//		System.out.println(result);
//		app.close();
	}
	
	class Div implements Runnable{
	    AnnotationConfigApplicationContext app;

        @Override
        public void run() {
            MDC.put("fuck",Thread.currentThread().getName());
//            System.out.println(">>>>>>>>>>>>>>>>>");
            Calculator c = app.getBean(Calculator.class);
            System.out.println("ttttttttt"+c.div(4, 2));
        }

        public Div(AnnotationConfigApplicationContext app) {
//            System.out.println(">>>>>appappappapp>>>>>>>>>>>>");
            this.app = app;
        }
	    
	}
}
