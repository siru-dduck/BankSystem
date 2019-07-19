package service;


import dao.Bankdao;
import dto.Customerdto;

public class BankService {
	Bankdao dao = new Bankdao();

	public boolean loginCheck(String bankid, String bankpassword) {
		Customerdto dto = new Customerdto();
		boolean result = false;
		dto = dao.readCustomer(bankid);
		
		if(dto!=null && bankpassword.equals(dto.getBankpassword())) {
			result = true;
		}
		return result;
	}

	public boolean regiserCustomer(Customerdto dto) {
		boolean result = dao.createCustomer(dto);
		return result;
	}
	
}