package tester;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Main_activity extends Paho {

	static String clr1 = "ff00ff";
	static String clr2 = "0000ff";
	static String clr3 = "ff6600";
	static String clr4 = "66ffff";

	// static String[] colors = { "ff00ff", "ff0000", "00ff00", "0000ff" };

	static String[] color = { clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3,
			clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1,
			clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3,
			clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1,
			clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3,
			clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1, clr2, clr3, clr4, clr1,
			clr2, clr3, clr4 };// 108

	static String[] key = { "esc", "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10", "f11", "f12",
			"print_screen", "scroll_lock", "pause_break", "play", "stop", "prev", "next", "tilde", "1", "2", "3", "4",
			"5", "6", "7", "8", "9", "0", "minus", "equal", "backspace", "insert", "home", "page_up", "num_lock",
			"num_slash", "num_asterisk", "num_minus", "tab", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p",
			"open_bracket", "close_bracket", "del", "end", "page_down", "num7", "num8", "num9", "caps_lock", "a", "s",
			"d", "f", "g", "h", "j", "k", "l", "semicolon", "quote", "dollar", "enter", "num4", "num5", "num6",
			"num_plus", "shift_left", "z", "x", "c", "v", "b", "n", "m", "comma", "period", "slash", "shift_right",
			"arrow_top", "num1", "num2", "num3", "ctrl_left", "win_left", "alt_left", "space", "alt_right", "win_right",
			"menu", "ctrl_right", "arrow_left", "arrow_bottom", "arrow_right", "num0", "num.", "numenter" }; // 108

	static String commaRepeat = ",k ";
	static String end = ",c "; // spatie achter c niet vergeten!
	static String finalCommand;
	static String topic = "/wall/command";
	static String topic2 = "/wall/command1";
	static String host = "tcp://192.168.137.103:1883";

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.out.println("keys: " + key.length);
		System.out.println("colors: " + color.length);

		doPub(ColorArray.init(key, end, commaRepeat), host, topic);
		doPub(ColorArray.init(key, end, commaRepeat), host, topic2);
		// doPub(finalCommand, host, topic2);

	}
}
