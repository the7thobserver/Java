import java.util.Arrays;

public class StockFinder {
	public static void main(String[] args) {
		StockFinder s = new StockFinder();

		int[] p = { 1, 2, 7, 11, 4 };
		int[] p1 = { 2, 4, 1 };
		int[] p2 = { 3, 2, 6, 5, 0, 3 };
		int[] p3 = { 7, 2, 4, 1 };
		int[] p4 = { 4, 3, 2, 1 };
		int[] p5 = { 2, 4, 5, 2, 9, 7 };
		int[] p6 = { 1, 2, 3, 4 };
		int[] p7 = { 1, 3, 6, 1, 1, 3, 4 };
		int[] p8 = { 10, 0, 10, 0, 10 };
		int[] p9 = { 1, 1, 0 };
		int[] p10 ={2,1,2,1,0,1,2};
		int[] p11 = {1,4,2};
		int[] p12 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423,424,425,426,427,428,429,430,431,432,433,434,435,436,437,438,439,440,441,442,443,444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,462,463,464,465,466,467,468,469,470,471,472,473,474,475,476,477,478,479,480,481,482,483,484,485,486,487,488,489,490,491,492,493,494,495,496,497,498,499,500,501,502,503,504,505,506,507,508,509,510,511,512,513,514,515,516,517,518,519,520,521,522,523,524,525,526,527,528,529,530,531,532,533,534,535,536,537,538,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,554,555,556,557,558,559,560,561,562,563,564,565,566,567,568,569,570,571,572,573,574,575,576,577,578,579,580,581,582,583,584,585,586,587,588,589,590,591,592,593,594,595,596,597,598,599,600,601,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,644,645,646,647,648,649,650,651,652,653,654,655,656,657,658,659,660,661,662,663,664,665,666,667,668,669,670,671,672,673,674,675,676,677,678,679,680,681,682,683,684,685,686,687,688,689,690,691,692,693,694,695,696,697,698,699,700,701,702,703,704,705,706,707,708,709,710,711,712,713,714,715,716,717,718,719,720,721,722,723,724,725,726,727,728,729,730,731,732,733,734,735,736,737,738,739,740,741,742,743,744,745,746,747,748,749,750,751,752,753,754,755,756,757,758,759,760,761,762,763,764,765,766,767,768,769,770,771,772,773,774,775,776,777,778,779,780,781,782,783,784,785,786,787,788,789,790,791,792,793,794,795,796,797,798,799,800,801,802,803,804,805,806,807,808,809,810,811,812,813,814,815,816,817,818,819,820,821,822,823,824,825,826,827,828,829,830,831,832,833,834,835,836,837,838,839,840,841,842,843,844,845,846,847,848,849,850,851,852,853,854,855,856,857,858,859,860,861,862,863,864,865,866,867,868,869,870,871,872,873,874,875,876,877,878,879,880,881,882,883,884,885,886,887,888,889,890,891,892,893,894,895,896,897,898,899,900,901,902,903,904,905,906,907,908,909,910,911,912,913,914,915,916,917,918,919,920,921,922,923,924,925,926,927,928,929,930,931,932,933,934,935,936,937,938,939,940,941,942,943,944,945,946,947,948,949,950,951,952,953,954,955,956,957,958,959,960,961,962,963,964,965,966,967,968,969,970,971,972,973,974,975,976,977,978,979,980,981,982,983,984,985,986,987,988,989,990,991,992,993,994,995,996,997,998,999};
		
		
		long startTime = System.currentTimeMillis();
		System.out.println("MAX PROFIT(10): " + s.maxProfit_v1(p) + " "
				+ Arrays.toString(p));
		System.out.println("MAX PROFIT(2): " + s.maxProfit_v1(p1) + " "
				+ Arrays.toString(p1));
		System.out.println("MAX PROFIT(4): " + s.maxProfit_v1(p2) + " "
				+ Arrays.toString(p2));
		System.out.println("MAX PROFIT(2): " + s.maxProfit_v1(p3) + " "
				+ Arrays.toString(p3));
		System.out.println("MAX PROFIT(0): " + s.maxProfit_v1(p4) + " "
				+ Arrays.toString(p4));
		System.out.println("MAX PROFIT(7): " + s.maxProfit_v1(p5) + " "
				+ Arrays.toString(p5));
		System.out.println("MAX PROFIT(3): " + s.maxProfit_v1(p6) + " "
				+ Arrays.toString(p6));
		System.out.println("MAX PROFIT(5): " + s.maxProfit_v1(p7) + " "
				+ Arrays.toString(p7));
		System.out.println("MAX PROFIT(10): " + s.maxProfit_v1(p8) + " "
				+ Arrays.toString(p8));
		System.out.println("MAX PROFIT(0): " + s.maxProfit_v1(p9) + " "
				+ Arrays.toString(p9));
		System.out.println("MAX PROFIT(2): " + s.maxProfit_v1(p10) + " "
				+ Arrays.toString(p10));
		System.out.println("MAX PROFIT(3): " + s.maxProfit_v1(p11) + " "
				+ Arrays.toString(p11));
		System.out.println("MAX PROFIT(3): " + s.maxProfit_v1(p12) + " "
				+ Arrays.toString(p12));
		long stopTime = System.currentTimeMillis();
		System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.");
		
