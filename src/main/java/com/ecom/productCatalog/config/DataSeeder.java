package com.ecom.productCatalog.config;

import com.ecom.productCatalog.model.Category;
import com.ecom.productCatalog.model.Product;
import com.ecom.productCatalog.repository.CategoryRepository;
import com.ecom.productCatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothes");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,clothing,home));


        Product phone = new Product();
        phone.setName("Smartphone");
        phone.setDescription("128GB 8RAM");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(799.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("512 GB SSD disk and 24GB of RAM");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(1339.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Really warm and fluffy");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(199.99);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("Blends all kind of things that u can think of");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(267.59);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender));
    }
}
