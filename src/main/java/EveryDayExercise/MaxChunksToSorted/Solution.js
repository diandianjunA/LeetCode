/**
 * @param {number[]} arr
 * @return {number}
 */
var maxChunksToSorted = function(arr) {
    var max=0;
    var res=0;
    for (let i = 0; i < arr.length; i++) {
        max=Math.max(max,arr[i]);
        if(max===i){
            res++;
        }
    }
    return res;
};
