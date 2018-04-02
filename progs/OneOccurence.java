// Program to find elements with atleast one occurence in each array of K arrays
import java.util.*;
class OneOccurence{
	public static void main(String args[]){
		int[][] arr1 = new int[][]{{0,-1,3,5,1},{-3,5,0,2,3},{5,1,2,0,2}};
		for(int i = 0; i < arr1.length; i++){
			Arrays.sort(arr1[i]);
		}
		int[] temp = arr1[0];
		int ctri = 0, ctrj = 0;
		ArrayList<Integer> oneOccur = new ArrayList<Integer>();
		for(int i = 1; i < arr1.length; i++){
			oneOccur.clear();
			int[] compArr = arr1[i];
			while(ctri < temp.length && ctrj < compArr.length){
				if(temp[ctri] < compArr[ctrj]){
					if(oneOccur.contains(temp[ctri])){
						oneOccur.add(temp[ctri]);
					}
					ctri++;
				}
				else if(temp[ctri] > compArr[ctrj]){
					if(oneOccur.contains(compArr[ctrj]))
						oneOccur.add(compArr[ctrj]);
					ctrj++;
				}
				else{
					oneOccur.add(temp[ctri]);
					ctri++;
					ctrj++;
				}
			}
			ctri = 0;
			ctrj = 0;
			temp = new int[oneOccur.size()];
			for(int j = 0; j < oneOccur.size(); j++){
				temp[j] = oneOccur.get(j);
			}
		}
		for(int i = 0; i < oneOccur.size(); i++){
			System.out.print(oneOccur.get(i)+" ");
		}
		System.out.println();
	}
}
