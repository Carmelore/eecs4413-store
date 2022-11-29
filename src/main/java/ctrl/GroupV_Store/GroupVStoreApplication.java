package ctrl.GroupV_Store;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import models.Product;
import models.ProductJdbcRepository;

@SpringBootApplication
@ComponentScan("models")
@ComponentScan(basePackageClasses = ProductController.class)
public class GroupVStoreApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(GroupVStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GroupVStoreApplication.class, args);
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ProductJdbcRepository repository;

	@Override
	public void run(String... strings) throws Exception {
		
		// verify on startup that both repository methods are able to query the DB
		log.info("Product id 2 -> {}", repository.findById(2));
		List<Product> all = repository.findAll();
		
		for (int i = 0; i < all.size(); i++) {
			log.info("{}", all.get(i));
		}
	}
}
