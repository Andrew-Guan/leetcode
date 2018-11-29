class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int length = edges.length;
        int[][] res = new int[length+1][2];// int[length][0] left num,[1] right  [left, right]
        
        for(int i = 0; i < length; i++){
            res[edges[i][0]][0]++;
            res[edges[i][1]][1]++;
        }
        int rightIndex = -1;
        for(int i = 1; i < length+1; i++){
            if(res[i][1] == 2){
                rightIndex = i;
            }
        }
        if(rightIndex != -1){ // the node rightIndex is pointed by two edges.
            int outNum = res[rightIndex][0];
            if(outNum == 0){ // not out from node rightIndex;
                for(int i = length-1; i >= 0; i--){
                    if(edges[i][1] == rightIndex){
                        return edges[i];
                    }
                }
            } else {
                Map<Integer, Integer> poor = new HashMap<>();
                for(int i = 0; i< length; i++){
                    poor.put(edges[i][0], edges[i][1]);
                }
                int[] output = findNext(poor, rightIndex, rightIndex);
                return output;
            }
        }else{

        }
        return edges[0];
    }
    public int[] findNext(Map<Integer, Integer> poor, int currentNode, int rightIndex){
        int nextNode = poor.get(currentNode);
        if(nextNode != rightIndex)
            return findNext(poor, nextNode, rightIndex);
        else {
            int[] output = new int[2];
            output[0] = currentNode;
            output[1] = rightIndex;
            return output;
        }
    }
}
