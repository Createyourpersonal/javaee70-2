package cn.zj.springmvc.service;

import java.util.List;

import cn.zj.springmvc.pojo.BasicDict;
import cn.zj.springmvc.pojo.Customer;
import cn.zj.springmvc.pojo.CustomerInfo;
import cn.zj.springmvc.utils.Page;

public interface CustomerService {

	List<BasicDict> showInfoByDIctTypeCode(String dictTypecode);

	Page<Customer> getCustomerByInfo(CustomerInfo customerInfo, Integer page);

	Customer getCustomerById(long id);

	void updateCustomer(Customer customer);

	void deleteById(int id);

}
