/*
 Write code to find the crop bounds of the image so that it would effectively be 
 centered on the screen.

 Also avaliable at http://jsfiddle.net/kai5263499/qf3uvej2/
*/

// Criteria: Find the crop points of a black and white image

var imageData = [[0,0,0,1,0,0,0]];

var imageWidth = imageData[0].length-1;
var imageHeight = imageData.length-1;

var isBlack = function(point, func) {
    if(image[point[0]][point[1]] == 1) return point;
    else {
        var newPoint = func(point);
        return isBlack(newPoint, func);
    }
}

var lowerBound = isBlack([0,0],function(point) {
    var newX = point[0]++;
    var newY = point[1];
    if(newX > imageWidth) {
        newX = 0;
        newY++;
        
    }
    var newPoint = [newX, newY];
    return newPoint;
});

