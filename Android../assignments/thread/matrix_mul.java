
class matrix_mul {
	public static void main(String[] args) {
		int a[][] = { {1,2,3},
		              {4,5,6},
			      {7,8,9}};
		int b[][] = { {1,2,3},
                              {4,5,6},
                              {7,8,9}};
		matrix_multiply(a,b);
	}


public static void matrix_multiply(int[][] a,int[][] b) {
        var rows = a.length;
        var cola = a[0].length;
        var colb = b[0].length;

        Thread[] t = new Thread[rows];

        int[][] result = new int[rows][colb];

        for(int i=0;i<rows;i++) {
		int row = i;
                t[i] = new Thread();
		try{Thread.sleep(1000);}catch(Exception e){}
                for(int j=0;j<colb;j++) {
                        for(int k=0;k<cola;k++) {
                                result[row][j] = a[row][j] * b[k][j];
                        }
                }
                t[i].start();
        }
for(int i=0;i<rows;i++) {
	for(int j=0;j<cola;j++) {
		System.out.println(result[i][j]);

	}
}
}
}




