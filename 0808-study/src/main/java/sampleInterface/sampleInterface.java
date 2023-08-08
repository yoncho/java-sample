package sampleInterface;

public class sampleInterface {
	//interface define
	/*
	 * interface : 추상화된 메서드들의 집합
	 *  *feature 
	 *  	- method 시그니처만 포함
	 *  	- 다중 상속 지원 (implements)
	 *  	- class간 독립적
	 *  	- 추상화 및 다형성 (override)
	 */
	interface Shape{
		abstract double getArea();
		abstract double getPerimeter();
	}
	
	//class define 
	static class Circle implements Shape{
		private double radius;
		
		public Circle(double radius)
		{
			this.radius = radius;
		}
		
		@Override
		public double getArea()
		{
			return Math.PI * radius * radius;
		}
		
		@Override
		public double getPerimeter()
		{
			return 2 * Math.PI * radius;
		}
	}
	
	public static void main(String[] args)
	{
		Circle circle = new Circle(5);
		System.out.println("원의 면적: " + circle.getArea());
	}
}
