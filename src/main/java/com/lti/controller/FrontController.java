
package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bean.Consumer;
import com.lti.bean.Emi;
import com.lti.bean.Login;
import com.lti.bean.Product;
import com.lti.bean.Transaction;
import com.lti.exceptions.HrExceptions;
import com.lti.services.ConsumerServiceImpl;
import com.lti.services.EmiServiceImpl;
import com.lti.services.LoginServiceImpl;
import com.lti.services.ProductServiceImpl;
import com.lti.services.TransactionServiceImpl;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class FrontController {
	
	@Autowired
	private ConsumerServiceImpl consumerService;
	
	@Autowired
	private EmiServiceImpl emiService;
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private TransactionServiceImpl transactionService;
	
	//Products implementation
	//List Product Details
	//http://localhost:8081/api/v1/product
	@GetMapping("/product")
	public @ResponseBody List<Product> getAllProdList() throws HrExceptions
	{
		return productService.displayProduct();
	}
	
	//Add Product
	//http://localhost:8081/api/v1/addProd
	@PostMapping(value="/addProd",consumes="application/json")
	public @ResponseBody boolean addProdList(@RequestBody Product p) throws HrExceptions
	{
	    return productService.addProduct(p);
	}
	
	//Delete Product
	//http://localhost:8081/api/v1/delProd/34112
	@DeleteMapping(value = "/delProd/{id}")
	public void deleteProd(@PathVariable("id") int id) throws HrExceptions {
		productService.deleteProduct(id);
		System.out.println("Deleted");
	
	}
	
	//Display Product Details by Id
	//http://localhost:8081/api/v1/product/34110
	@GetMapping(value="/product/{id}")
	 public  Product  getProductById(@PathVariable int id) 
	 {
		Product prd=null;
		prd =productService.getProdById(id);
		return prd;
	 }

	//Update Product
	//http://localhost:8081/api/v1/updateProd/34103
	@PutMapping(value="/updateProd/{id}")
	public @ResponseBody boolean updateProd(@PathVariable int id, @RequestBody Product prd) throws HrExceptions{
	     return productService.updateProduct(id, prd);
	}

	
	//Consumer implementation
	//List Consumer Details
	//http://localhost:8081/api/v1/consumer
	@GetMapping("/consumer")
	public @ResponseBody List<Consumer> getConsumerList() throws HrExceptions
	{
		return consumerService.displayConsumer();

	}
	
	//Add Consumer
	//http://localhost:8081/api/v1/addConsumer
	@PostMapping(value="/addConsumer",consumes="application/json")
	public @ResponseBody boolean addConsList(@RequestBody Consumer c) throws HrExceptions
	{
		return consumerService.addConsumer(c);
	}
		
	//Delete Consumer
	//http://localhost:8081/api/v1/delConsumer/60110
	@DeleteMapping(value = "/delConsumer/{id}")
	public void deleteCons(@PathVariable("id") int id) throws HrExceptions {
		consumerService.deleteConsumer(id);
		System.out.println("Deleted");
	
	}
		
	//Update Consumer
	//http://localhost:8081/api/v1/updateConsumer/60102
	@PutMapping(value="/updateConsumer/{id}")
	public @ResponseBody boolean updateCons(@PathVariable int id, @RequestBody Consumer con) throws HrExceptions
	{
		return consumerService.updateConsumer(id, con);
	}
		
	//Activate Consumer
	//http://localhost:8081/api/v1/activateConsumer/60110
	@PutMapping(value="/activateConsumer/{id}")
	public boolean ActivateConsumer(@PathVariable("id") int id) throws HrExceptions 
	{	
		return consumerService.activateConsumer(id);
	}
		
		
	//Login implementation
	//Add Login
	//http://localhost:8081/api/v1/addLogin
	@PostMapping(value="/addLogin",consumes="application/json")
	public @ResponseBody boolean addLoginList(@RequestBody Login l) throws HrExceptions
	{
		return loginService.addLogin(l);
	}
		
	
	//Login Exist
	//http://localhost:8081/api/v1/loginConsumer
	//@GetMapping("/loginConsumer")
	@PostMapping(value="/loginConsumer",consumes="application/json")
	public @ResponseBody int loginConsExist(@RequestBody Login l) throws HrExceptions
	{
		return loginService.loginExists(l);
	}
	
	
	//Change password(Update)
	//http://localhost:8081/api/v1/changePas
	@PutMapping(value="/changePass")
	public @ResponseBody boolean updatePassword(@RequestBody Login l) throws HrExceptions
	{
		return loginService.changePassword(l);
	}
	
	//EMI implementation
	//Add EMI
	//http://localhost:8081/api/v1/addEMI/60109/34110
	@PostMapping(value="/addEMI/{cid}/{pid}",consumes="application/json")
	public @ResponseBody boolean addEmiList(@PathVariable int cid,@PathVariable int pid,@RequestBody Emi e) throws HrExceptions
	{
	    return emiService.addEmi(cid,pid,e);
	}
	
	
	//Update EMI
	//http://localhost:8081/api/v1/updateEMI/60109/34110
	@PutMapping(value="/updateEMI/{cid}/{pid}")
	public @ResponseBody boolean updateEmi(@PathVariable int cid,@PathVariable int pid,@RequestBody Emi e) throws HrExceptions
	{
		return emiService.updateEmi(cid, pid, e);
	}
	
	//Display EMI Card Details
	//http://localhost:8081/api/v1/cardDetails/11111
	@GetMapping("/cardDetails/{cardNo}")
	public @ResponseBody List<Emi> getAllEmiList(@PathVariable int cardNo) throws HrExceptions
	{
		return emiService.displayCardDetails(cardNo);
	}
	
	
	//Transaction implementation
	//Add Transaction 
	//http://localhost:8081/api/v1/addTransaction/60109/34110
	@PostMapping(value="/addTransaction/{cid}/{pid}",consumes="application/json")
	public @ResponseBody boolean addTransList(@PathVariable int cid,@PathVariable int pid,@RequestBody Transaction t) throws HrExceptions
	{
	    return transactionService.addTransaction(cid, pid, t);
	}
	
	
	//Display Transaction Details
	//http://localhost:8081/api/v1/transactionDetails/11111
	@GetMapping("/transactionDetails/{cardNo}")
	public @ResponseBody List<Transaction> getAllTransList(@PathVariable int cardNo) throws HrExceptions
	{
		return transactionService.displayTransaction(cardNo);
	}
	
		
}
