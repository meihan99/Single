package user;

public class User {
    private String cardID;
    private String cardPassword;
    private String userName;
    private String call;
    private int account;
    public String getCardID() {
    	return cardID;
    }
    public void setCardID(String cardID) {
    	this.cardID=cardID;
    }
    public String getCardPassword() {
    	return cardPassword;
    }
    public void setCardPassword(String cardPassword) {
    	this.cardPassword=cardPassword;
    }
    public String getUserName() {
    	return userName;
    }
    public void setUserName(String userName) {
    	this.userName=userName;
    }
    public String getCall() {
    	return call;
    }
    public void setCall(String call) {
    	this.call=call;
    }
    public int getAccount() {
    	return account;
    }
    public void setAccount(int account) {
    	this.account=account;
    }
}