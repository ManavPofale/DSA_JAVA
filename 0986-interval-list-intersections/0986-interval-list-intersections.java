// class Solution {
//     public int[][] intervalIntersection(int[][] firstlist, int[][] secondlist) {
//         List<int[]> ans = new ArrayList<>();

//         for(int i=0;i<firstlist.length;i++){
//             for(int j=0;j<secondlist.length;j++){
//                 int start = Math.max(firstlist[i][0], secondlist[j][0]);
//                 int end = Math.min(firstlist[i][1], secondlist[j][1]);
//                 if(start<=end){
//                     ans.add(new int[]{start,end});
//                 }    
//             }
//         }
//         return ans.toArray(new int[ans.size()][]);
//     }
// }


class Solution {
    public int[][] intervalIntersection(int[][] firstlist, int[][] secondlist) {
        List<int[]> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i<firstlist.length && j<secondlist.length){
            int start = Math.max(firstlist[i][0],secondlist[j][0]);
            int end = Math.min(firstlist[i][1],secondlist[j][1]);

            if(start<=end){
                ans.add(new int[]{start,end});
            }
            if(firstlist[i][1]<secondlist[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}        