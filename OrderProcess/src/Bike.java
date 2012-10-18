

import java.io.Serializable;

public class Bike implements Serializable {

   /**
    *
    */
   private static final long serialVersionUID = 0L;
   private Long id;
   private Float price;
   private String modelname;
   private String brand;

   public Long getId()
   {
      return id;
   }
   public void setId(Long id)
   {
      this.id = id;
   }

   public Float getPrice()
   {
      return price;
   }
   public void setPrice(Float price)
   {
      this.price = price;
   }

   public String getModelName()
   {
      return modelname;
   }
   public void setModelName(String name)
   {
      this.modelname = name;
   }

   public String toString()
   {
      return "Line Item ID= " + this.id + "\nPrice=" + this.price + "\nShip To=" + this.modelname;
   }
   public String getBrand() {
	return brand;
   }
   public void setBrand(String brand) {
	this.brand = brand;
   }

}
