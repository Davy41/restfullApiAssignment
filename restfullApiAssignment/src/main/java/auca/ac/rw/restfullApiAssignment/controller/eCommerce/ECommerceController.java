package auca.ac.rw.restfullApiAssignment.controller.eCommerce;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class ECommerceController {

	public static class Product {
		public Long productId;
		public String name;
		public String description;
		public Double price;
		public String category;
		public Integer stockQuantity;
		public String brand;

		public Product(Long productId, String name, String description, Double price, String category, Integer stockQuantity, String brand) {
			this.productId = productId;
			this.name = name;
			this.description = description;
			this.price = price;
			this.category = category;
			this.stockQuantity = stockQuantity;
			this.brand = brand;
		}
	}

	public List<Long> productId = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L));
	public List<String> name = new ArrayList<>(Arrays.asList("Acme Phone", "Acme Headphones", "Organic T-Shirt", "Espresso Beans"));
	public List<String> description = new ArrayList<>(Arrays.asList("Smartphone with great battery", "Noise-cancelling headphones", "100% organic cotton tee", "Dark roast coffee beans"));
	public List<Double> price = new ArrayList<>(Arrays.asList(699.99, 199.99, 25.0, 15.5));
	public List<String> category = new ArrayList<>(Arrays.asList("Electronics", "Electronics", "Apparel", "Grocery"));
	public List<Integer> stockQuantity = new ArrayList<>(Arrays.asList(50, 30, 120, 0));
	public List<String> brand = new ArrayList<>(Arrays.asList("Acme", "Acme", "GreenThreads", "RoastHouse"));

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < name.size(); i++) {
			products.add(new Product(productId.get(i), name.get(i), description.get(i), price.get(i), category.get(i), stockQuantity.get(i), brand.get(i)));
		}
		return products;
	}

	@GetMapping("/products/{id}")
	public List<Product> getProductById(@PathVariable Long id) {
		for (int i = 0; i < productId.size(); i++) {
			if (productId.get(i).equals(id)) {
				List<Product> product = new ArrayList<>();
				product.add(new Product(productId.get(i), name.get(i), description.get(i), price.get(i), category.get(i), stockQuantity.get(i), brand.get(i)));
				return product;
			}
		}
		return null;
	}

	@GetMapping("/products/category/{category}")
	public List<Product> getProductsByCategory(@PathVariable String category) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < this.category.size(); i++) {
			if (this.category.get(i).equalsIgnoreCase(category)) {
				products.add(new Product(productId.get(i), name.get(i), description.get(i), price.get(i), this.category.get(i), stockQuantity.get(i), brand.get(i)));
			}
		}
		return products;
	}

	@GetMapping("/products/brand/{brand}")
	public List<Product> getProductsByBrand(@PathVariable String brand) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < this.brand.size(); i++) {
			if (this.brand.get(i).equalsIgnoreCase(brand)) {
				products.add(new Product(productId.get(i), name.get(i), description.get(i), price.get(i), category.get(i), stockQuantity.get(i), this.brand.get(i)));
			}
		}
		return products;
	}

	@GetMapping("/products/search")
	public List<Product> searchProducts(@RequestParam String keyword) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < name.size(); i++) {
			if (name.get(i).toLowerCase().contains(keyword.toLowerCase()) || description.get(i).toLowerCase().contains(keyword.toLowerCase())) {
				products.add(new Product(productId.get(i), name.get(i), description.get(i), price.get(i), category.get(i), stockQuantity.get(i), brand.get(i)));
			}
		}
		return products;
	}

	@GetMapping("/products/price-range")
	public List<Product> getProductsByPriceRange(@RequestParam double min, @RequestParam double max) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < price.size(); i++) {
			if (price.get(i) >= min && price.get(i) <= max) {
				products.add(new Product(productId.get(i), name.get(i), description.get(i), price.get(i), category.get(i), stockQuantity.get(i), brand.get(i)));
			}
		}
		return products;
	}

	@GetMapping("/products/in-stock")
	public List<Product> getInStockProducts() {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < stockQuantity.size(); i++) {
			if (stockQuantity.get(i) > 0) {
				products.add(new Product(productId.get(i), name.get(i), description.get(i), price.get(i), category.get(i), stockQuantity.get(i), brand.get(i)));
			}
		}
		return products;
	}

	@PostMapping("/products")
	public String addProduct(@RequestParam String name, @RequestParam String description, @RequestParam double price, @RequestParam String category, @RequestParam int stockQuantity, @RequestParam String brand) {
		this.productId.add((long) (this.productId.size() + 1));
		this.name.add(name);
		this.description.add(description);
		this.price.add(price);
		this.category.add(category);
		this.stockQuantity.add(stockQuantity);
		this.brand.add(brand);
		return "Product added successfully";
	}

	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable Long id, @RequestParam String name, @RequestParam String description, @RequestParam double price, @RequestParam String category, @RequestParam int stockQuantity, @RequestParam String brand) {
		for (int i = 0; i < productId.size(); i++) {
			if (productId.get(i).equals(id)) {
				this.name.set(i, name);
				this.description.set(i, description);
				this.price.set(i, price);
				this.category.set(i, category);
				this.stockQuantity.set(i, stockQuantity);
				this.brand.set(i, brand);
				return "Product updated successfully";
			}
		}
		return "Product not found";
	}

	@PutMapping("/products/{id}/stock")
	public String updateStock(@PathVariable Long id, @RequestParam int quantity) {
		for (int i = 0; i < productId.size(); i++) {
			if (productId.get(i).equals(id)) {
				this.stockQuantity.set(i, quantity);
				return "Stock updated successfully";
			}
		}
		return "Product not found";
	}

	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable Long id) {
		for (int i = 0; i < productId.size(); i++) {
			if (productId.get(i).equals(id)) {
				this.productId.remove(i);
				this.name.remove(i);
				this.description.remove(i);
				this.price.remove(i);
				this.category.remove(i);
				this.stockQuantity.remove(i);
				this.brand.remove(i);
				return "Product deleted successfully";
			}
		}
		return "Product not found";
	}
}
