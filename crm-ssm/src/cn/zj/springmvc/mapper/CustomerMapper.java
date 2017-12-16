package cn.zj.springmvc.mapper;

import java.util.List;

import cn.zj.springmvc.pojo.BasicDict;
import cn.zj.springmvc.pojo.Customer;
import cn.zj.springmvc.pojo.CustomerInfo;

public interface CustomerMapper {

	List<BasicDict> getInfoByDictTypeCode(String dictTypeCode);

	List<Customer>  getCustomerList(CustomerInfo customerInfo);

	int getTotalInfo(CustomerInfo customerInfo);

	Customer getCustomerById(long id);

	void updateCustomer(Customer customer);

	void deleteById(int id);
}
