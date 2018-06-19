package interviewbit;

import java.util.Stack;

public class MinStack {

	public Stack<Integer> data = new Stack<>();
	public Stack<Integer> min = new Stack<>();

	public void push(int x) {
		data.push(x);
		if (min.isEmpty() || min.peek() >= x) {
			min.push(x);
		}
	}

	public void pop() {
		if (data.isEmpty()) {
			if (!min.isEmpty()) {
				System.out.println("FAILURE");
			}
			return;
		}
		if (min.peek().equals(data.peek())) {
			min.pop();
		}
		data.pop();
	}

	public int top() {
		if (data.isEmpty()) {
			return -1;
		}
		return data.peek();
	}

	public int getMin() {
		if (min.isEmpty()) {
			return -1;
		}
		return min.peek();
	}

	public static void main(String[] args) {
		String data = "913 p P 644643544 g t t t p P 723943208 p P 909204 g t g t P 481523691 p P 465865082 t P 243519307 p t p P 844871295 g P 573041392 P 468497349 p t g P 776647984 t p t P 884224920 t t p P 626132265 g t P 26748055 g g P 720873676 P 31868025 P 118819922 t g p P 12108907 g p p p t P 895351682 g t P 127364950 g t P 76234642 g t g P 940134342 g p t g P 209923674 g p p P 593912449 g t P 182168561 P 252333986 g P 120254050 g t t g P 281700253 t p p P 107300696 P 83179520 p t t p P 743998858 P 348668934 t t P 238471928 P 185805946 P 345076113 g p P 612934366 p P 646116941 g t P 488822038 g g g P 656668538 g p t g P 205786971 g p p g t g p g t t t P 250759605 g P 696981907 g p p p g g t t p P 660016257 P 254799527 p p g t g g t g p t p P 548011103 p g p t g p P 598697340 p g P 89970109 g t t P 528152523 t p P 750873206 t t P 125328730 g t p t P 860096457 t t p g g P 561229779 g t p t t t g p t t g t g t p P 243176345 P 488648003 g P 22516828 P 80428842 g p g t g p P 112478235 p p g g P 750671046 g g p t P 632746483 g g g g g p g P 168809210 p P 517352357 t p p P 901370929 p g P 69043217 p p p t g P 847833679 t p p t t t t p p g t P 349308524 P 652875950 t P 606686342 P 431329509 p t g t t P 917778387 g t P 588497480 p P 118202971 t P 809454497 t g g p t t P 983614607 p P 500383473 g P 724206024 g t t P 554200746 p t p p p t p p t t t t P 88588979 g p g P 926280810 g t g g P 7007596 p g g t t g p t P 299898202 p P 176651727 p P 625298442 g g P 964576672 g t p p t p g t P 824230322 g g t p p t g p g P 659267334 p P 686616200 p P 54394415 t P 12936572 g P 823626948 P 296766867 g P 335749563 P 904935349 g g p g p t P 754491210 t t g p p p p p p P 36886338 p p p g p P 780809279 t P 57337424 P 998849637 t p P 514381243 p t t t p P 814651044 g P 241546604 P 358242178 p p t t g g p t p P 89830827 t g P 240798522 P 247368207 P 730272441 P 662618586 t p t p t P 621571093 g g t p P 650001396 p t P 38553589 p g t t p g g g p t P 997480662 P 136877685 t p P 278152626 t g t t t P 157969343 g p p p p p g P 651164025 p P 229722550 g t g p P 351226886 p p P 121870305 g g t p p p p P 2843013 p P 618922784 t t g P 462348827 g p p P 604617481 t g g p g g p p P 541892421 P 9071319 t P 237859914 g P 51389970 P 585997077 p P 369222651 t p g g p g p P 670239380 g p P 106123423 P 327003375 t g g g P 525338387 P 972120060 P 78041206 g p t p g p t t t t t t g g g p p g t t p p P 895785982 g P 593298567 t P 152298972 g p p g t t t t P 402633899 P 86452767 g P 126101020 t p p p P 576987968 t p p g g t p t t t p p P 709040762 g g g g g P 135410678 P 468694199 p p t t g P 533112170 P 754858929 p g g p p g P 103302239 t g P 842320959 p t t P 731860400 g t p p g p g g g P 787907999 p t t p g P 373884541 g t P 98601703 p p t p p p g P 280232551 t P 121479941 t P 750771195 P 841602601 p p p p t P 792761407 p p p p t P 304880476 t g t t P 45007612 P 39553022 g g g t t p P 174625619 g t t p t g g p P 135094596 g P 2359009 t P 312614429 p g g g g p p g p t t p p t p t P 186258833 P 964834539 t P 934935549 t g g t p p P 353623991 t P 826395666 P 386343072 g p p P 349547603 P 179753601 P 492794836 P 580149290 P 165212936 g P 1670863 t P 784959420 g p g p p g t t P 21842309 P 337081522 P 777712799 t P 555402283 g t g P 75160257 g g g g g p p t g g p p p g g P 745438423 g P 691084246 p g t P 88773973 t p g P 372912557 p p p g t t P 911490527 t t P 978231016 g P 55522554 P 29843435 g t p p p t p t t p t g P 263283033 p P 372553608 g p p p P 871047378 p g t t t g p P 54582821 t P 103119643 P 619917644 t g p p P 534201865 g P 688295661 p p p p g p p p g p g P 366155438 g t g g p P 119307898 g g P 337604683 g P 585762794 t P 482263814 t p P 796273641 p t P 891773904 g t P 536501786 g P 136953609 t g P 793669592 p t p t p t p g g p t P 703312633 g p p p t p P 12446017 t t g p p P 660673550 P 970004511 P 859363430 t t p t p g t P 307165825 t t p P 27229714 g t t g g P 955115299 P 829997260 t g p P 464667952 g t g p t g p t g p t p";
		// String data = "11 P 644643544 g P 123 P 123 t t t p p p t";
		String[] input = data.split(" ");

		int n = 1234567890;
		MinStack stack = new MinStack();
		for (int i = 1; i < input.length; i++) {
			String temp = input[i];
			switch (temp) {
			case "P":
				stack.push(Integer.parseInt(input[++i]));
				break;
			case "g":
				System.out.print(stack.getMin() + " ");
				break;
			case "t":
				System.out.print(stack.top() + " ");
				break;
			case "p":
				stack.pop();
				break;
			}

			System.out.println(stack.data.toString() + "" + stack.min.toString());
		}
	}
}
