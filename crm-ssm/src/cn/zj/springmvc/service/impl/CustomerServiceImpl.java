package cn.zj.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zj.springmvc.mapper.CustomerMapper;
import cn.zj.springmvc.pojo.BasicDict;
import cn.zj.springmvc.pojo.Customer;
import cn.zj.springmvc.pojo.CustomerInfo;
import cn.zj.springmvc.service.CustomerService;
import cn.zj.springmvc.utils.Page;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public List<BasicDict> showInfoByDIctTypeCode(String dictTypecode) {
		List<BasicDict> list = customerMapper.getInfoByDictTypeCode(dictTypecode);
		return list;
	}
	@Override
	public Page<Customer> getCustomerByInfo(CustomerInfo customerInfo, Integer currentPage) {
		Page<Customer> page = new Page<Customer>();
		page.setPage(currentPage);
		int startPage = (currentPage-1)*page.getSize();
		customerInfo.setPage(startPage);
		customerInfo.setSize(page.getSize());
		List<Customer> custList = customerMapper.getCustomerList(customerInfo);
		page.setRows(custList);
		int total = customerMapper.getTotalInfo(customerInfo);
		page.setTotal(total);
		return page;
	}
	@Override
	public Customer getCustomerById(long id) {
		return customerMapper.getCustomerById(id);
	}
	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
		
	}
	@Override
	public void deleteById(int id) {
		customerMapper.deleteById(id);
		
	}

}
