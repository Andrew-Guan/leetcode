class Solution {
    public List<List<String>> wordSquares(String[] words) {
        if(words == null) return null;
        int num = words.length;
        int squareSize = words[0].length();
        List<List<String>> res = new ArrayList<>();
        //List<String> one = new ArrayList<>();
        for(int i = 0; i< num; i++){
            //List<String> one = new ArrayList<>();
            List<Integer> sequence = new ArrayList<>();
            int depth = 0;
            findSquare(res, sequence, words, depth, squareSize, i);
        }
        
        return res;
    }
    public void findSquare(List<List<String>> res, List<Integer> sequence, String[] words,int depth, int squareSize, int i){
        if(depth == squareSize) {
            List<String> one = new ArrayList<>();
            for(int j = 0; j < depth; j++){
                one.add(words[sequence.get(j)]);
            }
            res.add(one);
            return;   
        }else if(depth == 0 ){
            sequence.add(i);
            depth++;
            findSquare(res, sequence, words, depth, squareSize, i);
            return;
        }else {
        	for(int j = 0; j< words.length; j++){
	            if(depth != squareSize && checkItPossible(sequence, words, j, depth)){ // if duplicates are not allowed, we need to add "&& !sequence.contains(j)";
	                List<Integer> sequenceCopy = new ArrayList<>(sequence.subList(0,depth));
	                sequenceCopy.add(j);
	                depth++;
	                findSquare(res, sequenceCopy, words, depth, squareSize, i);
	                depth--;
	            }
        	}
        }
        return;
    }
    public boolean checkItPossible(List<Integer> sequence, String[] words, int j, int depth){
        for(int i = 0; i<depth; i++){
            if(!(words[j].charAt(i) == words[sequence.get(i)].charAt(depth)))
                return false;
        }
        return true;
    }
}
