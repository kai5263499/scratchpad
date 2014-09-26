/*
Implement a malloc system in javascript. There were several caveats with this one including keeping 
track of malloc'd segments and quickly looking up free blocks

Also avaliable at: http://jsfiddle.net/kai5263499/n9tL7wrg/
*/

var buff = "";

var reservedLookup = {
	'21,30':1
};

var reserved = [
	[10,20],
	[21,30],
	[31,40]
];

var lookupFree = function(size,strPos,reservedPos) {
	//starts at 0 using size as end and runs isTaken(start, end) on each block
	//until a free block is found
	var reservedTo = strPos+size;
	if(reservedTo > buff.length) return undefined;
		
	if(strPos < reserved[reservedPos][0] && reservedTo < reserved[reservedPos][0]) return [strPos, reservedTo];
	else {
		lookupFree(size, strPos+reserved[reservedPos][1], reservedPos+1);
	}
}

var alloc = function(numBytes) {
	var freeBlock = lookupFree(numBytes,0,0);
	if(freeBlock == undefined) return freeBlock; // handle case where user cannot allocate memory
	else {
		// splice freeBlock into reserved array
		// add 
	}
};