		startTime = System.currentTimeMillis();
		System.out.println("MAX PROFIT(10): " + s.maxProfit_win(p) + " "
				+ Arrays.toString(p));
		System.out.println("MAX PROFIT(2): " + s.maxProfit_win(p1) + " "
				+ Arrays.toString(p1));
		System.out.println("MAX PROFIT(4): " + s.maxProfit_win(p2) + " "
				+ Arrays.toString(p2));
		System.out.println("MAX PROFIT(2): " + s.maxProfit_win(p3) + " "
				+ Arrays.toString(p3));
		System.out.println("MAX PROFIT(0): " + s.maxProfit_win(p4) + " "
				+ Arrays.toString(p4));
		System.out.println("MAX PROFIT(7): " + s.maxProfit_win(p5) + " "
				+ Arrays.toString(p5));
		System.out.println("MAX PROFIT(3): " + s.maxProfit_win(p6) + " "
				+ Arrays.toString(p6));
		System.out.println("MAX PROFIT(5): " + s.maxProfit_win(p7) + " "
				+ Arrays.toString(p7));
		System.out.println("MAX PROFIT(10): " + s.maxProfit_win(p8) + " "
				+ Arrays.toString(p8));
		System.out.println("MAX PROFIT(0): " + s.maxProfit_win(p9) + " "
				+ Arrays.toString(p9));
		System.out.println("MAX PROFIT(2): " + s.maxProfit_win(p10) + " "
				+ Arrays.toString(p10));
		System.out.println("MAX PROFIT(3): " + s.maxProfit_win(p11) + " "
				+ Arrays.toString(p11));
		System.out.println("MAX PROFIT(3): " + s.maxProfit_v1(p12) + " "
				+ Arrays.toString(p12));
		stopTime = System.currentTimeMillis();
		System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.");
	}
	
	/**
	 * O(n) time, O(1) space
	 * 
	 * @param p
	 * @return
	 */
	public int maxProfit_win(int[] p) {
		if (p == null || p.length == 0)
			return 0;
		if (p.length == 0) {
			return 0;
		}

		int min = p[0];
		int profit = 0;

		for (int i = 1; i < p.length; i++) {
			if (p[i] < min) 
				min = p[i];
			else {
				if (p[i] - min > profit) {
					profit = p[i] - min;
				}
			}
		}

		return profit;
	}

	/**
	 * O(n^2) runtime, O(n) space
	 * @param p
	 * @return
	 */
	public int maxProfit_v1(int[] p) {
		if (p == null || p.length == 0)
			return 0;

		int profit = 0;
		int start = 0;
		int max_profit = 0;
		
		while (start != p.length) {
			int hi = findHighest(p, start);
			int lo = findLowest(p, hi);

			profit = p[hi] - p[lo];
			
			if(profit > max_profit)
				max_profit = profit;
			
			if(start >= p.length)
				return 0;
			else
				start++;
//			System.out.println(profit + " " + start);
			
		}
		return max_profit;
	}

	private int findLowest(int[] p, int hi) {
		int min = Integer.MAX_VALUE;
		int imin = -1;
		
		for(int i = hi; i >= 0; i--)
		{
			if(p[i] < min)
			{
				min = p[i];
				imin = i;
			}
		}
		
		return imin;
	}

	private int findHighest(int[] p, int start) {
		int max = 0;
		int imax = 0;
		
		for(int i = start; i < p.length; i++)
		{
			if(p[i] > max)
			{
				max = p[i];
				imax = i;
			}
		}
		
		return imax;
	}
	
	/*
	 * private int maxProfit_G(int[] p) { if (p == null || p.length == 0) return
	 * 0;
	 * 
	 * // find highets, scan back int high_ind = findHighest(p); int low_ind =
	 * findLowest(p, high_ind);
	 * 
	 * int profit = 0, profit2 = 0; if (check(high_ind, low_ind)) profit =
	 * p[high_ind] - p[low_ind]; System.out.println(high_ind + " " + low_ind +
	 * " " + profit);
	 * 
	 * // find lowest scan forward low_ind = findLowest(p); high_ind =
	 * findHighest(p, low_ind);
	 * 
	 * if (check(high_ind, low_ind)) profit2 = p[high_ind] - p[low_ind];
	 * 
	 * System.out.println(high_ind + " " + low_ind + " " + profit2);
	 * 
	 * if (profit > profit2) return profit; else return profit2; }
	 * 
	 * private boolean check(int high_ind, int low_ind) { return high_ind != -1
	 * && low_ind != -1; }
	 * 
	 * private int findHighest(int[] p, int low_ind) { int max = p[low_ind]; int
	 * ind = -1;
	 * 
	 * for (int i = low_ind; i < p.length; i++) { if (p[i] > max) { max = p[i];
	 * ind = i; } }
	 * 
	 * return ind; }
	 * 
	 * private int findLowest(int[] p) { int min = Integer.MAX_VALUE; int ind =
	 * -1;
	 * 
	 * for (int i = 0; i < p.length; i++) { if (p[i] < min) { min = p[i]; ind =
	 * i; } }
	 * 
	 * return ind; }
	 * 
	 * private int findLowest(int[] p, int high_ind) { int min =
	 * Integer.MAX_VALUE; int ind = -1;
	 * 
	 * for (int i = high_ind; i >= 0; i--) { if (p[i] < min) { min = p[i]; ind =
	 * i; } }
	 * 
	 * return ind; }
	 * 
	 * private int findHighest(int[] p) { int max = 0; int ind = -1;
	 * 
	 * for (int i = 0; i < p.length; i++) { if (p[i] > max) { max = p[i]; ind =
	 * i; } }
	 * 
	 * return ind; }
	 * 
	 * public int maxProfit(int[] p) { if (p == null || p.length
	 * == 0) return 0; if (p.length == 1) return 0;
	 * 
	 * int[] gradiant = new int[p.length]; gradiant[0] = p[0];
	 * 
	 * for (int i = 1; i < gradiant.length; i++) { if (p[i] > p[i -
	 * 1]) gradiant[i] = p[i] + p[i - 1]; else gradiant[i] = p[i]
	 * - p[i - 1];
	 * 
	 * if (gradiant[i] < 0) gradiant[i] = 0; }
	 * 
	 * System.out.println(Arrays.toString(gradiant));
	 * 
	 * int max = -1; int min = Integer.MAX_VALUE; int imax = 0, imin = 0;
	 * 
	 * for (int i = 0; i < gradiant.length; i++) if (gradiant[i] < min) { min =
	 * gradiant[i]; imin = i; }
	 * 
	 * for (int i = imin; i < gradiant.length; i++) if (gradiant[i] >= max) {
	 * max = gradiant[i]; imax = i; }
	 * 
	 * System.out.println(p[imax] + " " + p[imin]);
	 * 
	 * if (p[imax] > p[imin]) return p[imax] - p[imin]; else
	 * return p[imin] - p[imax]; }
	 * 
	 * // 1 buy and 1 sell public int maxProfit_SPACE(int[] p) { if (p
	 * == null || p.length == 0) return 0; if (p.length == 1) return
	 * 0;
	 * 
	 * int max = 0; int min = Integer.MAX_VALUE; int ind_max = -1, ind_min =
	 * Integer.MAX_VALUE;
	 * 
	 * for (int i = 0; i < p.length; i++) { if (p[i] < min) { min =
	 * p[i]; ind_min = i; }
	 * 
	 * } for (int i = ind_min; i < p.length; i++) if (p[i] > max) {
	 * max = p[i]; ind_max = i; }
	 * 
	 * System.out.println("MAX " + max + " at " + ind_max);
	 * System.out.println("MIN " + min + " at " + ind_min);
	 * System.out.println("PROFIT " + (max - min));
	 * 
	 * if (max - min < 0) return 0;
	 * 
	 * return max - min; }
	 */


}
