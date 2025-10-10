/* We are given an array asteroids of integers representing asteroids in a row. 
The indices of the asteriod in the array represent their relative position in space.
For each asteroid, the absolute value represents its size, and the sign represents 
its direction (positive meaning right, negative meaning left).Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet. */


import java.util.*;
public class AsteroidsCollision{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n value : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int asteroids[] = new int[n];
        for(int i = 0; i < n; i++){
            asteroids[i] = sc.nextInt();
        }
        int result[] = asteroidCollision(asteroids);
        for(int res : result){
            System.out.print(res + " ");
        }
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int asteroid : asteroids){
            boolean destroyed = false;
            //  Handling left moving asteroid
            while(!st.isEmpty() && asteroid < 0 && st.peek() > 0){
                if(st.peek() < -asteroid){
                    st.pop();
                    continue;
                }
                //  Both equal then destroy both
                else if(st.peek() == -asteroid){
                    st.pop();
                }
                destroyed = true;
                break;
            }
            //  If not destroyed then push it in stack
            if(!destroyed){
                st.push(asteroid);
            }
        }
        //  Convert Stack into Array
        int result[] = new int[st.size()];
        for(int i = result.length - 1; i >= 0; i--){
            result[i] = st.pop();
        }
        return result;
    }
}