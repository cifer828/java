import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> ll = combinationSum(new int []{7}, 7);
		for (List<Integer> l: ll)
			System.out.println(l.toString());
		
	}
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ll1= iterSum(candidates, 0, target);
        return ll1;
    }
    
    private static List<List<Integer>> iterSum(int[] candidates, int start, int target) {
        List<List<Integer>> ll1 = new ArrayList<>();
        if (candidates[start] > target) 
            return ll1;
        if (candidates[start] == target) {
        	List<Integer> l = new ArrayList<Integer>();
        	l.add(target);
            ll1.add(l);
            System.out.println(target);
            return ll1;
        }
        ll1 = iterSum(candidates, start, target - candidates[start]);
        for (List<Integer> l: ll1) {
            l.add(candidates[start]);
            System.out.println(l.toString());
        }
        List<List<Integer>> ll2 = iterSum(candidates, start + 1, target);
        ll1.addAll(ll2);
        return ll1;
    }
}