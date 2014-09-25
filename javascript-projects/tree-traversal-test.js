/*

A visual of this tree is avaliable at http://imgur.com/16IXqeE

Your test case [9, 2, 4, 1, 0, 4, 8, 9, 0, 1] : NO RUNTIME ERRORS (returned value: [0, 0, 0, 0, 0, 0, 0, 0, 0] )
Your test case [9, 1, 4, 2, 0, 4, 8, 9, 0, 1] : NO RUNTIME ERRORS (returned value: [1, 2, 2, 3, 1, 0, 0, 0, 0] )
Your test case [9, 1, 4, 9, 0, 4, 8, 9, 0, 1] : NO RUNTIME ERRORS (returned value: [1, 3, 2, 3, 0, 0, 0, 0, 0] )
*/

function generate_slots(len) {
    var A = [];
    for(;len--;){
        A.push(0);
    }
    
    return A;
}

var A = [];
var tree = {};
var capitol_position;
    
function calcDistances(parent, depth) {
    var children = tree[parent];
    if(!children) return;
    
    var children_length = children.length;
    A[depth] += children_length;
    depth += 1;
    
    for(var c=0;c<children_length;c++) {
        calcDistances(children[c],depth);
    }
}

function solution(T) {
    A = generate_slots(T.length-1);
    
    for(var i=0;i<T.length;i++) {
        var parent = T[i];
        var child  = i;
        
        if(parent === child) {
            capitol_position = parent;
            continue;
        }
        
        if(!tree[parent]) tree[parent] = [child];
        else tree[parent].push(child);
    }
    
    calcDistances(capitol_position,0);
    
    //console.log(capitol_position, tree, A);
    
    return A;
}