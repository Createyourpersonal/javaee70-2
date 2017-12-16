package cn.zj.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zj.springmvc.pojo.BasicDict;
import cn.zj.springmvc.pojo.Customer;
import cn.zj.springmvc.pojo.CustomerInfo;
import cn.zj.springmvc.service.CustomerService;
import cn.zj.springmvc.utils.Page;

@Controller
public class CustomerController {

	private static final String sourceCode = "002";
	private static final String industryCode = "001";
	private static final String levelCode = "006";
	@Autowired
	private CustomerService customerService;
	@RequestMapping("list")
	public String showInfo(@RequestParam(defaultValue = "1")Integer page,CustomerInfo customerInfo,Model model) throws Exception{
		//解决get请求乱码问题
		if(customerInfo.getCustName()!=null && customerInfo.getCustName()!=""){
			String custName = customerInfo.getCustName();
			custName = new String(custName.getBytes("iso8859-1"),"utf-8");
			customerInfo.setCustName(custName);
		}
		//请求分页数据
		Page<Customer> custList = customerService.getCustomerByInfo(customerInfo,page);
		//显示下拉选内容
		List<BasicDict> sourceList = customerService.showInfoByDIctTypeCode(sourceCode);
		List<BasicDict> industryList = customerService.showInfoByDIctTypeCode(industryCode);
		List<BasicDict> levelList = customerService.showInfoByDIctTypeCode(levelCode);
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		//数据回显
		model.addAttribute("custName", customerInfo.getCustName());
		model.addAttribute("custSource", customerInfo.getCustSource());
		model.addAttribute("custIndustry", customerInfo.getCustIndustry());
		model.addAttribute("custLevel", customerInfo.getCustLevel());
		//分页数据展示到页面
		model.addAttribute("page",custList);
		return "customer";
	}
	@RequestMapping("edit")
	@ResponseBody
	public Customer getCustomerById(long id){
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	@RequestMapping("update")
	@ResponseBody
	public String updateCustomer(Customer customer){
		customerService.updateCustomer(customer);
		return "No";
	}
	@RequestMapping("deleteById")
	@ResponseBody
	public String deleteById(int id){
		customerService.deleteById(id);
		return "非常不OK";
	}
}
