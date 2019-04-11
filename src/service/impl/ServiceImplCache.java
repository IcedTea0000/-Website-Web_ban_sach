package service.impl;

import java.util.Hashtable;

public class ServiceImplCache {

	private static Hashtable<String, ServiceImpl>serviceMap=new Hashtable<String, ServiceImpl>();
	
	public static ServiceImpl getService(String serviceName){
		ServiceImpl cachedService=serviceMap.get(serviceName);
		return (ServiceImpl) cachedService.clone();
	}
	
	public static void loadCache(){
		CartItemServiceImpl cartItemService=new CartItemServiceImpl();
		serviceMap.put("cartItem", cartItemService);

		BookServiceImpl bookService=new BookServiceImpl();
		serviceMap.put("book", bookService);

		CartOrderServiceImpl cartOrderService=new CartOrderServiceImpl();
		serviceMap.put("cartOrder", cartOrderService);

		CategoryServiceImpl categoryService=new CategoryServiceImpl();
		serviceMap.put("category", categoryService);
		
		UserServiceImpl userService=new UserServiceImpl();
		serviceMap.put("user", userService);
	}
}
