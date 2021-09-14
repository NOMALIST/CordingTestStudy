package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort_9_10814 {

	public static List<Map<String, Object>> lists = new ArrayList<Map<String,Object>>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] str;
		for(int i=1; i<=n; i++) {
			str = br.readLine().split(" ");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("no", i);
			map.put("age", Integer.parseInt(str[0]));
			map.put("name", str[1]);
			
			lists.add(map);
		}
		
		mergeSort(0, n-1);
		
		StringBuilder sb = new StringBuilder();
		
		Map<String, Object> map;
		for(int i=0; i<n; i++) {
			map = lists.get(i);
			sb.append(map.get("age") + " " + map.get("name") + "\n");
		}
		
		System.out.println(sb);
		br.close();
		
		
	}
	
	public static void mergeSort(int start, int end) {
		
		int mid = (start + end) / 2;
		List<Map<String, Object>> sortList = new ArrayList<Map<String,Object>>();
		if(start == end) return;
		
		mergeSort(start, mid);
		mergeSort(mid + 1, end);
		
		int i = start;
		int j = mid + 1;
		while(i <= mid || j <= end) {
			if(i > mid) {
				sortList.add(lists.get(j++));
				continue;
			}
			
			if(j > end) {
				sortList.add(lists.get(i++));
				continue;
			}
			
			if( compareMap( lists.get(i) , lists.get(j) ) ) {
				sortList.add(lists.get(i++));
			} else {
				sortList.add(lists.get(j++));
			}
		}
		
		j=0;
		for(i=start; i<=end; i++) {
			lists.set(i, sortList.get(j++));
		}
	}
	
	public static boolean compareMap(Map<String, Object> a, Map<String, Object> b) {
		// a가 나이가 더 적으면 true, 아니면 false
		// a와 b가 나이가 같고 a가 가입순이 빠르면 true 아니면 false
		boolean res;
		
		int ageA = (int)a.get("age");
		int ageB = (int)b.get("age");
		
		if(ageA < ageB) {
			res = true;
		} else if(ageA > ageB) {
			res = false;
		} else {
			int noA = (int)a.get("no");
			int noB = (int)b.get("no");
			if(noA < noB) {
				res = true;
			} else {
				res = false;
			}
		}
		
		return res;
	}
}
