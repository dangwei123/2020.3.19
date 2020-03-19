给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if(numRows<1) return res;
        for(int i=1;i<=numRows;i++){
            List<Integer> row=new ArrayList<>(i);
            for(int j=0;j<i;j++){
                if(j==0||j==i-1){
                    row.add(1);
                }else{
                    int num=res.get(i-2).get(j)+res.get(i-2).get(j-1);
                    row.add(num);
                }
            }
            res.add(row);
        }
        return res;
    }
}

给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new LinkedList<>();
        int up=0;
        int down=matrix.length-1;
        if(down==-1) return res;
        int left=0;
        int right=matrix[0].length-1;
        int i=0;
        while(true){
            i=left;
            while(i<=right){
                res.add(matrix[up][i++]);
            }
            if(++up>down) break;
            i=up;
            while(i<=down){
                res.add(matrix[i++][right]);
            }
            if(--right<left) break;
            i=right;
            while(i>=left){
                res.add(matrix[down][i--]);
            }
            if(--down<up) break;
            i=down;
            while(i>=up){
                res.add(matrix[i--][left]);
            }
            if(++left>right) break;
        }
        return res;
    }
}

给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int row=matrix.length;
        if(row==0) return new int[0];
        int col=matrix[0].length;
        int[] res=new int[row*col];
        int i=0;
        int j=0;
        for(int k=0;k<res.length;k++){
            res[k]=matrix[i][j];
            //偶数向上遍历
            if((i+j)%2==0){
                if(j==col-1){
                    i++;
                }else if(i==0){
                    j++;
                }else{
                    i--;
                    j++;
                }
                //奇数向下遍历
            }else{
                if(i==row-1){
                    j++;
                }else if(j==0){
                    i++;
                }else{
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}

给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。
class Solution {
    public String addBinary(String a, String b) {
        int m=a.length()-1;
        int n=b.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(m>=0||n>=0||carry!=0){
            int num1=m>=0?a.charAt(m--)-'0':0;
            int num2=n>=0?b.charAt(n--)-'0':0;
            int sum=num1+num2+carry;
            sb.append(sum%2);
            carry=sum/2;
        }
        return new String(sb.reverse());
    }
}