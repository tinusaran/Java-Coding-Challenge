    package dao;
	import entity.Product;
	import entity.User;
	import java.util.ArrayList;
	import java.util.List;
	import exception.UserNotFoundException;
	import exception.OrderNotFoundException;

	public class OrderProcessor implements IOrderManagementRepository {
	    @Override
	    public void createOrder(User user, List<Product> products) {
	    
	    }

	    @Override
	    public void cancelOrder(int userId, int orderId) throws UserNotFoundException,
	    OrderNotFoundException {
	       
	    }

	    @Override
	    public void createProduct(User user, Product product) throws UserNotFoundException {
	        
	    }

	    @Override
	    public void createUser(User user) {
	      
	    }

	    @Override
	    public List<Product> getAllProducts() {
	        
	        return new ArrayList<>();
	    }

	    @Override
	    public List<Product> getOrderByUser(User user) {
	        
	        return new ArrayList<>();
	    }
	}

