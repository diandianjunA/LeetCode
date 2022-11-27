/**
 * @param {number} n
 * @return {number}
 */
var magicalString = function(n) {
    let i=2
    let str=['1','2','2']
    let res=1
    let index='1'
    while(str.length<n){
        if(str[i]==='1'){
            res++;
        }else{
            str.push(index)
        }
        str.push(index)
        index=(index==='1'?'2':'1')
        i++;
    }
    while (i<n){
        if(str[i]==='1'){
            res++;
        }
        i++;
    }
    return res;
};
console.log(magicalString(7))