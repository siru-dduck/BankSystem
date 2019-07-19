package dto;

public class Customerdto {

	private String name;

	private String pinnumber;

	private String address;

	private String bankid;

	private String bankpassword;

	

	@Override

	public boolean equals(Object obj) {

		if(obj instanceof Customerdto) {

			Customerdto cus = (Customerdto) obj;

			if(cus.name.equals(this.name) && cus.pinnumber.equals(this.pinnumber) &&

					cus.address.equals(this.address) && cus.bankid.equals(this.bankid) && cus.bankpassword.equals(this.bankpassword)) {

				return true;	

			}

		}

		return false;

	}

	

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getPinnumber() {

		return pinnumber;

	}

	public void setPinnumber(String pinnumber) {

		this.pinnumber = pinnumber;

	}

	public String getAddress() {

		return address;

	}

	public void setAddress(String address) {

		this.address = address;

	}

	public String getBankid() {

		return bankid;

	}

	public void setBankid(String bankid) {

		this.bankid = bankid;

	}

	public String getBankpassword() {

		return bankpassword;

	}

	public void setBankpassword(String bankpassword) {

		this.bankpassword = bankpassword;

	}

	

	

}