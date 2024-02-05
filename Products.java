	import java.util.*;
	public class Products {
		Vector<Products> ProductsList;
		Vector<Products> CartList;
		protected String Name, Size;
		public String getSize() {
			return Size;
		}
		public void setSize(String size) {
			Size = size;
		}
		protected double Price;
		protected int Quantity, bought_quantity;
		public int getBought_quantity() {
			return bought_quantity;
		}
		public void setBought_quantity(int bought_quantity) {
			this.bought_quantity = bought_quantity;
		}
		public Products()
		{
			ProductsList=new Vector<Products>();
			CartList=new Vector<Products>();
		}
		public Products(String name, double price, int quantity, String size) {
			Name = name;
			Price = price;
			Quantity = quantity;
			Size=size;
		}
		public Vector<Products> getProductsList() {
			return ProductsList;
		}
		public void setProductsList(Vector<Products> productsList) {
			ProductsList = productsList;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public double getPrice() {
			return Price;
		}
		public void setPrice(double price) {
			Price = price;
		}
		public int getQuantity() {
			return Quantity;
		}
		public void setQuantity(int quantity) {
			Quantity = quantity;
		}
		public String toString()
		{
			return this.getName();
		}
		
	}
