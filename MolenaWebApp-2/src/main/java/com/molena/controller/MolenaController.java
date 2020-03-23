package com.molena.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.molena.model.Product;
import com.molena.service.ProductService;
import com.opencsv.CSVWriter;

@Controller
public class MolenaController {
	
	 @Autowired
	  private ProductService service;
	
	  @RequestMapping(value = "/index")
	   public String index() {
	      return "Molena";
	   }
	  @RequestMapping("/Success")
	  public String success() {
	     return "Success";
	  }
	  @RequestMapping("/view-products")
	  public String viewProducts() {
	     return "view-products";
	  }
	  @RequestMapping("/add-products")
	  public String addProducts() {
	     return "Molena";
	  }
	  @RequestMapping("/new")
	  public String showNewProductPage(Model model) {
	      Product product = new Product();
	      model.addAttribute("product", product);
	       System.out.println(product.getName()+"::::::"+product.getMadein());
	      return "new_product";
	  }
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public String saveProduct(@ModelAttribute("product") Product product) {
	      service.save(product);
	      System.out.println(product.getName()+"::::::"+product.getBrand());
	      String name="";
	      String brand="";
	      name = product.getName();
	      brand= product.getBrand();
	      String[] strArray1 = new String[] {name,brand};
	      String csv = "C:\\\\Users\\\\choprav\\\\Documents\\\\micro\\\\test.csv";
	      CSVWriter writer;
		try {
			writer = new CSVWriter(new FileWriter(csv, true));
		
	        
	      String [] record = "3,David,Feezor,USA,40".split(",");
	      System.out.println("::::::"+strArray1.toString());
	      writer.writeNext(strArray1);
	        
	      writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	      return "redirect:/Success";
	  }
	  public void givenDataArray_whenConvertToCSV_thenOutputCreated( List<String[]> dataLines) throws IOException {
		    File csvOutputFile = new File("C:\\Users\\choprav\\Documents\\micro\\test.csv");
		    try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
		        dataLines.stream()
		          .map(this::convertToCSV)
		          .forEach(pw::println);
		    }
		    //assertTrue(csvOutputFile.exists());
		}
	  public String convertToCSV(String[] data) {
		    return Stream.of(data)
		      .map(this::escapeSpecialCharacters)
		      .collect(Collectors.joining(","));
		}
	  public String escapeSpecialCharacters(String data) {
		    String escapedData = data.replaceAll("\\R", " ");
		    if (data.contains(",") || data.contains("\"") || data.contains("'")) {
		        data = data.replace("\"", "\"\"");
		        escapedData = "\"" + data + "\"";
		    }
		    return escapedData;
		}
}
