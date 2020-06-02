package jp.co.aforce.beans;

public class LoginBean  {
	//文字列型のusername
	private String username;

	//整数型のpassword
	private String password;

	//文字列型のEmsg
	private String Emsg;



	//インスタンス化
	public LoginBean(){};

	//get
	public String getusername() {
		return this.username;
	}
	public String getpassword() {
		return this.password;
	}
	public String getEmsg() {
		return this.Emsg;
	}



	//set
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmsg(String Emsg) {
		this.Emsg = Emsg;
	}


}
