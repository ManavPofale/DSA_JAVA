// class Solution {
//     public int countPrimes(int n) {
//         int count = 0;

//         for(int i = 2; i < n; i++) {
//             if(isPrime(i)) {
//                 count++;
//             }
//         }
//         return count;
//     }
//     public boolean isPrime(int num) {
//         if(num <= 1) {
//             return false;
//         }
//         for(int i = 2; i*i<= num; i++) {

//             if(num % i == 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }


//optimal soluton :
class Solution {
    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        //sare numbers prime he mann lete he
        for(int i=2;i<n;i++){
            isPrime[i] = true;
        }

        //sieve of Eratosthenes algorithm
        for(int i=2;i*i<n;i++){
            if(isPrime[i]){
                //sare i ke multiples ko non-prime proof karo
                for(int j=i*i;j<n;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        //baki bache prime numbers ko count karo
        int count=0;
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }
}        