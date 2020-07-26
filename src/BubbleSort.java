
class BubbleSort
{
	public static <A extends Comparable<A>> void bubble(A[] arr,int n){
		int length=n;
		for(int i=0;i<length-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(arr[j].compareTo(arr[j+1])>0) {
						A temp=arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp;
				}
			}
		}
		
		for(int k=0;k<n;++k) {
			System.out.print("Sorted Value : "+arr[k]+" ");
			System.out.println();
		}
	}
}  
