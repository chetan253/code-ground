class BubbleSort{
	public static void main(String args[]){
		int[] arr = new int[]{31,41,59,26,41,58};
		boolean isSorted = false;
		int index = arr.length - 1;
		int limit = 0;
		while(!isSorted){
			isSorted = true;
			while(index > limit){
				if(arr[index] < arr[index - 1]){
					isSorted = false;
					int temp = arr[index];
					arr[index] = arr[index - 1];
					arr[index - 1] = temp;
				}
				index--;
			}
			limit++;
			index = arr.length - 1;
		}
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
