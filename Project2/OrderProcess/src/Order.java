

import java.io.Serializable;
import java.util.ArrayList;


public class Order implements Serializable {
	private static final long serialVersionUID = -4620754343715487457L;
	private Long id;
	private ArrayList<Bike> bikeList;
	private String shipTo;

	public ArrayList<Bike> getLineItems() {
		return bikeList;
	}

	public void setLineItems(ArrayList<Bike> lineItems) {
		this.bikeList = lineItems;
	}

	public float getTotalPrice() {
		float totalPrice = 0;
		{
			if (bikeList != null) {
				for (Bike item : bikeList) {
					if (item.getPrice() != null)
						totalPrice += item.getPrice();
				}
			}
		}
		return totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShipTo() {
		return shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("Order ID= " + this.id + "\nTotal Price="
				+ getTotalPrice() + "\nShip to=" + this.shipTo
				+ "\nLine Items:\n");
		if (bikeList != null) {
			for (Bike bike : bikeList) {
				stringBuffer.append("\t ID: " + bike.getId() + "\n");
				stringBuffer.append("\t Name: " + bike.getModelName() + "\n");
				stringBuffer.append("\t Price: " + bike.getPrice() + "\n");
				stringBuffer.append("\t Price: " + bike.getBrand() + "\n");
				
			}
		}
		else
		{
			stringBuffer.append("\t There are no bikes in the list..\n");
		}

		return stringBuffer.toString();
	}

}
