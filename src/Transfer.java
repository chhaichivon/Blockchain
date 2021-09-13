
public class Transfer {
	
	private String fromAccountNo;
	private String fromAccountName;
	private String toAccountNo;
	private String toAccountName;
	private double amount;
	private String currency;
	
	public Transfer(String fromAccountNo, String fromAccountName, String toAccountNo, String toAccountName,
			double amount, String currency) {
		super();
		this.fromAccountNo = fromAccountNo;
		this.fromAccountName = fromAccountName;
		this.toAccountNo = toAccountNo;
		this.toAccountName = toAccountName;
		this.amount = amount;
		this.currency = currency;
	}
	
	public String getFromAccountNo() {
		return fromAccountNo;
	}
	public void setFromAccountNo(String fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}
	public String getFromAccountName() {
		return fromAccountName;
	}
	public void setFromAccountName(String fromAccountName) {
		this.fromAccountName = fromAccountName;
	}
	public String getToAccountNo() {
		return toAccountNo;
	}
	public void setToAccountNo(String toAccountNo) {
		this.toAccountNo = toAccountNo;
	}
	public String getToAccountName() {
		return toAccountName;
	}
	public void setToAccountName(String toAccountName) {
		this.toAccountName = toAccountName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Transfer [fromAccountNo=" + fromAccountNo + ", fromAccountName=" + fromAccountName + ", toAccountNo="
				+ toAccountNo + ", toAccountName=" + toAccountName + ", amount=" + amount + ", currency=" + currency
				+ "]";
	}
}
