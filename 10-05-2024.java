class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(arr, k, 0, temp, result);
        return result;
    }

    void solve(int[] arr, int target, int start, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
                break;
            temp.add(arr[i]);
            solve(arr, target - arr[i], i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }}}
