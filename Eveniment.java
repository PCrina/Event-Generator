

public class Eveniment {
	int N;
	String type;

	public Eveniment(int N, String type) {
		this.N = N;
		this.type = type;
	}

	//  PRIME
	boolean checkPrime(int n) {
		for(int i = 2; i <= n/2 ; i++)
			if(n % i == 0)
				return false;

		return true;
	}

	public int PRIME() {
		int nr = N;
		while(!checkPrime(nr)) {
			--nr;
		}

		return nr;
	}

	//  FACT
	public int FACT() {
		int nr = 1, p =1;
		while(p <= N) {
			nr++;
			p *= nr;
		}

		return (nr - 1);
	}

	//  SQUARE
	public int SQUARE() {
		int nr = 0;
		while((nr + 1) * (nr + 1) <= N) {
			++nr;
		}

		return nr;
	}

	//  FIB
	int getFibo(int n) {
		int f1, f2, f3;
		f1 = 0;
		f2 = 1;
		f3 = 0;

		if(n == 0)
			return 0;

		if(n == 1)
			return 1;

		for(int i = 2; i <= n; i++) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}

		return f3;
	}

	public int FIBO() {
		int nr = 0;
		while(getFibo(nr + 1) <= N) {
			++nr;
		}

		return nr;
	}

}
