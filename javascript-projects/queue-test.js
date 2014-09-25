/*
 given the html fragment:
 <div id="label"></div>

 queue up successive calls to a function to update a div

 Also avaliable at http://jsfiddle.net/kai5263499/7t4448od/
*/

var queueProcessor = (function() {
    var locked = false;
    var queue = [];
    
    return {
      addToQueue: function(s) {
          queue.push(s);
      },
      processQueue: function() {
        console.log('processQueue', queue);
        if(locked) {
          setTimeout(processQueue, 1000);
        } else if(queue.length > 0) {
            locked = true;
            $('#label').html(queue[0]);
            setTimeout(function() {
                $('#label').html('');
                queue.shift();
                locked = false;
                processQueue();
            },1000);
        }
    }
})();

var q = new queueProcessor([]);

var a = function(s) {
    q.addToQueue(s);
    q.processQueue();
}

a("Hello world");
a("Hello Wes");
a("Hello WalMart");