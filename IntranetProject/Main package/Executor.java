import java.util.HashSet;

public class Executor extends Employee {


public Executor() {}
public Executor(String name, String surname, String id, String login, String password, int salary)
{
	super(name, surname, id, login, password, salary);
}
Databases data = Databases.getInstance();
public void viewNewOrders() {
	for(Order a: data.newOrders) {
		System.out.println(a.toString());
	}
}
public void acceptOrder() {
	data.newOrders.lastElement().setStatus("Accepted");
	data.orders.add(data.newOrders.lastElement());
	data.newOrders.remove(data.newOrders.size());

}
public void rejectOrder() {
	data.newOrders.lastElement().setStatus("Rejected");
	data.orders.add(data.newOrders.lastElement());
	data.newOrders.remove(data.newOrders.size());

}
}
