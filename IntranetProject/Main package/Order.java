
public class Order {
String status,msg; //    New,Accepted,Rejected
Order(){}
Order(String msg){
	this.msg = msg;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
@Override
public String toString() {
	return "Order [status=" + status + ", msg=" + msg + "]";
}

}
