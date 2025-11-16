/*
 * public class Main6 {
 * 
 * // dissimilarity matrix for the categorical variables
 * 
 * public static void main(String[] args) {
 * String[][] data = {
 * { "A", "B", "C", "R" },
 * { "K", "D", "E", "W" },
 * { "E", "B", "L", "Q" }
 * };
 * int n = data.length;
 * int m = data[0].length;
 * double[][] res = new double[n][m];
 * for (int i = 0; i < n; i++) {
 * for (int j = 0; j < n; j++) {
 * if (i == j)
 * res[i][j] = 0;
 * else {
 * int diff = 0;
 * for (int k = 0; k < m; k++) {
 * if (data[i][k] != data[j][k]) {
 * diff += 1;
 * res[i][j] = diff;
 * 
 * }
 * }
 * res[i][j] = diff / m;
 * }
 * 
 * }
 * }
 * for (double[] row : res) {
 * for (double val : row) {
 * System.out.print(val + " ");
 * 
 * }
 * System.out.println();
 * }
 * }
 * 
 * }
 * 
 * // assymetric binary objects
 * 
 * import java.util.Arrays;
 * import java.util.HashMap;
 * import java.util.HashSet;
 * import java.util.Set;
 * import java.util.*;
 * 
 * public class Main6 {
 * public static double dist(Set<Integer> a, Set<Integer> b) {
 * Set<Integer> intersection = new HashSet<>(a);
 * intersection.retainAll(b);
 * Set<Integer> union = new HashSet<>(a);
 * union.addAll(b);
 * return 1.0 - (double) intersection.size() / union.size();
 * 
 * }
 * 
 * public static double[][] dissim(List<Set<Integer>> objects) {
 * int n = objects.size();
 * double[][] res = new double[n][n];
 * for (int i = 0; i < n; i++) {
 * for (int j = i; j < n; j++) {
 * double val = dist(objects.get(i), objects.get(j));
 * res[i][j] = val;
 * res[j][i] = val;
 * }
 * }
 * return res;
 * 
 * }
 * 
 * public static void main(String[] args) {
 * List<Set<Integer>> objects = Arrays.asList(
 * new HashSet<>(Arrays.asList(1, 2, 3)),
 * new HashSet<>(Arrays.asList(1, 2, 7)),
 * new HashSet<>(Arrays.asList(1, 5, 3)));
 * double[][] res = dissim(objects);
 * for (double[] row : res) {
 * System.out.println(Arrays.toString(row));
 * }
 * 
 * }
 * }
 * 
 * import java.util.Arrays;
 * 
 * public class Main6{
 * public static double[][] dissim(boolean[][] data){
 * int n =data.length;
 * double[][]res=new double[n][n];
 * for(int i=0;i<n;i++){
 * for(int j =i;j<n;j++){
 * int diff=0;
 * for(int k=0;k<n;k++){
 * if(data[i][k]!=data[j][k]){
 * diff+=1;
 * 
 * }
 * }
 * res[i][j]=diff;
 * res[j][i]=diff;
 * 
 * }
 * }
 * return res;
 * 
 * }
 * public static void main(String[] args) {
 * 
 * boolean[][] data={
 * { true, false, true, true }, // Object 1
 * { true, true, false, true }, // Object 2
 * { false, false, true, true }
 * };
 * double[][] res=dissim(data);
 * for (double[] row: res){
 * System.out.println(Arrays.toString(row));
 * }
 * 
 * }
 * }
 */