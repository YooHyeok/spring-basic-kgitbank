package org.zerock.vo;

public class ProductVO {//데이터저장빈 클래스
	
	private String name;//상품명
	private double price;//가격

	public ProductVO(String name, int price) {
		this.name=name;
		this.price=price;
	}//생성자 오버로딩 (set()메서드의 역할)

	public String getName() { //반환해주는 get()메서드
		return name;
	}



	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "ProductVO [name="+name+",price="+price+"]";
	}
	
	
}
