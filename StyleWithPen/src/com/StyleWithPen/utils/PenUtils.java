package com.StyleWithPen.utils;

import static com.StyleWithPen.utils.PenUtils.updateStock;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;

import com.StyleWithPen.Pen;
import com.StyleWithPen.enums.Brand;
import com.StyleWithPen.enums.Material;
import com.StyleWithPen.exception.PenException;

public class PenUtils {

	public static Pen addPen(String brand, String color, String inkColor, String material, int stock,
			String stock_Update_Date, String stock_Listing_Date, double price, double discounts, List<Pen> penList)
			throws PenException {
		Brand b = Brand.valueOf(brand.toUpperCase());
		Material m = Material.valueOf(material.toUpperCase());
		LocalDate d1 = LocalDate.parse(stock_Listing_Date);
		LocalDate d2 = LocalDate.parse(stock_Update_Date);
		Pen p = new Pen(b, color, inkColor, m, stock, d1, d2, price, discounts);
		validaDuplicate(p, penList);
		validatePenStock(stock);
		System.out.println("validation done");
		return p;

	}

	public static void validatePenStock(int stock) throws PenException {
		if (stock < 10) {
			throw new PenException("less qty");
		}
	}

	public static void validaDuplicate(Pen p, List<Pen> penList) throws PenException {
		if (penList.contains(p)) {
			throw new PenException("Already exists");
		}
	}

	public static Material validate_Material() {
		return null;

	}

	public static Brand validate_Brand() {
		return null;

	}

	public static void updateStock(int count, Pen p, List<Pen> penList) throws PenException {
		validatePenStock(count);
		p.setStock(count);
		p.setStock_Update_Date(LocalDate.now());
		// penList.set(p.getId(), p);
		System.out.println("Updates.......");
	}

	public static Pen updateStocks(int id, int count, List<Pen> penList) throws PenException {
		Pen p = null;
		Pen p1 = new Pen(id);
		if (!penList.contains(p1)) {
			throw new PenException("not exists");
		}
		int i = penList.indexOf(p1);
		p = penList.get(i);
		System.out.println("before " + p);
		p.setStock(count);
		return p;
	}

	public static Pen getPenToUpadateStocks(String brand, String color, String inkColor, String material,
			List<Pen> penList) throws PenException {
		for (Pen p : penList) {
			if (p.getBrand().equals(Brand.valueOf(brand.toUpperCase()))
					&& p.getMaterial().equals(Material.valueOf(material.toUpperCase()))
					&& p.getColor().equalsIgnoreCase(color) && p.getInkColor().equalsIgnoreCase(inkColor)) {
				return p;
			}
		}
		throw new PenException("Pen does not exists in stock");
	}

	public static void discountPen(List<Pen> penList) {

		penList.stream().filter(p -> (Period.between(p.getStock_Listing_Date(), LocalDate.now())).getMonths() > 3)
				.forEach(p -> p.setDiscounts(p.getDiscounts() + 20));
	}

	public static void removeOldPens(List<Pen> penList) {
		System.out.println("removing elem");
		Iterator<Pen> itr = penList.iterator();
		while (itr.hasNext()) {
			Pen p=itr.next();
			if (Period.between(p.getStock_Listing_Date(), LocalDate.now()).getMonths() > 3) {
				System.out.println(p);
				itr.remove();
			}
		}
		;

//		for (Pen p : penList) {
//			if (Period.between(p.getStock_Listing_Date(), LocalDate.now()).getMonths() > 3) {
//				penList.remove(p);
//			}
//		}
	}

	

	public static void removePens() {

	}
}
