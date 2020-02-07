package rectangle;

/**
 * The Rectangle class calculates the area of a rectangle, given the length and width as parameters.
 * Also, an "optional" third parameter, called "units", is used to indicate if a units conversion is required, and if so,
 * the type of conversion. This units conversion specifier is explained as follows:
 * 
 *   ci = Assumes that the length and width values are in centimeters. Area is reported in inches
 *   ic = Assumes that the length and width values are in inches. Area is reported in centimeters.
 *   
 * When the "units" parameter is NOT given, that is, the rectangle class is invoked without this
 * parameter, no units conversion is performed. The Area is calculated as if the length and width are
 * dimensionless.
 * 
 * @author rmagnotta
 * @author Nicolas Mills
 * @version 2020-02-03
 */
public class Rectangle {
	
	/**
	 * Calculates the area of the Rectangle given a length and width
	 * @param length length of the Rectangle
	 * @param width width of the Rectangle
	 * @return area of the resulting Rectangle
	 */
	public static double area(double length, double width)
	{
		return length * width;
	}
	
	/**
	 * Calculates the area of the Rectangle given a length and width,
	 * first converting each measurement based on the conversion String 
	 * provided
	 * @param length length of the Rectangle
	 * @param width width of the Rectangle
	 * @param conversion conversion String determining which unit the 
	 * length and width are converted to before calculation
	 * @return area of the resulting Rectangle, in converted units
	 */
	public static double area(float length, float width, String conversion)
	{
		// Calculate the area first. If an unrecognized conversion String
		// is given, we will just return the area without converting
		double area = area(length, width);
		if (conversion.equals("ci"))
			area = area(length*Convert.c_to_i,width*Convert.c_to_i);
		else if (conversion.equals("ic"))
			area = area(length*Convert.i_to_c,width*Convert.i_to_c);
		return area;
	}

}
