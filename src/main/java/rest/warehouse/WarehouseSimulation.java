package rest.warehouse;

import rest.model.ProductData;
import rest.model.WarehouseData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WarehouseSimulation {
	
	private double getRandomDouble( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		double rounded = Math.round(number * 100.0) / 100.0; 
		return rounded;
		
	}

	private int getRandomInt( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		Long rounded = Math.round(number); 
		return rounded.intValue();

	}
	
	public WarehouseData getData( String inID ) {
		WarehouseData data = new WarehouseData();
		switch (inID) {
			case "001":
				data.setWarehouseName("Wien Bahnhof");
				data.setWarehouseAddress("Am Hauptbahnhof 1");
				data.setWarehousePostalCode(1100);
				data.setWarehouseCity("Wien");
				data.setWarehouseCountry("Austria");
				break;
		}
		data.setWarehouseID( inID );


		List<ProductData> productDataList = new ArrayList<>();
		List<ProductData> actualProducts = new ArrayList<>();

		productDataList.add(new ProductData("00-443175","Bio Orangensaft Sonne","Getraenk",getRandomInt(0,1000),"Packung 1L"));
		productDataList.add(new ProductData("00-871895","Bio Apfelsaft Gold","Getraenk",getRandomInt(0,1000),"Packung 1L"));
		productDataList.add(new ProductData("01-926885","Ariel Waschmittel Color","Waschmittel",getRandomInt(0,1000),"Packung 3KG"));
		productDataList.add(new ProductData("00-316253","Persil Discs Color","Waschmittel",getRandomInt(0,1000),"Packung 3KG"));
		productDataList.add(new ProductData("00-315252","Milka Alpenmilch Schokolade","Süßwaren",getRandomInt(0,1000),"Tafel 100g"));
		productDataList.add(new ProductData("01-526733","Milka Nussini Riegel","Süßwaren",getRandomInt(0,1000),"Tafel 100g"));

		Random random = new Random();

		while (actualProducts.size() < 2) {
			for(ProductData productData : productDataList) {
				if (random.nextBoolean()) {
					actualProducts.add(productData);
				}
			}
		}

		data.setProducts(actualProducts);

		return data;
		
	}

}
