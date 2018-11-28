class Solution {
    public double[] calcEquation(String[][] e, double[] values, String[][] q) {
        int length = e.length;
        Map<String, String> root = new HashMap<>();
        Map<String, Double> factor = new HashMap<>();
        for(int i = 0; i < length; i++){
            String r1 = findUpdateParent(root, factor, e[i][0]);
            String r2 = findUpdateParent(root, factor, e[i][1]);
            root.put(r1, r2);
            factor.put(r1, values[i]*factor.get(e[i][1])/factor.get(e[i][0]));
        }
        int qLength = q.length;
        double[] res = new double[qLength];
        for(int i = 0; i< qLength; i++){
            if(root.containsKey(q[i][0]) && root.containsKey(q[i][1])){
                String r1 = findUpdateParent(root, factor, q[i][0]);
                String r2 = findUpdateParent(root, factor, q[i][1]);
                if(!r1.equals(r2)){
                    res[i] = (double)-1;
                }else{
                    res[i] = factor.get(q[i][0])/factor.get(q[i][1]);
                }
            }else {
                res[i] = (double)-1;
            }

        }

        return res;
    }
    
    public String findUpdateParent(Map<String, String> root, Map<String, Double> factor, String s){
        if(!root.containsKey(s)){
            root.put(s,s);
            factor.put(s,(double)1);
            return s;
        } else {
            if(root.get(s).equals(s)){
                return s;
            } else {
                String p = root.get(s);
                String actualP = findUpdateParent(root, factor, p);
                root.put(s,actualP);
                factor.put(s, factor.get(s)*factor.get(p)/factor.get(actualP));
                return actualP;
            }
        }
    }
}
