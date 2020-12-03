package co.edu.javeriana.tais2020.laurel.marketplace;

import co.edu.javeriana.tais2020.laurel.marketplace.services.ItemsService;
import co.edu.javeriana.tais2020.laurel.marketplace.services.ItemsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class MarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class, args);
	}

}
