class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int res = dp(0, tasks);
        if(res == Integer.MAX_VALUE || res < 0) return -1;
        return res;
    }
    
    public int dp(int i, int[] tasks) {
        if(memo.containsKey(i)) return memo.get(i);
        if(i == tasks.length) return 0;
        else if(i > tasks.length || i == tasks.length - 1) memo.put(i, Integer.MAX_VALUE);
        else if(tasks[i] != tasks[i+1]) memo.put(i, Integer.MAX_VALUE);
        else if(i+2 < tasks.length && tasks[i] == tasks[i+2]){
            memo.put(i, 1 + Math.min(dp(i + 2, tasks), dp(i + 3, tasks)));
        }
        else memo.put(i, 1 + dp(i + 2, tasks));
        return memo.get(i);
    }
}