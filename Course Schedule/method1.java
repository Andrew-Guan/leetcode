class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build a list for all 
        List<Integer>[] adjList = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            adjList[i] = new ArrayList<>();
        }
        // add all ther edges
        for(int[] c: prerequisites){
            adjList[c[1]].add(c[0]);  // [1,0] =>  0 -> 1; 0 is prerequisite
        }
        Set<Integer> white = new HashSet<>();
        Set<Integer> grey = new HashSet<>();
        Set<Integer> black = new HashSet<>();
        for(int i = 0; i< numCourses; i++){
            white.add(i);
        }
        while(!white.isEmpty()){
            int current = white.iterator().next();
            if(findCycleDFS(white, grey, black, adjList, current)){
                return false;
            }
            
        }
        return true;
    }
    public boolean findCycleDFS(Set<Integer> white, Set<Integer> grey, Set<Integer> black, List<Integer>[] adjList, int current ){
        white.remove(current);
        grey.add(current);
        for(int i = 0; i < adjList[current].size(); i++){
            if(white.contains(adjList[current].get(i))){
                if(!findCycleDFS(white, grey, black, adjList,adjList[current].get(i))){
                    continue;
                }else{
                    return true;
                }
            }else if(grey.contains(adjList[current].get(i))){
                return true;
            }else{
                continue;
            }
        }
        grey.remove(current);
        black.add(current);
        return false;
    }
}
