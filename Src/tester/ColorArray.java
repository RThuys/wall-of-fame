package tester;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.imageio.ImageIO;

public class ColorArray {
	static String[] colors = {};
	// "ff0000","00ff00","0000ff"};
	static String begin = "k logo 000100,k ";

	private static String finalCommand = null;

	public static String init(String[] key, String end, String commaRepeat) throws IOException {

		BufferedImage img = ImageIO.read(new File("bin/img/img.bmp"));

		int height = img.getHeight();
		int width = img.getWidth();

		int amountPixel = 0;

		int rgb;
		int red;
		int green;
		int blue;

		String redHex = null;
		String greenHex = null;
		String blueHex = null;

		ArrayList<String> colorkey = new ArrayList<>();

		// System.out.println(height + " " + width + " " + img.getRGB(20, 6));

		for (int h = 1; h < height; h++) {
			for (int w = 1; w < width; w++) {
				amountPixel++;

				rgb = img.getRGB(w, h);
				red = (rgb >> 16) & 0x000000FF;
				green = (rgb >> 8) & 0x000000FF;
				blue = (rgb) & 0x000000FF;

				redHex = Integer.toHexString(red);
				greenHex = Integer.toHexString(green);
				blueHex = Integer.toHexString(blue);
				// System.out.println("Rood " + red + " RoodHex " + redHex);
				// System.out.println("Groen " + green + " Groen Hex " +
				// greenHex);
				// System.out.println("Blauw " + blue + " Blauw Hex " +
				// blueHex);
				StringBuilder temp = new StringBuilder();

				// convertie van hexadecimale waarden waar 1 waarde uitkomt
				// uitbreiden met een 0
				if (redHex.length() == 1) {
					redHex = "0" + redHex;
				}
				if (blueHex.length() == 1) {
					blueHex = "0" + blueHex;
				}
				if (greenHex.length() == 1) {
					greenHex = "0" + greenHex;
				}
				temp = temp.append(redHex);
				temp = temp.append(greenHex);
				temp = temp.append(blueHex);
				colorkey.add(temp.toString());
			}
		}

		System.out.println("amount pixel: " + amountPixel);

		// ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// ImageIO.write(img, "bmp", baos);
		// baos.flush();
		// byte[] imageInByte = baos.toByteArray();
		// baos.close();
		// System.out.println("buf " + imageInByte + " size " +
		// imageInByte.length );
		// for (byte i : imageInByte) {
		// System.out.print(i +" ");
		// }

		// working part
		ArrayList<String> cmnd = new ArrayList<String>();
		cmnd.add(begin);
		int t = 0;
		for (int i = 0; i < key.length; i++) {

			if ( i == 64 || i == 78 || i == 79 || i == 80 || i == 81 || i == 89 || i == 100 || i == 102
					|| i == 106 || i == 110 || i == 110 || i == 111 || i == 112 || i == 114 || i == 115 || i == 116
					|| i == 126) {
				System.out.println("test");
				t = t + 1;
			}
			System.out.println("i= " + i + " t= " + t);
			cmnd.add(key[i] + " " + colorkey.get(t));
			// + colors[(int) (Math.random() * 3)]);
			if (Objects.equals(key[i], "numenter")) {
				cmnd.add(end);
			} else {
				cmnd.add(commaRepeat);
			}
			t++;
		}

		StringBuilder sb = new StringBuilder();
		for (String s : cmnd) {
			sb.append(s);
		}

		finalCommand = sb.toString();
		System.out.println(finalCommand);
		return finalCommand;

	}
}
