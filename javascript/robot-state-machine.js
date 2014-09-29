/*
 The robot which has an initial position and it accepts a stream of single character commands. 
 The objective of this exercise is to compute the final position of the robot given a string of commands.
 
 Also avaliable at http://jsfiddle.net/kai5263499/09ppm3wh/1/
 */

console.clear();

var commandStr = "LMLMLMLMM";

var commands = commandStr.split('');

var orientation_idx_lookup = {'N':0,'E':1,'S':2,'W':3};

var orientations = ['N','E','S','W'];
var orientation_limit = orientations.length-1;

var mutate = function(state, operation) {
    console.log(state);
    var chunks = state.split(' ');
    console.log(chunks);
    var x = chunks[0];
    var y = chunks[1];
    var orientation = chunks[2];
    
    console.log(x, y, orientation);
    
    var orientation_idx = orientation_idx_lookup[orientation_idx_lookup];
    
    console.log('orientation_idx',orientation_idx);
    
    if(operation == 'L') {
        if(orientation_idx > orientation_limit) orientation_idx = 0;
        else orientation = orientations[orientation_idx+1];
    } else if(operation == 'R') {
        if(orientation_idx==0) orientation_idx=orientation_limit;
        else orientation = orientations[orientation_idx-1];
    } else if(operation == 'M') {
        if(orientation == 'N') y++;
        else if(orientation == 'S') y--;
        else if(orientation == 'E') x++;
        else if(orientation == 'W') x--;
    }
                
    var state = x+' '+y+' '+orientation;
    
    console.log('new state', state);
    
    var nextOp = commands.shift();
    if(!nextOp) return state;
    else return mutate(state, nextOp);
}

var finalState = mutate("1 2 N", commands.shift());
    
console.log(finalState);